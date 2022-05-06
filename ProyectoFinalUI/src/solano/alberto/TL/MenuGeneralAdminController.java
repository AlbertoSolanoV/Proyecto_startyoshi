package solano.alberto.TL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import solano.alberto.UI.MenuGeneralAdminUI;

import java.io.IOException;

public class MenuGeneralAdminController {

    @FXML
    private Button btnCatalogo;

    @FXML
    private Button btnConductores;


    @FXML
    void irCatalogo(ActionEvent event) throws IOException {
        MenuGeneralAdminUI objUI = new MenuGeneralAdminUI();

        String direccion = objUI.direccionClick("btnSercivio");
        FXMLLoader loader = new FXMLLoader(getClass().getResource( direccion));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        Stage myStage = (Stage) this.btnConductores.getScene().getWindow();
        myStage.close();
    }

    @FXML
    void irConductores(ActionEvent event) throws IOException {
        try {
            MenuGeneralAdminUI objUI = new MenuGeneralAdminUI();

            String direccion = objUI.direccionClick("btnConductores");
            FXMLLoader loader = new FXMLLoader(getClass().getResource( direccion));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnConductores.getScene().getWindow();
            myStage.close();

        }catch (Exception e){
            throw  e;
        }
    }

}
