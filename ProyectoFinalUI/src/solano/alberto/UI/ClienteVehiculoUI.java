package solano.alberto.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import solano.alberto.clasesTablas.carroTabla;
import solano.alberto.clasesTablas.clienteClass;
import solano.alberto.clasesTablas.direccionTabla;
import solano.alberto.clasesTablas.motoTabla;
import solano.alberto.logic.gestorVehiculos;

import java.util.ArrayList;
import java.util.TreeMap;

public class ClienteVehiculoUI {
    gestorVehiculos objGestor = new gestorVehiculos();
    clienteClass objCliente = new clienteClass();

    public ObservableList<String> listaTiposC() throws Exception {
        try {
            ArrayList<String> listaTipos = new ArrayList<String>();
            ArrayList<TreeMap<String, String>> Tipos = objGestor.imprimirTipoCarro();

            for (TreeMap<String, String> tipo : Tipos) {
                listaTipos.add(tipo.get("Tipo"));
            }

            ObservableList<String> observableList = FXCollections.observableList(listaTipos);
            return observableList;
        } catch (Exception e) {
            throw e;
        }
    }

    public ObservableList<String> listaTiposM() throws Exception {
        try {
            ArrayList<String> listaTipos = new ArrayList<String>();
            ArrayList<TreeMap<String, String>> Tipos = objGestor.imprimirTipoMoto();

            for (TreeMap<String, String> tipo : Tipos) {
                listaTipos.add(tipo.get("Tipo"));
            }

            ObservableList<String> observableList = FXCollections.observableList(listaTipos);
            return observableList;
        } catch (Exception e) {
            throw e;
        }
    }

    public ObservableList<carroTabla> imprimirCarro() throws Exception {


        ArrayList<TreeMap<String, String>> listaCarros = objGestor.imprimirCarro(objCliente.getIdentificacion());
        ObservableList<carroTabla> carros = FXCollections.observableArrayList();

        for (TreeMap<String, String> lista : listaCarros) {
            carroTabla objCarro = new carroTabla(lista.get("Tipo"), lista.get("Marca"), lista.get("Placa"), lista.get("Color"));
            carros.add(objCarro);
        }

        return carros;
    }

    public ObservableList<motoTabla> imprimirMoto() throws Exception {


        ArrayList<TreeMap<String, String>> listaMoto = objGestor.imprimirMoto(objCliente.getIdentificacion());
        ObservableList<motoTabla> motos = FXCollections.observableArrayList();

        for (TreeMap<String, String> lista : listaMoto) {
            motoTabla objMoto = new motoTabla(lista.get("Tipo"), lista.get("Marca"), lista.get("Placa"));
            motos.add(objMoto);
        }

        return motos;
    }

    public String agregarCarro(String tipo, String marca, String placa, String color) throws Exception {
        try{
            return objGestor.registrarCarro(objCliente.getCorreo(), objCliente.getIdentificacion(),placa, marca, color, tipo);
        }catch (Exception e){
            throw e;
        }
    }

    public String agregarMoto(String tipo, String marca, String placa) throws Exception {
        try{
            return objGestor.registrarMoto(objCliente.getCorreo(), objCliente.getIdentificacion(),placa, marca,tipo);
        }catch (Exception e){
            throw e;
        }
    }

    public String eliminarCarro(String placa) throws Exception {
        try{
            return objGestor.eliminarCarro(placa);
        }catch (Exception e){
            throw e;
        }
    }

    public String eliminarMoto(String placa) throws Exception {
        try{
            return objGestor.eliminarMoto(placa);
        }catch (Exception e){
            throw e;
        }
    }
    public String volverMenu(){
        return "../MenuGeneralCliente.fxml";
    }
}
