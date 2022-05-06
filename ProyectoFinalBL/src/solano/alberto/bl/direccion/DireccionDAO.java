package solano.alberto.bl.direccion;

import java.sql.*;
import java.util.ArrayList;

public class DireccionDAO {

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


    public ArrayList<Provincia> obtenerProvincia() throws Exception {

        ArrayList<Provincia> provincia = new ArrayList<Provincia>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
        rs = stat.executeQuery("select * from vw_provincias Order by(codProvincia)");

        while (rs.next()) {
            Provincia objProvincia= new Provincia(rs.getString(1),rs.getString(2));
            provincia.add(objProvincia);
        }
        rs.close();
        conn.close();
        return provincia;
    }

    public ArrayList obtenerCanton() throws Exception {

        ArrayList<Canton> canton = new ArrayList<Canton>();
        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        rs = stat.executeQuery("select * from vw_cantones Order by(codCanton)");

        while (rs.next()) {
            Canton objCanton= new Canton(rs.getString(1),rs.getString(2),rs.getString(3));
            canton.add(objCanton);
        }
        rs.close();
        conn.close();
        return canton;
    }

    public ArrayList obtenerDistrito() throws Exception {

        ArrayList<Distrito> distrito = new ArrayList<Distrito>();
        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stat.executeQuery("select * from vw_distritos Order by(codDistrito)");

        while (rs.next()) {
            Distrito objDistrito= new Distrito(rs.getString(1),rs.getString(2),rs.getString(3));
            distrito.add(objDistrito);
        }
        rs.close();
        conn.close();
        return distrito;
    }

    public Provincia devolverProvinciaObj(String nombre) throws Exception {

        ArrayList<Provincia> provinciasLista = obtenerProvincia();
        Provincia objProvincia = new Provincia();
        for (Provincia provincia : provinciasLista) {
            if (provincia.getNombre().equals(nombre)) {
                objProvincia = provincia;
            }
        }
        return objProvincia;
    }

    public Canton devolverCantonObj(String nombre, String codProvincia) throws Exception {

        ArrayList<Canton> cantonLista = obtenerCanton();
        Canton objCanton = new Canton();
        for (Canton canton : cantonLista) {
            if (canton.getNombre().equals(nombre) && canton.getCodProvincia().equals(codProvincia)) {
                objCanton = canton;
            }
        }
        return objCanton;
    }

    public Distrito devolverDistritoObj(String nombre, String codCanton) throws Exception {

        ArrayList<Distrito> distritoLista = obtenerDistrito();
        Distrito objDistrito = new Distrito();
        for (Distrito distrito : distritoLista) {
            if (distrito.getNombre().equals(nombre) && distrito.getCodCanton().equals(codCanton)) {
                objDistrito = distrito;
            }
        }
        return objDistrito;
    }

}
