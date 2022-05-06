package solano.alberto.bl.vehiculo;

import solano.alberto.bl.tarjeta.Tarjeta;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class VehiculoDAO {

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

    public String registrarAutomovil(Carro objCarro, String correo, String identificacion) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_registrar_vehiculo(?,?,?,?,?,?,?)}");

            palmacenado.setString(1, objCarro.getTipo());
            palmacenado.setString(2, objCarro.getPlaca());
            palmacenado.setString(3,objCarro.getMarca());
            palmacenado.setString(4, correo);
            palmacenado.setString(5, identificacion);
            palmacenado.setString(6, objCarro.getColor());
            palmacenado.registerOutParameter(7, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(7);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar un automovil " + e);
        }
    }

    public String registrarMoto(Moto objMoto, String correo, String identificacion) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_registrar_moto(?,?,?,?,?,?)}");

            palmacenado.setString(1, objMoto.getTipo());
            palmacenado.setString(2, objMoto.getPlaca());
            palmacenado.setString(3,objMoto.getMarca());
            palmacenado.setString(4, correo);
            palmacenado.setString(5, identificacion);
            palmacenado.registerOutParameter(6, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(6);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar una moto " + e);
        }
    }

    public String eliminarMoto(String placa) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_reliminar_moto(?,?)}");

            palmacenado.setString(1, placa);

            palmacenado.registerOutParameter(2, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(2);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en eliminar una moto " + e);
        }
    }

    public String eliminarCarro(String placa) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_reliminar_auto(?,?)}");

            palmacenado.setString(1, placa);
            palmacenado.registerOutParameter(2, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(2);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en eliminar un carro " + e);
        }
    }

     public ArrayList<Carro> obtenerTipoAutomovil() throws Exception {

        ArrayList<Carro> carros = new ArrayList<Carro>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        rs = stat.executeQuery("select * from vw_lista_tipo_vehiculos");

        while (rs.next()) {

            Carro objCarro = new Carro(null, null, null, rs.getString(1));

            carros.add(objCarro);
        }
        rs.close();
        conn.close();
        return carros;
    }

    public ArrayList<Moto> obtenerTipoMoto() throws Exception {

        ArrayList<Moto> motos = new ArrayList<Moto>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        rs = stat.executeQuery("select * from vw_lista_tipo_motoo");

        while (rs.next()) {

            Moto objMoto = new Moto(null, null, rs.getString(1));

            motos.add(objMoto);
        }
        rs.close();
        conn.close();
        return motos;
    }

    public ArrayList<Carro> obtenerCarro(String id) throws Exception {

        ArrayList<Carro> carros = new ArrayList<Carro>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        rs = stat.executeQuery("select * from vw_medios_transporte_auto where Identificacion = "+"'"+id+"'");

        while (rs.next()) {

            Carro objCarro = new Carro(rs.getString(3), rs.getString(2), rs.getString(5), rs.getString(4));
            carros.add(objCarro);
        }
        rs.close();
        conn.close();
        return carros;
    }



    public ArrayList<Moto> obtenerMoto(String id) throws Exception {

        ArrayList<Moto> motos = new ArrayList<Moto>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        rs = stat.executeQuery("select * from vw_medios_transporte_moto where Identificacion  = "+"'"+id+"'");

        while (rs.next()) {

            Moto objMoto = new Moto(rs.getString(3), rs.getString(2), rs.getString(4));
            motos.add(objMoto);
        }
        rs.close();
        conn.close();
        return motos;
    }

}
