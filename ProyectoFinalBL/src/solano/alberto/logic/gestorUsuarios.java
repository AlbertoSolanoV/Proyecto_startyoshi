package solano.alberto.logic;

import solano.alberto.bl.direccion.Canton;
import solano.alberto.bl.direccion.Distrito;
import solano.alberto.bl.direccion.Provincia;
import solano.alberto.bl.direccion.Direccion;
import solano.alberto.bl.direccion.DireccionDAO;
import solano.alberto.bl.usuario.Usuario;
import solano.alberto.bl.cliente.Cliente;
import solano.alberto.bl.cliente.ClienteDAO;
import solano.alberto.bl.conductor.Conductor;
import solano.alberto.bl.conductor.ConductorDAO;
import solano.alberto.bl.usuario.UsuarioDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.TreeMap;

public class gestorUsuarios {

    ClienteDAO objClienteDAO = new ClienteDAO();
    UsuarioDAO objUsuarioDAO = new UsuarioDAO();
    ConductorDAO objConductorDAO = new ConductorDAO();
    DireccionDAO objDireccionDAO = new DireccionDAO();

    public String registrarAdministrador(String nombre, String apellidos, String identificacion, String fechaNacimiento,
                                         String correo, String clave, String provincia, String canton, String distrito, String direccionExacta) {
        try {
            String mensaje = validacionRegistro(nombre, apellidos, identificacion, fechaNacimiento, correo, clave, "no", provincia,
                    canton, distrito, direccionExacta, "no", "no");
            if (!mensaje.equals("")) {
                return mensaje;
            }
            Direccion objDireccion = registrarDireccion(provincia, canton, distrito, direccionExacta);
            Usuario objAdministrador = new Usuario(nombre, apellidos, identificacion, fechaNacimiento, 0, correo, clave, objDireccion);
            mensaje = objUsuarioDAO.registrarAdministrador(objAdministrador);
            return mensaje;
        } catch (Exception e) {
            return String.valueOf(e);
        }

    }

    public String registrarConductor(String nombre, String apellidos, String identificacion, String fechaNacimiento,
                                     String correo, String clave, String provincia, String canton, String distrito, String direccionExacta, boolean estado, String avatar) {
        try {
            String mensaje = validacionRegistro(nombre, apellidos, identificacion, fechaNacimiento, correo, clave, avatar, provincia,
                    canton, distrito, direccionExacta, "no", "no");
            if (!mensaje.equals("")) {
                return mensaje;
            }
            Direccion objDireccion = registrarDireccion(provincia, canton, distrito, direccionExacta);
            Conductor objConductor = new Conductor(nombre, apellidos, identificacion, fechaNacimiento, 0, correo, clave, objDireccion, estado, avatar);
            mensaje = objConductorDAO.registrarConductor(objConductor);

            return mensaje;
        } catch (Exception e) {
            return String.valueOf(e);
        }

    }

