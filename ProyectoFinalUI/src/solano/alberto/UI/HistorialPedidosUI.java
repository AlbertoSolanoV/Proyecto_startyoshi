package solano.alberto.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import solano.alberto.clasesTablas.clienteClass;
import solano.alberto.clasesTablas.facturaTabla;
import solano.alberto.clasesTablas.pedidosTabla;
import solano.alberto.clasesTablas.serviciosTabla;
import solano.alberto.logic.gestorFactura;
import solano.alberto.logic.gestorPedido;

import java.util.ArrayList;
import java.util.TreeMap;

public class HistorialPedidosUI {

    gestorPedido objGestor = new gestorPedido();
    clienteClass objCliente = new clienteClass();
    gestorFactura objGestorFac = new gestorFactura();

    public ObservableList<pedidosTabla> imprimirPedidos() throws Exception {

        ArrayList<TreeMap<String, String>> listaPedidos = objGestor.imprimirPedidoCliente(objCliente.getIdentificacion());
        ObservableList<pedidosTabla> pedidos = FXCollections.observableArrayList();

        for (TreeMap<String, String> lista : listaPedidos) {
            pedidosTabla objPedidos = new pedidosTabla(lista.get("Codigo"), lista.get("Descripcion"), lista.get("FechaCreacion"), lista.get("Estado"), lista.get("Provincia"), lista.get("Canton"), lista.get("Distrito"));
            pedidos.add(objPedidos);
        }

        return pedidos;
    }

    public ObservableList<facturaTabla> imprimirFactura() throws Exception {

        ArrayList<TreeMap<String, String>> listaFacturas = objGestorFac.imprimirFacturaCliente(objCliente.getIdentificacion());
        ObservableList<facturaTabla> facturas = FXCollections.observableArrayList();

        for (TreeMap<String, String> lista : listaFacturas) {
            facturaTabla objFactura = new facturaTabla(lista.get("Codigo"), lista.get("FechaCreacion"), lista.get("Total"));
            facturas.add(objFactura);
        }

        return facturas;
    }

    public String cancelarEstado(String cod) throws Exception {
        try {
            return objGestor.cambioEstado("Cancelado", Integer.parseInt(cod));

        } catch (Exception e) {
            throw e;
        }
    }
    public String volverMenu(){
        return "../MenuGeneralCliente.fxml";
    }
}
