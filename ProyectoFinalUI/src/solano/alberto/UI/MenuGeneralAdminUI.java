package solano.alberto.UI;

public class MenuGeneralAdminUI {

    public String direccionClick(String boton){
        String direccion = "";
        if(boton.equals("btnConductores")){
            direccion = "../RegistrarConductorUI.fxml";
        }else if(boton.equals("btnSercivio")){
            direccion = "../ServiciosUI.fxml";
        }

        return direccion;
    }

}