    public String registrarCliente(String nombre, String apellidos, String identificacion, String fechaNacimiento,
                                   String correo, String clave, String provincia, String canton, String distrito, String direccionExacta,
                                   String avatar, String genero, String celular) {
        try {
            String mensaje = validacionRegistro(nombre, apellidos, identificacion, fechaNacimiento, correo, clave, avatar, provincia,
                    canton, distrito, direccionExacta, genero, celular);
            if (!mensaje.equals("")) {
                return mensaje;
            }

            Direccion objDireccion = registrarDireccion(provincia, canton, distrito, direccionExacta);
            Cliente objCliente = new Cliente(nombre, apellidos, identificacion, fechaNacimiento, correo, clave, objDireccion, avatar, genero, celular);
            mensaje = objClienteDAO.registrarCliente(objCliente);

            return mensaje;
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String conductorAceptadoPedido(String identificacion, String correo,String pedido) {
        try {
            String mensaje = "";

            mensaje = objConductorDAO.conductorPedidoAceptado(identificacion, correo, Integer.parseInt(pedido));

            return mensaje;
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String cambiarEstadoPedido(String estado,String pedido) {
        try {
            String mensaje = "";

            mensaje = objConductorDAO.cambioEstadoPedido(estado, Integer.parseInt(pedido));

            return mensaje;
        } catch (Exception e) {
            return String.valueOf(e);
        }
    }

    public String validacionRegistro(String nombre, String apellidos, String identificacion, String fechaNacimiento,
                                     String correo, String clave, String avatar, String provincia, String canton, String distrito, String direccionExacta,
                                     String genero, String celular) {
        String mensaje = "";

        if (nombre.equals("")) {
            mensaje = mensaje + ", El nombre esta vacio";
        }
        if (apellidos.equals("")) {
            mensaje = mensaje + ", El apellido esta vacio";
        }
        if (identificacion.equals("")) {
            mensaje = mensaje + ", La identificacion esta vacio";
        }
        if (fechaNacimiento.equals("")) {
            mensaje = mensaje + ", La fecha de nacimiento esta vacio";
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaNacimientoEdad = LocalDate.parse(fechaNacimiento, formatter);
            Period edad = Period.between(fechaNacimientoEdad, LocalDate.now());
            if (edad.getYears() < 18) {
                mensaje = mensaje + ", El usuario es menor de edad";
            }
        }


        if (!correo.contains("@")) {
            mensaje = mensaje + ", El correo no es valido";
        }
        if (correo.equals("")) {
            mensaje = mensaje + ", El correo esta vacio";
        }
        if (clave.equals("")) {
            mensaje = mensaje + ", La clave esta vacio";
        }
        if (direccionExacta.equals("")) {
            mensaje = mensaje + ", La direccion exacta esta vacia";
        }
        if (avatar.equals("")) {
            mensaje = mensaje + ", El avatar exacta esta vacio";
        }
        if (genero.equals("")) {
            mensaje = mensaje + ", El genero no esta seleccionado";
        }
        if (celular.equals("")) {
            mensaje = mensaje + ", El celular esta vacio";
        }
        if (provincia.equals("")) {
            mensaje = mensaje + ", La provincia no esta seleccionado";
        }
        if (distrito.equals("")) {
            mensaje = mensaje + ", El distrito no esta seleccionado";
        }
        if (canton.equals("")) {
            mensaje = mensaje + ", El canton no esta seleccionado";
        }


        return mensaje;
    }

    public Direccion registrarDireccion(String provincia, String canton, String distrito, String direccionExacta) {
        try {

            Provincia objProvincia = objDireccionDAO.devolverProvinciaObj(provincia);
            Canton objCanton = objDireccionDAO.devolverCantonObj(canton, objProvincia.getCodigo());
            Distrito objDistrito = objDireccionDAO.devolverDistritoObj(distrito, objCanton.getCodigo());

            Direccion objDireccion = new Direccion(objProvincia, objCanton, objDistrito, direccionExacta);
            return objDireccion;
        } catch (Exception e) {
            return null;
        }
    }

    public String registrarDireccionCliente(String provincia, String canton, String distrito, String direccionExacta, String correo) {
        try {

            Direccion objDireccion = registrarDireccion(provincia, canton, distrito, direccionExacta);
            String mensaje = objClienteDAO.registrarDireccion(objDireccion, correo);
            return mensaje;
        } catch (Exception e) {
            return null;
        }
    }


    public ArrayList<TreeMap<String, String>> imprimirProvincias() throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Provincias = new ArrayList<TreeMap<String, String>>();
            ArrayList<Provincia> listaProvincias = objDireccionDAO.obtenerProvincia();

            for (Provincia objProvincias : listaProvincias) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("Codigo", objProvincias.getCodigo());
                mapa.put("Nombre", objProvincias.getNombre());

                Provincias.add(mapa);
            }

            return Provincias;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirDirecciones(String correo) throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Direcciones = new ArrayList<TreeMap<String, String>>();
            ArrayList<Direccion> listaDireccion = objClienteDAO.obtenerDireccion(correo);

            for (Direccion objDireccion : listaDireccion) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("Provincia", objDireccion.getProvincia().getNombre());
                mapa.put("Canton", objDireccion.getCanton().getNombre());
                mapa.put("Distrito", objDireccion.getDistrito().getNombre());
                mapa.put("DireccionExacta", objDireccion.getDireccionExacta());

                Direcciones.add(mapa);
            }

            return Direcciones;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }


    public ArrayList<TreeMap<String, String>> imprimirCantones() throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Cantones = new ArrayList<TreeMap<String, String>>();
            ArrayList<Canton> listaCantones = objDireccionDAO.obtenerCanton();

            for (Canton objCantones : listaCantones) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("Codigo", objCantones.getCodigo());
                mapa.put("Nombre", objCantones.getNombre());
                mapa.put("CodPro", objCantones.getCodProvincia());

                Cantones.add(mapa);
            }

