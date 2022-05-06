package solano.alberto.TL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import solano.alberto.UI.ClienteVehiculoUI;
import solano.alberto.clasesTablas.carroTabla;
import solano.alberto.clasesTablas.motoTabla;
import solano.alberto.clasesTablas.tarjetaTabla;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClienteVehiculoController implements Initializable {
    ClienteVehiculoUI objUI = new ClienteVehiculoUI();
    @FXML
    private Button btnAgregarC;

    @FXML
    private Button btnAgregarM;

    @FXML
    private Button btnEliminarC;

    @FXML
    private Button btnEliminarM;

    @FXML
    private Button btnVolverMenu;

    @FXML
    private ComboBox<String> cmbTipoC;

    @FXML
    private ComboBox<String> cmbTipoM;

    @FXML
    private TableColumn<carroTabla, String> colColorC;

    @FXML
    private TableColumn<carroTabla, String> colMarcaC;

    @FXML
    private TableColumn<motoTabla, String> colMarcaM;

    @FXML
    private TableColumn<carroTabla, String> colPlacaC;

    @FXML
    private TableColumn<motoTabla, String> colPlacaM;

    @FXML
    private TableColumn<carroTabla, String> colTipoC;

    @FXML
    private TableColumn<motoTabla, String> colTipoM;

    @FXML
    private TableView<carroTabla> tblCarro;

    @FXML
    private TableView<motoTabla> tblMoto;

    @FXML
    private TextField txtColorC;

    @FXML
    private TextField txtMarcaC;

    @FXML
    private TextField txtMarcaM;

    @FXML
    private TextField txtPlacaC;

    @FXML
    private TextField txtPlacaM;

    private ObservableList<carroTabla> carro;
    private ObservableList<motoTabla> moto;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            initCombo();
            initTablaC();
            initTablaM();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initCombo() throws Exception {
        try {

            cmbTipoC.setItems(objUI.listaTiposC());
            cmbTipoM.setItems(objUI.listaTiposM());
        } catch (Exception e) {
            throw e;
        }
    }

    public void initTablaC() throws Exception {
        try {
            carro = FXCollections.observableArrayList();

            colColorC.setCellValueFactory(new PropertyValueFactory("color"));
            colMarcaC.setCellValueFactory(new PropertyValueFactory("marca"));
            colPlacaC.setCellValueFactory(new PropertyValueFactory("placa"));
            colTipoC.setCellValueFactory(new PropertyValueFactory("tipo"));


            tblCarro.setItems(objUI.imprimirCarro());

        } catch (Exception e) {
            throw e;
        }
    }

    public void initTablaM() throws Exception {
        try {
            moto = FXCollections.observableArrayList();

            colMarcaM.setCellValueFactory(new PropertyValueFactory("marca"));
            colPlacaM.setCellValueFactory(new PropertyValueFactory("placa"));
            colTipoM.setCellValueFactory(new PropertyValueFactory("tipo"));


            tblMoto.setItems(objUI.imprimirMoto());

        } catch (Exception e) {
            throw e;
        }
    }

    @FXML
    void AgregarCarro(ActionEvent event) throws Exception {
        try {
            String tipo = cmbTipoC.getValue();
            String marca = txtMarcaC.getText();
            String placa = txtPlacaC.getText();
            String color = txtColorC.getText();

            String mensaje = objUI.agregarCarro(tipo, marca, placa, color);


            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();
            initTablaC();
        } catch (Exception e) {
            throw e;
        }
    }

    @FXML
    void AgregarMoto(ActionEvent event) throws Exception {
        try {
            String tipo = cmbTipoM.getValue();
            String marca = txtMarcaM.getText();
            String placa = txtPlacaM.getText();


            String mensaje = objUI.agregarMoto(tipo, marca, placa);


            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();
            initTablaM();
        } catch (Exception e) {
            throw e;
        }
    }

    @FXML
    void EliminarCarro(ActionEvent event) throws Exception {
        try {
            carroTabla objCarro = tblCarro.getSelectionModel().getSelectedItem();

            String mensaje = objUI.eliminarCarro(objCarro.getPlaca());


            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();
            initTablaC();
        } catch (Exception e) {
            throw e;
        }
    }

    @FXML
    void EliminarMoto(ActionEvent event) throws Exception {
        try {
            motoTabla objMoto = tblMoto.getSelectionModel().getSelectedItem();

            String mensaje = objUI.eliminarMoto(objMoto.getPlaca());

            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();
            initTablaM();
        } catch (Exception e) {
            throw e;
        }
    }

    @FXML
    void VolverMenu(ActionEvent event) throws IOException {
        String mensaje = objUI.volverMenu();

        FXMLLoader loader = new FXMLLoader(getClass().getResource(mensaje));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        Stage myStage = (Stage) this.btnVolverMenu.getScene().getWindow();
        myStage.close();
    }

}
