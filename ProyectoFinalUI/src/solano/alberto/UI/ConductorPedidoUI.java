package solano.alberto.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import solano.alberto.clasesTablas.clienteClass;
import solano.alberto.clasesTablas.pedidosTabla;
import solano.alberto.clasesTablas.serviciosTabla;
import solano.alberto.logic.gestorFactura;
import solano.alberto.logic.gestorPedido;
import solano.alberto.logic.gestorServicios;

import java.util.ArrayList;
import java.util.TreeMap;

public class ConductorPedidoUI {
    gestorPedido objGestor = new gestorPedido();
    clienteClass objCliente = new clienteClass();
    gestorFactura objFactura = new gestorFactura();

    public ObservableList<pedidosTabla> imprimirPedidos() throws Exception {


        ArrayList<TreeMap<String, String>> listaPedidos = objGestor.imprimirPedido();
        ObservableList<pedidosTabla> pedidos = FXCollections.observableArrayList();

        for (TreeMap<String, String> lista : listaPedidos) {
            pedidosTabla objPedidos = new pedidosTabla(lista.get("Codigo"), lista.get("Descripcion"), lista.get("FechaCreacion"), lista.get("Estado"), lista.get("Provincia"), lista.get("Canton"), lista.get("Distrito"));
            pedidos.add(objPedidos);
        }

        return pedidos;
    }

    public ObservableList<pedidosTabla> imprimirPedidosConductor() throws Exception {
        try {
            String correo = objCliente.getCorreo();
            ArrayList<TreeMap<String, String>> listaPedidos = objGestor.imprimirPedidoConductor(correo);
            ObservableList<pedidosTabla> pedidos = FXCollections.observableArrayList();

            for (TreeMap<String, String> lista : listaPedidos) {
                pedidosTabla objPedidos = new pedidosTabla(lista.get("Codigo"), lista.get("Descripcion"), lista.get("FechaCreacion"), lista.get("Estado"), lista.get("Provincia"), lista.get("Canton"), lista.get("Distrito"));
                pedidos.add(objPedidos);
            }

            return pedidos;
        } catch (Exception e) {
            throw e;
        }

    }

    public String aceptarPedido(String cod) throws Exception {
        try {
            String correo = objCliente.getCorreo();
            String mensaje = objGestor.cambioEstadoConductorPedido(correo, Integer.parseInt(cod));
            mensaje = objGestor.cambioEstado("Aceptado", Integer.parseInt(cod));
            return mensaje;
        } catch (Exception e) {
            throw e;
        }
    }

    public String finalizaPedido(String cod) throws Exception {
        try {
            String mensaje = objGestor.cambioEstado("Finalizado", Integer.parseInt(cod));
            mensaje = objFactura.registrarFactura(cod,"0");
            return mensaje;
        } catch (Exception e) {
            throw e;
        }
    }
}
