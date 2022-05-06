package solano.alberto.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import solano.alberto.clasesTablas.conductoresTabla;
import solano.alberto.clasesTablas.serviciosTabla;
import solano.alberto.logic.gestorServicios;

import java.util.ArrayList;
import java.util.TreeMap;

public class ServiciosUI {
    gestorServicios objGestor = new gestorServicios();

    public String resgitrarServicio(String tipo, String descripcion, String precioBa, String precioL,
                                     boolean estado) throws Exception {

        String mensaje = objGestor.registrarServicio(tipo, descripcion, Double.parseDouble(precioBa),Double.parseDouble(precioL), estado);

        return mensaje;

    }

    public ObservableList<String> listaTipos() throws Exception {
        try {
            ArrayList<String> listaTipos = new ArrayList<String>();
            ArrayList<TreeMap<String, String>> tipos = objGestor.imprimirServiciosTipos();

            for (TreeMap<String, String> Distrito : tipos) {
                listaTipos.add(Distrito.get("Tipo"));
            }
            ObservableList<String> observableList = FXCollections.observableList(listaTipos);
            return observableList;
        } catch (Exception e) {
            throw e;
        }
    }

    public ObservableList<serviciosTabla> imprimirServicios() throws Exception {


        ArrayList<TreeMap<String, String>> listaServicios = objGestor.imprimirServicios();
        ObservableList<serviciosTabla> servicios = FXCollections.observableArrayList();

        for (TreeMap<String, String> lista : listaServicios) {
            serviciosTabla objServicios = new serviciosTabla(lista.get("Codigo"),lista.get("Nombre"),lista.get("Tipo"),lista.get("Estado") ,lista.get("PrecioBase"), lista.get("PrecioLitro"));
            servicios.add(objServicios);
        }

        return servicios;
    }

    public String volverMenu() {
        String direccion = "";
        direccion = "../MenuGeneralAdminUI.fxml";


        return direccion;
    }

    public String cambioEstadoServicio(serviciosTabla objServicio) throws Exception {
        try {
            String estadoNuevo="1";
            if (objServicio.getEstado().equals("true")){
                estadoNuevo = "0";
            }
            String mensaje = objGestor.modificarServicio(objServicio.getTipo(), objServicio.getNombre(), Boolean.parseBoolean(estadoNuevo));


            return mensaje;
        } catch (Exception e) {
            throw e;
        }

    }

}
