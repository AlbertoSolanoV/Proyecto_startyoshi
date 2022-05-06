package solano.alberto.bl.pedido;

import solano.alberto.bl.direccion.Canton;
import solano.alberto.bl.direccion.Direccion;
import solano.alberto.bl.direccion.Distrito;
import solano.alberto.bl.direccion.Provincia;
import solano.alberto.bl.servicio.Servicio;
import solano.alberto.bl.vehiculo.Carro;
import solano.alberto.bl.vehiculo.Moto;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class PedidoDAO {

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

    public int registrarPedido(Direccion objDireccion, String correo, String identificacion, String numeroTarjeta) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            Provincia objProvincia = objDireccion.getProvincia();
            Canton objCanton = objDireccion.getCanton();
            Distrito objDistrito = objDireccion.getDistrito();

            CallableStatement palmacenado = conn.prepareCall("{call sp_crear_pedido(?,?,?,?,?,?,?,?)}");

            palmacenado.setString(1, correo);
            palmacenado.setString(2, identificacion);
            palmacenado.setString(3, objProvincia.getNombre());
            palmacenado.setString(4, objCanton.getNombre());
            palmacenado.setString(5, objDistrito.getNombre());
            palmacenado.setString(6, objDireccion.getDireccionExacta());
            palmacenado.setString(7, numeroTarjeta);
            palmacenado.registerOutParameter(8, Types.INTEGER);

            palmacenado.execute();
            int mensaje = palmacenado.getInt(8);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar un pedido " + e);
        }
    }

    public String registrarPedidoServicio(int codPedido, Servicio objServicio) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_crear_pedido_servicios(?,?,?,?)}");

            palmacenado.setInt(1, codPedido);
            palmacenado.setString(2, objServicio.getTipo());
            palmacenado.setString(3,objServicio.getDescripcion());
            palmacenado.registerOutParameter(4, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(4);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar un automovil " + e);
        }
    }

    public String registrarPedidoConductor(int codPedido, String correo) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_conductor_pedido_seleccion(?,?,?)}");

            palmacenado.setString(1, correo);
            palmacenado.setInt(2, codPedido);
            palmacenado.registerOutParameter(3, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(3);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar un conductor_pedido " + e);
        }
    }

    public ArrayList<TreeMap<String, String>> obtenerPedido() throws Exception {

        ArrayList<TreeMap<String, String>> Pedidos = new ArrayList<TreeMap<String, String>>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        rs = stat.executeQuery("select * from vw_pedidos_servicio where estado = 'Registrado'");

        while (rs.next()) {
            TreeMap<String, String> mapa = new TreeMap<String, String>();

            mapa.put("Codigo", rs.getString(1));
            mapa.put("Descripcion", rs.getString(2));
            mapa.put("FechaCreacion", rs.getString(3));
            mapa.put("Estado", rs.getString(4));
            mapa.put("Provincia", rs.getString(5));
            mapa.put("Canton", rs.getString(6));
            mapa.put("Distrito", rs.getString(7));


            Pedidos.add(mapa);
        }
        rs.close();
        conn.close();
        return Pedidos;
    }
    public ArrayList<TreeMap<String, String>> obtenerPedidoConductor(String identificacion) throws Exception {

        ArrayList<TreeMap<String, String>> Pedidos = new ArrayList<TreeMap<String, String>>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        rs = stat.executeQuery("select * from vw_pedidos_servicio_conductor where correo ="+"'"+ identificacion+"'");

        while (rs.next()) {

            TreeMap<String, String> mapa = new TreeMap<String, String>();
            mapa.put("Codigo", rs.getString(1));
            mapa.put("Descripcion", rs.getString(2));
            mapa.put("FechaCreacion", rs.getString(3));
            mapa.put("Estado", rs.getString(4));
            mapa.put("Provincia", rs.getString(5));
            mapa.put("Canton", rs.getString(6));
            mapa.put("Distrito", rs.getString(7));


            Pedidos.add(mapa);
        }
        rs.close();
        conn.close();
        return Pedidos;
    }

    public ArrayList<TreeMap<String, String>> obtenerPedidoCliente(String identificacion) throws Exception {

        ArrayList<TreeMap<String, String>> Pedidos = new ArrayList<TreeMap<String, String>>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        rs = stat.executeQuery("select * from vw_pedidos_servicio where identificacion ="+"'"+ identificacion+"'");

        while (rs.next()) {
            TreeMap<String, String> mapa = new TreeMap<String, String>();
            mapa.put("Codigo", rs.getString(1));
            mapa.put("Descripcion", rs.getString(2));
            mapa.put("FechaCreacion", rs.getString(3));
            mapa.put("Estado", rs.getString(4));
            mapa.put("Provincia", rs.getString(5));
            mapa.put("Canton", rs.getString(6));
            mapa.put("Distrito", rs.getString(7));


            Pedidos.add(mapa);
        }
        rs.close();
        conn.close();
        return Pedidos;
    }

    public String cambioEstadoPedido(String estado, int codPedido) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_pedido_cambio_estado(?,?,?)}");

            palmacenado.setString(1, estado);
            palmacenado.setInt(2, codPedido);
            palmacenado.registerOutParameter(3, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(3);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en cambio de estado de pedido" + e);
        }
    }
}
