package solano.alberto.bl.servicio;

import solano.alberto.bl.conductor.Conductor;
import solano.alberto.bl.direccion.*;

import java.sql.*;
import java.util.ArrayList;

public class ServicioDAO {

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

    public String registrarServicio(Servicio objServicio) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_registrar_servicio(?,?,?,?,?,?)}");

            palmacenado.setString(1, objServicio.getTipo());
            palmacenado.setString(2, objServicio.getDescripcion());
            palmacenado.setDouble(3, objServicio.getPrecioBase());
            if (objServicio.isEstado()) {
                palmacenado.setString(4, "1");
            } else {
                palmacenado.setString(4, "0");
            }
            palmacenado.setDouble(5, objServicio.getPrecioLitro());
            palmacenado.registerOutParameter(6, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(6);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar Servicio " + e);
        }
    }

    public String modificarServicio(String tipo, String descripcion, boolean estado ) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_modificar_servicio(?,?,?,?)}");

            palmacenado.setString(1, tipo);
            palmacenado.setString(2, descripcion);
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
            throw new Exception("Error en modificar estado de servicio " + e);
        }
    }

    public ArrayList<Servicio> obtenerServicios() throws Exception {

        ArrayList<Servicio> servicios = new ArrayList<Servicio>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
        rs = stat.executeQuery("select * from vw_Servicios");

        while (rs.next()) {

            Servicio objServicio = new Servicio(rs.getString(2), rs.getString(3), rs.getDouble(4),
                    rs.getString(1), rs.getBoolean(5), rs.getDouble(6));

            servicios.add(objServicio);
        }
        rs.close();
        conn.close();
        return servicios;
    }

    public ArrayList<Servicio> obtenerServiciosActivo() throws Exception {

        ArrayList<Servicio> servicios = new ArrayList<Servicio>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
        rs = stat.executeQuery("select * from vw_Servicios where estado = '1'");

        while (rs.next()) {

            Servicio objServicio = new Servicio(rs.getString(2), rs.getString(3), rs.getDouble(4),
                    rs.getString(1), rs.getBoolean(5), rs.getDouble(6));

            servicios.add(objServicio);
        }
        rs.close();
        conn.close();
        return servicios;
    }

    public ArrayList<Servicio> obtenerServiciosTipo() throws Exception {

        ArrayList<Servicio> servicios = new ArrayList<Servicio>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
        rs = stat.executeQuery("select * from vw_Servicios_tipos");

        while (rs.next()) {

            Servicio objServicio = new Servicio("null", "null",0.0,rs.getString(1), false, 0.0);

            servicios.add(objServicio);
        }
        rs.close();
        conn.close();
        return servicios;
    }
}