            return Cantones;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirDistritos() throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Distritos = new ArrayList<TreeMap<String, String>>();
            ArrayList<Distrito> listaDistritos = objDireccionDAO.obtenerDistrito();

            for (Distrito objDistritos : listaDistritos) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("Codigo", objDistritos.getCodigo());
                mapa.put("Nombre", objDistritos.getNombre());
                mapa.put("CodCan", objDistritos.getCodCanton());

                Distritos.add(mapa);
            }

            return Distritos;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirConductores() throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Conductores = new ArrayList<TreeMap<String, String>>();
            ArrayList<Conductor> listaConductores = objConductorDAO.obtenerConductores();

            for (Conductor objConductores : listaConductores) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("Nombre", objConductores.getNombre());
                mapa.put("Apellidos", objConductores.getApellidos());
                mapa.put("Avatar", objConductores.getAvatar());
                mapa.put("Identificacion", objConductores.getIdentificacion());
                mapa.put("Correo", objConductores.getCorreo());
                mapa.put("Clave", objConductores.getClave());
                mapa.put("FechaNacimiento", objConductores.getFechaNacimiento());
                mapa.put("Edad", String.valueOf(objConductores.getEdad()));
                mapa.put("Provincia", objConductores.getDireccion().getProvincia().getNombre());
                mapa.put("Canton", objConductores.getDireccion().getCanton().getNombre());
                mapa.put("Distrito", objConductores.getDireccion().getDistrito().getNombre());
                mapa.put("Direccion Exacta", objConductores.getDireccion().getDireccionExacta());
                mapa.put("Estado", String.valueOf(objConductores.isEstado()));
                Conductores.add(mapa);
            }

            return Conductores;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirCliente(String correo) throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Clientes = new ArrayList<TreeMap<String, String>>();
            ArrayList<Cliente> listaCliente = objClienteDAO.obtenerCliente(correo);

            for (Cliente objCliente : listaCliente) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("Nombre", objCliente.getNombre());
                mapa.put("Apellidos", objCliente.getApellidos());
                mapa.put("Avatar", objCliente.getAvatar());
                mapa.put("Identificacion", objCliente.getIdentificacion());
                mapa.put("Correo", objCliente.getCorreo());
                mapa.put("Clave", objCliente.getClave());
                mapa.put("FechaNacimiento", objCliente.getFechaNacimiento());
                mapa.put("Provincia", objCliente.getDireccion().getProvincia().getNombre());
                mapa.put("Canton", objCliente.getDireccion().getCanton().getNombre());
                mapa.put("Distrito", objCliente.getDireccion().getDistrito().getNombre());
                mapa.put("Direccion Exacta", objCliente.getDireccion().getDireccionExacta());
                mapa.put("Celular", objCliente.getCelular());
                mapa.put("Sexo", objCliente.getGenero());

                Clientes.add(mapa);
            }

            return Clientes;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public String existeAdmin() throws Exception {
        try{

            return objUsuarioDAO.existeAdmin();

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }

    public String validarLogin(String correo, String clave) throws Exception {
        try{

            return objUsuarioDAO.validacionUsuarioLogin(correo,clave);

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }


    public String cambioEstadoConductor(String id, String correo, boolean estado) throws Exception {
        try{

            return objConductorDAO.cambioEstadoConductor(id, correo, estado);

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }



}
