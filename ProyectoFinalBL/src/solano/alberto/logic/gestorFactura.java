package solano.alberto.logic;

import solano.alberto.bl.factura.FacturaDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;

public class gestorFactura {

    FacturaDAO objFacturaDAO = new FacturaDAO();

    public String registrarFactura(String codPedido, String total) throws Exception {
        try {
            String mensaje = "";
            mensaje = objFacturaDAO.registrarFactura(Integer.parseInt(codPedido), Double.parseDouble(total));

            return mensaje;
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

    public ArrayList<TreeMap<String, String>> imprimirFacturaCliente(String identificacion) throws Exception {

        try {
            ArrayList<TreeMap<String, String>> Facturas = objFacturaDAO.obtenerFacturaCliente(identificacion);

            return Facturas;

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }

    }

}
