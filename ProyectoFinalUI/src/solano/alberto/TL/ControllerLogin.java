package solano.alberto.TL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import solano.alberto.UI.LoginUI;

import java.io.IOException;


public class ControllerLogin {

    @FXML
    private Hyperlink hpNuevoCliente;

    @FXML
    private Button btnInciar;

    @FXML
    private PasswordField txtContra;

    @FXML
    private TextField txtCorreo;

    @FXML
    void loginAccion(ActionEvent event) throws Exception {
        try {
            LoginUI objUI = new LoginUI();

            String direccion = objUI.validarUsuarioLogin(txtCorreo.getText(), txtContra.getText());
            FXMLLoader loader = new FXMLLoader(getClass().getResource(direccion));


            if (!direccion.contains("Error")) {
                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.show();

                Stage myStage = (Stage) this.btnInciar.getScene().getWindow();
                myStage.close();
            }else{
                Alert a = new Alert(Alert.AlertType.NONE);

                // set alert type
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setTitle("Mensaje");
                a.setContentText(direccion);
                // show the dialog
                a.show();
            }


        } catch (Exception e) {
            throw e;
        }


    }

    @FXML
    void nuevoCliente(ActionEvent event) throws IOException {
        LoginUI objUI = new LoginUI();
        String direccion = objUI.nuevoCliente();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(direccion));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        Stage myStage = (Stage) this.btnInciar.getScene().getWindow();
        myStage.close();

    }

}

