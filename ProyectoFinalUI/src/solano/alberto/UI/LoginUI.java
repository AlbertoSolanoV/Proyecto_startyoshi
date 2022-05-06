package solano.alberto.UI;


import solano.alberto.clasesTablas.clienteClass;
import solano.alberto.logic.gestorUsuarios;

public class LoginUI {
    clienteClass getCorreoCliente = new clienteClass();
    private gestorUsuarios objGestor = new gestorUsuarios();


    public String validarUsuarioLogin(String correo, String clave) throws Exception {
        String mensaje = "";



        String rol = objGestor.validarLogin(correo, clave);
        getCorreoCliente.setCorreo(correo);
        if (rol.equals("Admin")) {
            mensaje = "../MenuGeneralAdminUI.fxml";
        } else if (rol.equals("Cliente")) {
            mensaje = "../MenuGeneralCliente.fxml";
        } else if (rol.equals("Conductor")) {
            mensaje = "../ConductorPedido.fxml";
        } else {
            mensaje = "Error: " + rol;
        }
        return mensaje;
    }

    public String nuevoCliente() {
        String mensaje = "";

        mensaje = "../RegistroClienteUI.fxml";
        return mensaje;
    }

}
