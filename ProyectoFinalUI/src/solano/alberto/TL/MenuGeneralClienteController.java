package solano.alberto.TL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import solano.alberto.UI.MenuGeneralClienteUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuGeneralClienteController implements Initializable {
    MenuGeneralClienteUI objUI = new MenuGeneralClienteUI();
    @FXML
    private Button btnInfo;

    @FXML
    private Button btnServicios;

    @FXML
    private Button btnVehiculos;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            objUI.cargarInfo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void irInformacion(ActionEvent event) throws IOException {
        String direccion = objUI.direccion("info");
        FXMLLoader loader = new FXMLLoader(getClass().getResource(direccion));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        Stage myStage = (Stage) this.btnInfo.getScene().getWindow();
        myStage.close();

    }

    @FXML
    void irServicios(ActionEvent event) throws IOException {
        String direccion = objUI.direccion("servicio");

        FXMLLoader loader = new FXMLLoader(getClass().getResource(direccion));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        Stage myStage = (Stage) this.btnServicios.getScene().getWindow();
        myStage.close();

    }

    @FXML
    void irVehiculo(ActionEvent event) throws IOException {
        String direccion = objUI.direccion("vehiculos");

        FXMLLoader loader = new FXMLLoader(getClass().getResource(direccion));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        Stage myStage = (Stage) this.btnServicios.getScene().getWindow();
        myStage.close();
    }
}
