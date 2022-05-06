package solano.alberto.bl.cliente;

import solano.alberto.bl.conductor.Conductor;
import solano.alberto.bl.direccion.*;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {

    private Connection inicializarBaseDatos() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null;
            String strConneccion = "jdbc:sqlserver://DESKTOP-FMDDBT7:1433;DatabaseName=proyectoProgra;user=sa;password=1234;";
            conn = DriverManager.getConnection(strConneccion);
            return conn;

        } catch (Exception e) {
            throw new Exception("Error en inicializar la conexion con la base de datos" + e);

        }
    }

    public String registrarCliente(Cliente objCliente) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();
            Direccion objDireccion = objCliente.getDireccion();
            Provincia objProvincia = objCliente.getDireccion().getProvincia();
            Canton objCanton = objCliente.getDireccion().getCanton();
            Distrito objDistrito = objCliente.getDireccion().getDistrito();


            CallableStatement palmacenado = conn.prepareCall("{call sp_registrar_Cliente(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            palmacenado.setString(1, objProvincia.getNombre());
            palmacenado.setString(2, objCanton.getNombre());
            palmacenado.setString(3, objDistrito.getNombre());
            palmacenado.setString(4, objDireccion.getDireccionExacta());
            palmacenado.setString(5, objCliente.getNombre());
            palmacenado.setString(6, objCliente.getApellidos());
            palmacenado.setString(7, objCliente.getIdentificacion());
            palmacenado.setString(8, objCliente.getCorreo());
            palmacenado.setString(9, objCliente.getClave());
            palmacenado.setString(10, objCliente.getFechaNacimiento());
            palmacenado.setString(11, objCliente.getAvatar());
            palmacenado.setString(12, objCliente.getGenero());
            palmacenado.setString(13, objCliente.getCelular());
            palmacenado.setInt(14, getRandom());
            palmacenado.registerOutParameter(15, Types.VARCHAR);


            palmacenado.execute();
            String mensaje = palmacenado.getString( 15);
            palmacenado.close();
            conn.close();
            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar Cliente " + e);
        }
    }

    public String registrarDireccion(Direccion objDireccion, String correo) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();

            Provincia objProvincia = objDireccion.getProvincia();
            Canton objCanton = objDireccion.getCanton();
            Distrito objDistrito = objDireccion.getDistrito();


            CallableStatement palmacenado = conn.prepareCall("{call sp_registrar_Direcion(?,?,?,?,?,?)}");

            palmacenado.setString(1, objProvincia.getNombre());
            palmacenado.setString(2, objCanton.getNombre());
            palmacenado.setString(3, objDistrito.getNombre());
            palmacenado.setString(4, objDireccion.getDireccionExacta());
            palmacenado.setString(5, correo);
            palmacenado.registerOutParameter(6, Types.VARCHAR);


            palmacenado.execute();
            String mensaje = palmacenado.getString( 6);
            palmacenado.close();
            conn.close();
            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar Direccion " + e);
        }
    }

    public int getRandom() {
        int min = 100;
        int max = 999;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    public ArrayList<Cliente> obtenerCliente(String correo) throws Exception {

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        DireccionDAO objDireccionDAO = new DireccionDAO();
        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
        rs = stat.executeQuery("select * from vw_cliente where correo = " + "'"+correo+"'");

        while (rs.next()) {
            Provincia objProvincia = objDireccionDAO.devolverProvinciaObj(rs.getString(10));
            Canton objCanton = objDireccionDAO.devolverCantonObj(rs.getString(11), objProvincia.getCodigo());
            Distrito objDistrito = objDireccionDAO.devolverDistritoObj(rs.getString(12), objCanton.getCodigo());

            Direccion objDireccion = new Direccion(objProvincia, objCanton, objDistrito, rs.getString(13));

            Cliente objCliente = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(6), rs.getString(7), objDireccion, rs.getString(9), rs.getString(10),rs.getString(8));

            clientes.add(objCliente);
        }
        rs.close();
        conn.close();
        return clientes;
    }

    public ArrayList<Direccion> obtenerDireccion(String correo) throws Exception {

        ArrayList<Direccion> direccion = new ArrayList<Direccion>();
        DireccionDAO objDireccionDAO = new DireccionDAO();
        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
        rs = stat.executeQuery("select * from vw_direcciones where correo = " + "'"+correo+"'");

        while (rs.next()) {
            Provincia objProvincia = objDireccionDAO.devolverProvinciaObj(rs.getString(1));
            Canton objCanton = objDireccionDAO.devolverCantonObj(rs.getString(2), objProvincia.getCodigo());
            Distrito objDistrito = objDireccionDAO.devolverDistritoObj(rs.getString(3), objCanton.getCodigo());

            Direccion objDireccion = new Direccion(objProvincia, objCanton, objDistrito, rs.getString(4));

            direccion.add(objDireccion);
        }
        rs.close();
        conn.close();
        return direccion;
    }

}
