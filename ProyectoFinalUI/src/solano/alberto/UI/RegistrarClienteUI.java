package solano.alberto.UI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import solano.alberto.logic.gestorUsuarios;

import java.util.ArrayList;
import java.util.TreeMap;

public class RegistrarClienteUI {
    private gestorUsuarios objGestor = new gestorUsuarios();
    private static ArrayList<TreeMap<String, String>> mapaCantones = new ArrayList<TreeMap<String, String>>();
    private static String idCantonseleccionado = null;


    public String registrarCliente(String nombre, String apellidos, String identificacion, String fechaNacimiento,
                                     String correo, String clave, String provincia, String canton, String distrito, String direccionExacta, String sexo, String avatar, String celular) {

        String mensaje = objGestor.registrarCliente(nombre, apellidos, identificacion, fechaNacimiento, correo, clave, provincia, canton, distrito, direccionExacta,avatar,sexo, celular);

        return mensaje;

    }

    /*Para llenar los box de provincias, distritos y cantones y para el filtro*/
    public ObservableList<String> listaProvincias() throws Exception {
        try {
            ArrayList<String> listaProvincias = new ArrayList<String>();
            ArrayList<TreeMap<String, String>> provincias = objGestor.imprimirProvincias();

            for (TreeMap<String, String> Provincia : provincias) {
                listaProvincias.add(Provincia.get("Nombre"));
            }
            ObservableList<String> observableList = FXCollections.observableList(listaProvincias);
            return observableList;
        } catch (Exception e) {
            throw e;
        }
    }

    public ObservableList<String> listaCantones() throws Exception {
        try {
            ArrayList<String> listaCantones = new ArrayList<String>();
            ArrayList<TreeMap<String, String>> Cantones = objGestor.imprimirCantones();

            for (TreeMap<String, String> Canton : Cantones) {
                listaCantones.add(Canton.get("Nombre"));
                mapaCantones.add(Canton);
            }

            ObservableList<String> observableList = FXCollections.observableList(listaCantones);
            return observableList;
        } catch (Exception e) {
            throw e;
        }
    }

    public ObservableList<String> listaDistritos() throws Exception {
        try {
            ArrayList<String> listaDistritos = new ArrayList<String>();
            ArrayList<TreeMap<String, String>> distritos = objGestor.imprimirDistritos();

            for (TreeMap<String, String> Distrito : distritos) {
                listaDistritos.add(Distrito.get("Nombre"));
            }
            ObservableList<String> observableList = FXCollections.observableList(listaDistritos);
            return observableList;
        } catch (Exception e) {
            throw e;
        }
    }

    public ObservableList<String> cantonesProvincias(String nombreProvincia) throws Exception {
        try {
            ArrayList<String> listaCantones = new ArrayList<String>();
            ArrayList<TreeMap<String, String>> provincias = objGestor.imprimirProvincias();
            String idProvincia = null;
            for (TreeMap<String, String> Provincia : provincias) {
                if (Provincia.get("Nombre").equals(nombreProvincia)) {
                    idProvincia = Provincia.get("Codigo");
                }
            }

            for (TreeMap<String, String> Canton : mapaCantones) {
                if (Canton.get("CodPro").equals(idProvincia)) {
                    listaCantones.add(Canton.get("Nombre"));
                }
            }


            ObservableList<String> observableList = FXCollections.observableList(listaCantones);
            return observableList;
        } catch (Exception e) {
            throw e;
        }
    }

    public ObservableList<String> distritosCantones(String nombre) throws Exception {
        try {
            ArrayList<String> listaDistritos = new ArrayList<String>();
            ArrayList<TreeMap<String, String>> distritos = objGestor.imprimirDistritos();

            for (TreeMap<String, String> Cantones : mapaCantones) {
                if (Cantones.get("Nombre").equals(nombre)) {
                    idCantonseleccionado = Cantones.get("Codigo");
                }
            }

            for (TreeMap<String, String> Canton : distritos) {
                if (Canton.get("CodCan").equals(idCantonseleccionado)) {
                    listaDistritos.add(Canton.get("Nombre"));
                }
            }

            ObservableList<String> observableList = FXCollections.observableList(listaDistritos);
            return observableList;
        } catch (Exception e) {
            throw e;
        }
    }

    public String volverLogin(){
        return "../LoginUI.fxml";
    }

}
