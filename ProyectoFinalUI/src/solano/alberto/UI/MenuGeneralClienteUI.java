package solano.alberto.UI;

import solano.alberto.clasesTablas.clienteClass;
import solano.alberto.logic.gestorTarjetas;
import solano.alberto.logic.gestorUsuarios;

import java.util.ArrayList;
import java.util.TreeMap;

public class MenuGeneralClienteUI {
        clienteClass objCliente = new clienteClass();
    gestorUsuarios objGestor = new gestorUsuarios();

    public String direccion(String boton) {
        String mensaje = "";

        if (boton.equals("info")) {
            mensaje = "../InfoClienteUI.fxml";
        }else if(boton.equals("servicio")){
            mensaje = "../PedirServicioUI.fxml";
        }else if(boton.equals("vehiculos")){
            mensaje = "../ClienteVehiculoUI.fxml";
        }

        return mensaje;

    }
    public void cargarInfo() throws Exception {
        try{
            String correo = objCliente.getCorreo();

            ArrayList<TreeMap<String, String>> clienteInfo =  objGestor.imprimirCliente(correo);

            for (TreeMap<String, String> info : clienteInfo) {
                objCliente.setNombre(info.get("Nombre"));
                objCliente.setApellidos(info.get("Apellidos"));
                objCliente.setAvatar(info.get("Avatar"));
                objCliente.setIdentificacion(info.get("Identificacion"));
                objCliente.setFechaNacimiento(info.get("FechaNacimiento"));
                objCliente.setCelular(info.get("Celular"));
                objCliente.setGenero(info.get("Sexo"));
            }
        }catch (Exception e){
            throw e;
        }

    }
}
