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
import solano.alberto.UI.PedirServicioUI;
import solano.alberto.clasesTablas.direccionTabla;
import solano.alberto.clasesTablas.serviciosTabla;
import solano.alberto.clasesTablas.tarjetaTabla;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class PedirServicioUIController implements Initializable {
    PedirServicioUI objUI = new PedirServicioUI();
    @FXML
    private Button btnDireccion;

    @FXML
    private Button btnPedidos;

    @FXML
    private Button btnServicio;

    @FXML
    private Button btnTarjeta;

    @FXML
    private Button btnVolverMenu;

    @FXML
    private ComboBox<String> cmbCanton;

    @FXML
    private ComboBox<String> cmbDistrito;

    @FXML
    private ComboBox<String> cmnProvincia;

    @FXML
    private TableColumn<direccionTabla, String> colCanton;

    @FXML
    private TableColumn<direccionTabla, String> colDireccionExacta;

    @FXML
    private TableColumn<direccionTabla, String> colDistrito;

    @FXML
    private TableColumn<tarjetaTabla, String> colFechaVenceT;

    @FXML
    private TableColumn<serviciosTabla, String> colNombreS;

    @FXML
    private TableColumn<tarjetaTabla, String> colNombreT;

    @FXML
    private TableColumn<tarjetaTabla, String> colNumeroT;

    @FXML
    private TableColumn<serviciosTabla, String> colPrecioBaseS;

    @FXML
    private TableColumn<serviciosTabla, String> colPrecioLitroS;

    @FXML
    private TableColumn<direccionTabla, String> colProvincia;

    @FXML
    private TableColumn<serviciosTabla, String> colTipoS;

    @FXML
    private DatePicker dtFechaVenceT;

    @FXML
    private TableView<direccionTabla> tblDirecciones;

    @FXML
    private TableView<tarjetaTabla> tblTarjeta;

    @FXML
    private TableView<serviciosTabla> tbllServicios;

    @FXML
    private TextField txtDireccionExacta;

    @FXML
    private TextField txtCCVT;

    @FXML
    private TextField txtNombreT;

    @FXML
    private TextField txtNumeroT;

    private ObservableList<serviciosTabla> servicios;
    private ObservableList<direccionTabla> direccion;
    private ObservableList<tarjetaTabla> tarjeta;


    public void initialize(URL location, ResourceBundle resources) {
        try {
            tbllServicios.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            initCombo();
            initTablaServicio();
            initTablaDirecciones();
            initTablaTarjetas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void multiple() throws Exception {
        try {
            ObservableList<serviciosTabla> selectedItems = tbllServicios.getSelectionModel().getSelectedItems();

            // TEST
            ArrayList<TreeMap<String, String>> servicios = new ArrayList<TreeMap<String, String>>();

            for (serviciosTabla row : selectedItems) {
                TreeMap<String, String> mapa = new TreeMap<String, String>();

                mapa.put("descripcion", row.getNombre());
                mapa.put("tipo", row.getTipo());

                servicios.add(mapa);
            }

            direccionTabla objDireccion = tblDirecciones.getSelectionModel().getSelectedItem();
            tarjetaTabla objTabla = tblTarjeta.getSelectionModel().getSelectedItem();

            String mensaje = objUI.registrarPedido(servicios, objTabla, objDireccion);

//Para la alerta
            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();
        } catch (Exception e) {
            throw e;
        }


    }

    public void initCombo() throws Exception {
        try {

            cmnProvincia.setItems(objUI.listaProvincias());
            cmbCanton.setItems(objUI.listaCantones());
            cmbDistrito.setItems(objUI.listaDistritos());
        } catch (Exception e) {
            throw e;
        }
    }

    public void initTablaServicio() throws Exception {
        try {
            servicios = FXCollections.observableArrayList();

            colNombreS.setCellValueFactory(new PropertyValueFactory("Nombre"));
            colTipoS.setCellValueFactory(new PropertyValueFactory("Tipo"));
            colPrecioLitroS.setCellValueFactory(new PropertyValueFactory("PrecioLitro"));
            colPrecioBaseS.setCellValueFactory(new PropertyValueFactory("PrecioBase"));


            tbllServicios.setItems(objUI.imprimirServicios());

        } catch (Exception e) {
            throw e;
        }
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

    @FXML
    void agregarDireccion(ActionEvent event) throws Exception {
        try {
            String provincia = cmnProvincia.getValue();
            String distrito = cmbDistrito.getValue();
            String canton = cmbCanton.getValue();
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
    void agregarTarjeta(ActionEvent event) throws Exception {

        try {
            String nombre = txtNombreT.getText();
            String numero = txtNumeroT.getText();
            String ccv = txtCCVT.getText();
            String fechaVence = dtFechaVenceT.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));


            String mensaje = objUI.registrarTarjeta(nombre, numero, fechaVence, ccv);

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
    void realizarPedido(ActionEvent event) throws Exception {

        try {
            multiple();

        } catch (Exception e) {
            throw e;
        }


    }

    @FXML
    void seleccionCanton(ActionEvent event) throws Exception {
        cmbDistrito.setItems(objUI.distritosCantones(cmbCanton.getValue()));
    }

    @FXML
    void seleccionProvincia(ActionEvent event) throws Exception {
        cmbCanton.setItems(objUI.cantonesProvincias(cmnProvincia.getValue()));
    }

    @FXML
    void verPedidos(ActionEvent event) throws IOException {
        String mensaje = objUI.verPedidos();

        FXMLLoader loader = new FXMLLoader(getClass().getResource(mensaje));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        Stage myStage = (Stage) this.btnPedidos.getScene().getWindow();
        myStage.close();
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
