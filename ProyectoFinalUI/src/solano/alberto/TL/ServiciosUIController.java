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
import solano.alberto.UI.RegistrarConductorUI;
import solano.alberto.UI.ServiciosUI;
import solano.alberto.clasesTablas.conductoresTabla;
import solano.alberto.clasesTablas.serviciosTabla;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ServiciosUIController implements Initializable {
    ServiciosUI objUI = new ServiciosUI();

    @FXML
    private Button btnCambioEstado;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnVolverMenu;

    @FXML
    private ComboBox<String> cmbTipoServicio;

    @FXML
    private TableColumn<serviciosTabla, String> colEstado;

    @FXML
    private TableColumn<serviciosTabla, String> colNombre;

    @FXML
    private TableColumn<serviciosTabla, String> colPrecioBase;

    @FXML
    private TableColumn<serviciosTabla, String> colPrecioLitro;

    @FXML
    private TableColumn<serviciosTabla, String> colTipo;

    @FXML
    private TableView<serviciosTabla> tblServicios;

    @FXML
    private RadioButton rbEstado;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtPrecioB;

    @FXML
    private TextField txtPrecioL;

    @FXML
    private TextField txtTipo;

    private ObservableList<serviciosTabla> servicios;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            initCombo();
            initTabla();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initCombo() throws Exception {
        try {
            cmbTipoServicio.setItems(objUI.listaTipos());
        } catch (Exception e) {
            throw e;
        }


    }

    public void initTabla() throws Exception {
        try {
            servicios = FXCollections.observableArrayList();

            colNombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
            colTipo.setCellValueFactory(new PropertyValueFactory("Tipo"));
            colPrecioBase.setCellValueFactory(new PropertyValueFactory("PrecioBase"));
            colEstado.setCellValueFactory(new PropertyValueFactory("Estado"));
            colPrecioLitro.setCellValueFactory(new PropertyValueFactory("PrecioLitro"));


            tblServicios.setItems(objUI.imprimirServicios());

        } catch (Exception e) {
            throw e;
        }
    }


    @FXML
    void cambioEstado(ActionEvent event) throws Exception {
        try {
            serviciosTabla servicio = tblServicios.getSelectionModel().getSelectedItem();

            String mensaje = objUI.cambioEstadoServicio(servicio);

            //Para la alerta
            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();
            initTabla();
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.ERROR);
            a.setTitle("ERRORS");
            a.setContentText("No se ha seleccionado ningun servicio");
            // show the dialog
            a.show();
        }

    }

    @FXML
    void cancelarIngreso(ActionEvent event) throws Exception {
        limpiar();
        initCombo();
    }

    void limpiar() {
        txtPrecioL.setText("");
        txtTipo.setText("");
        txtPrecioB.setText("");
        txtDescripcion.setText("");
    }

    @FXML
    void ingresarServicio(ActionEvent event) throws Exception {
        String descripcion = txtDescripcion.getText();
        String tipo = "";
        String precioBase = txtPrecioB.getText();
        String precioLitro = "";
        if (txtPrecioL.getText() == null) {
            precioLitro = "0";
        } else {
            precioLitro = txtPrecioL.getText();
        }
        boolean estado = rbEstado.isSelected();

        if (cmbTipoServicio.getValue() == null) {
            tipo = txtTipo.getText();
        } else {
            tipo = cmbTipoServicio.getValue();
        }

        String mensaje = objUI.resgitrarServicio(tipo, descripcion, precioBase, precioLitro, estado);
        if (!mensaje.contains("Error")) {
            limpiar();
        }


        initTabla();
    }

    @FXML
    void volverMenu(ActionEvent event) throws IOException {
        String direccion = objUI.volverMenu();
        FXMLLoader loader = new FXMLLoader(getClass().getResource(direccion));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        Stage myStage = (Stage) this.btnVolverMenu.getScene().getWindow();
        myStage.close();
    }

}
