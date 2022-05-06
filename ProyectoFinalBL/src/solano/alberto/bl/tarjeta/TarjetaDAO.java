package solano.alberto.bl.tarjeta;

import solano.alberto.bl.servicio.Servicio;

import java.sql.*;
import java.util.ArrayList;

public class TarjetaDAO {

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

    public String registrarTarjeta(Tarjeta objTarjeta, String correo, String identificacion) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_registrar_metodo_pago(?,?,?,?,?,?,?)}");

            palmacenado.setString(1, correo);
            palmacenado.setString(2, identificacion);
            palmacenado.setString(3, objTarjeta.getNumeroTarjeta());
            palmacenado.setString(4, objTarjeta.getNombreTarjeta());
            palmacenado.setString(5, objTarjeta.getVencimiento());
            palmacenado.setString(6, objTarjeta.getCcv());
            palmacenado.registerOutParameter(7, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(7);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar tarjeta " + e);
        }
    }

    public String eliminarTarjeta(String numero) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_eliminar_tarjeta(?,?)}");

            palmacenado.setString(1, numero);
            palmacenado.registerOutParameter(2, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(2);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error al eliminar tarjeta del cliente " + e);
        }
    }

    public ArrayList<Tarjeta> obtenerTarjetas(String id) throws Exception {

        ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
        rs = stat.executeQuery("select * from vw_tarjetas where identificacion ='"+id+"'");

        while (rs.next()) {

            Tarjeta objTarjeta = new Tarjeta(rs.getString(2), rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5));

            tarjetas.add(objTarjeta);
        }
        rs.close();
        conn.close();
        return tarjetas;
    }

}
