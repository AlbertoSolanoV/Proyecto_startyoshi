package solano.alberto.bl.conductor;

import solano.alberto.bl.direccion.Canton;
import solano.alberto.bl.direccion.Distrito;
import solano.alberto.bl.direccion.Provincia;
import solano.alberto.bl.direccion.Direccion;
import solano.alberto.bl.direccion.DireccionDAO;

import java.sql.*;
import java.util.ArrayList;

public class ConductorDAO {

    DireccionDAO objDireccionDAO = new DireccionDAO();

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

    public String registrarConductor(Conductor objConductor) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();
            Direccion objDireccion = objConductor.getDireccion();
            Provincia objProvincia = objConductor.getDireccion().getProvincia();
            Canton objCanton = objConductor.getDireccion().getCanton();
            Distrito objDistrito = objConductor.getDireccion().getDistrito();


            CallableStatement palmacenado = conn.prepareCall("{call sp_registrar_Conductor(?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            palmacenado.setString(1, objProvincia.getNombre());
            palmacenado.setString(2, objCanton.getNombre());
            palmacenado.setString(3, objDistrito.getNombre());
            palmacenado.setString(4, objDireccion.getDireccionExacta());
            palmacenado.setString(5, objConductor.getNombre());
            palmacenado.setString(6, objConductor.getApellidos());
            palmacenado.setString(7, objConductor.getIdentificacion());
            palmacenado.setString(8, objConductor.getCorreo());
            palmacenado.setString(9, objConductor.getClave());
            palmacenado.setString(10, objConductor.getFechaNacimiento());
            if (objConductor.isEstado()) {
                palmacenado.setString(11, "1");
            } else {
                palmacenado.setString(11, "0");
            }
            palmacenado.setString(12, objConductor.getAvatar());
            palmacenado.registerOutParameter(13, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(13);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar Conductor " + e);
        }
    }


    public ArrayList<Conductor> obtenerConductores() throws Exception {

        ArrayList<Conductor> conductores = new ArrayList<Conductor>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
        rs = stat.executeQuery("select * from vw_conductores");

        while (rs.next()) {
            Provincia objProvincia = objDireccionDAO.devolverProvinciaObj(rs.getString(10));
            Canton objCanton = objDireccionDAO.devolverCantonObj(rs.getString(11), objProvincia.getCodigo());
            Distrito objDistrito = objDireccionDAO.devolverDistritoObj(rs.getString(12), objCanton.getCodigo());

            Direccion objDireccion = new Direccion(objProvincia, objCanton, objDistrito, rs.getString(13));

            Conductor objConductor = new Conductor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getInt(5), rs.getString(6), rs.getString(7), objDireccion, rs.getBoolean(8), rs.getString(9));

            conductores.add(objConductor);
        }
        rs.close();
        conn.close();
        return conductores;
    }

    public String cambioEstadoConductor(String id, String correo, boolean estado) throws Exception {

        try {

            Connection conn = inicializarBaseDatos();
            CallableStatement palmacenado = conn.prepareCall("{call  sp_editar_estado_conductor(?,?,?,?)}");

            palmacenado.setString(1, id);
            palmacenado.setString(2, correo);
            if (estado) {
                palmacenado.setString(3, "1");
            } else {
                palmacenado.setString(3, "0");
            }
            palmacenado.registerOutParameter(4, Types.VARCHAR);


            palmacenado.execute();
            String mensaje = palmacenado.getString(4);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar Conductor " + e);
        }
    }

    public String conductorPedidoAceptado(String identificacion, String correo, int codPedido) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_conductor_pedido_seleccion(?,?,?,?)}");

            palmacenado.setString(1, identificacion);
            palmacenado.setString(2, correo);
            palmacenado.setInt(3, codPedido);
            palmacenado.registerOutParameter(4, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(4);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar Conductor " + e);
        }
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
            throw new Exception("Error en registrar Conductor " + e);
        }
    }

}
