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
import solano.alberto.UI.InfoClienteUI;
import solano.alberto.clasesTablas.clienteClass;
import solano.alberto.clasesTablas.direccionTabla;
import solano.alberto.clasesTablas.tarjetaTabla;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class InfoClienteUIController implements Initializable {
    InfoClienteUI objUI = new InfoClienteUI();
    clienteClass objCliente = new clienteClass();

    @FXML
    private Button btnNuevaDireccion;

    @FXML
    private Button btnNuevaTarjeta;

    @FXML
    private Button btnVolver;

    @FXML
    private ComboBox<String> cmbCanton;

    @FXML
    private ComboBox<String> cmbDistrito;

    @FXML
    private ComboBox<String> cmbProvincia;

    @FXML
    private TableColumn<direccionTabla, String> colCanton;

    @FXML
    private TableColumn<direccionTabla, String> colDireccionExacta;

    @FXML
    private TableColumn<direccionTabla, String> colDistrito;

    @FXML
    private TableColumn<tarjetaTabla, String> colNombreT;

    @FXML
    private TableColumn<tarjetaTabla, String> colNumeroT;

    @FXML
    private TableColumn<tarjetaTabla, String> colFechaVenceT;

    @FXML
    private TableColumn<direccionTabla, String> colProvincia;

    @FXML
    private DatePicker dtFechaNacimiento;

    @FXML
    private DatePicker dtFechaVencimeintoT;

    @FXML
    private TableView<direccionTabla> tblDirecciones;

    @FXML
    private TableView<tarjetaTabla> tblTarjeta;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtAvatar;

    @FXML
    private TextField txtCCVT;

    @FXML
    private TextField txtCelular;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccionExacta;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNombreT;

    @FXML
    private TextField txtNumeroT;

    private ObservableList<direccionTabla> direccion;
    private ObservableList<tarjetaTabla> tarjeta;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            mostrarInfoCliente();
            initCombo();
            initTablaDirecciones();
            initTablaTarjetas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarInfoCliente() {
        txtNombre.setText(objCliente.getNombre());
        txtApellido.setText(objCliente.getApellidos());
        txtAvatar.setText(objCliente.getAvatar());
        txtIdentificacion.setText(objCliente.getIdentificacion());
        txtCelular.setText(objCliente.getCelular());
        txtCorreo.setText(objCliente.getCorreo());
        dtFechaNacimiento.setValue(LOCAL_DATE(objCliente.getFechaNacimiento()));

    }

    public void initTablaDirecciones() throws Exception {
        try {
            direccion = FXCollections.observableArrayList();

            colProvincia.setCellValueFactory(new PropertyValueFactory("provincia"));
            colCanton.setCellValueFactory(new PropertyValueFactory("canton"));
            colDistrito.setCellValueFactory(new PropertyValueFactory("distrito"));
            colDireccionExacta.setCellValueFactory(new PropertyValueFactory("DireccionExacta"));


            tblDirecciones.setItems(objUI.imprimirDireccion());

        } catch (Exception e) {
            throw e;
        }
    }

    public void initTablaTarjetas() throws Exception {
        try {
            tarjeta = FXCollections.observableArrayList();

            colNombreT.setCellValueFactory(new PropertyValueFactory("nombre"));
            colNumeroT.setCellValueFactory(new PropertyValueFactory("numero"));
            colFechaVenceT.setCellValueFactory(new PropertyValueFactory("fechaVence"));


            tblTarjeta.setItems(objUI.imprimirTarjetas());

        } catch (Exception e) {
            throw e;
        }
    }

    public void initCombo() throws Exception {
        try {

            cmbProvincia.setItems(objUI.listaProvincias());
            cmbCanton.setItems(objUI.listaCantones());
            cmbDistrito.setItems(objUI.listaDistritos());
        } catch (Exception e) {
            throw e;
        }


    }

    @FXML
    void selectCanton(ActionEvent event) throws Exception {
        cmbDistrito.setItems(objUI.distritosCantones(cmbCanton.getValue()));

    }

    @FXML
    void selectProvincia(ActionEvent event) throws Exception {
        cmbCanton.setItems(objUI.cantonesProvincias(cmbProvincia.getValue()));

    }

    public static final LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }

    @FXML
    void NuevaTarjeta(ActionEvent event) throws Exception {
        try {

            String nombre = txtNombreT.getText();
            String numero = txtNumeroT.getText();
            String ccv = txtCCVT.getText();
            String fechaNacimiento = dtFechaNacimiento.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String mensaje = objUI.registrarTarjeta(nombre, numero, fechaNacimiento, ccv);

            //Para la alerta
            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();
            initTablaTarjetas();
        } catch (Exception e) {
            throw e;
        }

    }

    @FXML
    void btnNuevaDireccion(ActionEvent event) throws Exception {
        try {
            String provincia = cmbProvincia.getValue();
            String canton = cmbCanton.getValue();
            String distrito = cmbDistrito.getValue();
            String direccionExacta = txtDireccionExacta.getText();

            String mensaje = objUI.registrarDireccion(provincia, canton, distrito, direccionExacta);

            //Para la alerta
            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();
            initTablaDirecciones();
        } catch (Exception e) {
            throw e;
        }


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

        Stage myStage = (Stage) this.btnVolver.getScene().getWindow();
        myStage.close();
    }

}
