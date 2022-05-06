package solano.alberto.bl.factura;

import solano.alberto.bl.conductor.Conductor;
import solano.alberto.bl.direccion.Canton;
import solano.alberto.bl.direccion.Direccion;
import solano.alberto.bl.direccion.Distrito;
import solano.alberto.bl.direccion.Provincia;
import solano.alberto.bl.tarjeta.Tarjeta;

import java.sql.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class FacturaDAO {

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

    public String registrarFactura(int codPedido, double total) throws Exception {
        try {
            Connection conn = inicializarBaseDatos();


            CallableStatement palmacenado = conn.prepareCall("{call sp_registrar_factura(?,?)}");

            palmacenado.setInt(1, codPedido);
            palmacenado.registerOutParameter(2, Types.VARCHAR);

            palmacenado.execute();
            String mensaje = palmacenado.getString(2);
            palmacenado.close();
            conn.close();

            return mensaje;
        } catch (Exception e) {
            throw new Exception("Error en registrar factura " + e);
        }
    }

    public ArrayList<TreeMap<String, String>> obtenerFacturaCliente(String identificacion) throws Exception {

        ArrayList<TreeMap<String, String>> Facturas = new ArrayList<TreeMap<String, String>>();

        Connection conn = inicializarBaseDatos();
        Statement stat = null;
        ResultSet rs = null; // variable de registros o filas
        stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        rs = stat.executeQuery("select * from vw_facturas where identificacion ="+"'"+ identificacion+"'");

        while (rs.next()) {
            TreeMap<String, String> mapa = new TreeMap<String, String>();

            mapa.put("Codigo", rs.getString(1));
            mapa.put("FechaCreacion", rs.getString(2));
            mapa.put("Total", rs.getString(3));


            Facturas.add(mapa);
        }
        rs.close();
        conn.close();
        return Facturas;
    }

}
