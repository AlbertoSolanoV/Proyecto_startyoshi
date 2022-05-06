package solano.alberto.TL;

import javafx.beans.property.SimpleStringProperty;
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
import solano.alberto.UI.MenuGeneralAdminUI;
import solano.alberto.UI.RegistrarConductorUI;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javafx.scene.control.TableColumn;
import solano.alberto.clasesTablas.conductoresTabla;


public class RegistroConductorController implements Initializable {
    RegistrarConductorUI objUI = new RegistrarConductorUI();
    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegistrarConductor;

    @FXML
    private Button btnVolver;

    @FXML
    private ComboBox<String> cmbCanton;

    @FXML
    private ComboBox<String> cmbDistrito;

    @FXML
    private ComboBox<String> cmbProvincia;

    @FXML
    private TableColumn<conductoresTabla, String> colEstado;

    @FXML
    private TableColumn<conductoresTabla, String> colApellido;

    @FXML
    private TableColumn<conductoresTabla, String> colCorreo;

    @FXML
    private TableColumn<conductoresTabla, String> colIdentificacion;

    @FXML
    private TableColumn<conductoresTabla, String> colNombre;

    @FXML
    private TableView<conductoresTabla> tblConductores;

    @FXML
    private DatePicker dtFechaNacimiento;

    @FXML
    private RadioButton rbEstado;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtAvatar;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccionExacta;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    private ObservableList<conductoresTabla> conductores;

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

            cmbProvincia.setItems(objUI.listaProvincias());
            cmbCanton.setItems(objUI.listaCantones());
            cmbDistrito.setItems(objUI.listaDistritos());
        } catch (Exception e) {
            throw e;
        }


    }

    public void initTabla() throws Exception {
        try {
            conductores = FXCollections.observableArrayList();

            colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
            colApellido.setCellValueFactory(new PropertyValueFactory("apellidos"));
            colIdentificacion.setCellValueFactory(new PropertyValueFactory("identificacion"));
            colCorreo.setCellValueFactory(new PropertyValueFactory("correo"));
            colEstado.setCellValueFactory(new PropertyValueFactory("estado"));


            tblConductores.setItems(objUI.imprimirConductores());

        } catch (Exception e) {
            throw e;
        }
    }

    @FXML
    void cancelarRegistroConductor(ActionEvent event) {

        txtNombre.setText("");
        txtContrasena.setText("");
        txtCorreo.setText("");
        txtIdentificacion.setText("");
        txtApellidos.setText("");
        dtFechaNacimiento.setPromptText("");

    }

    @FXML
    void registrarConductor(ActionEvent event) throws Exception {
        try {
            RegistrarConductorUI objUI = new RegistrarConductorUI();

            String nombre = txtNombre.getText();
            String apellido = txtApellidos.getText();
            String identificacion = txtIdentificacion.getText();
            String correo = txtCorreo.getText();
            String clave = txtContrasena.getText();
            String fechaNacimiento;
            String provincia;
            String canton;
            String distrito;
            String direccionExacta = txtDireccionExacta.getText();
            String avatar = txtAvatar.getText();

            if (dtFechaNacimiento.getValue() == null) {
                fechaNacimiento = "";
            } else {
                fechaNacimiento = dtFechaNacimiento.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
            if (cmbProvincia.getValue() == null) {
                provincia = "";
            } else {
                provincia = cmbProvincia.getValue();
            }
            if (cmbCanton.getValue() == null) {
                canton = "";
            } else {
                canton = cmbCanton.getValue();
            }
            if (cmbDistrito.getValue() == null) {
                distrito = "";
            } else {
                distrito = cmbDistrito.getValue();
            }
            boolean estado = rbEstado.isSelected();

            String mensaje = objUI.registrarConductor(nombre, apellido, identificacion, fechaNacimiento, correo, clave, provincia, canton, distrito, direccionExacta, estado, avatar);

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
            throw e;
        }


    }


    @FXML
    void ProvinciaSeleccionada(ActionEvent event) throws Exception {
        RegistrarConductorUI objUI = new RegistrarConductorUI();
        cmbCanton.setItems(objUI.cantonesProvincias(cmbProvincia.getValue()));
    }

    @FXML
    void cantonSeleccionado(ActionEvent event) throws Exception {
        RegistrarConductorUI objUI = new RegistrarConductorUI();
        cmbDistrito.setItems(objUI.distritosCantones(cmbCanton.getValue()));
    }

    @FXML
    void irMenu(ActionEvent event) throws IOException {
        RegistrarConductorUI objUI = new RegistrarConductorUI();

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

    @FXML
    void cambioEstado(ActionEvent event) throws Exception {
        conductoresTabla conductor = tblConductores.getSelectionModel().getSelectedItem();

        String mensaje = objUI.cambioEstadoConductor(conductor);

        //Para la alerta
        Alert a = new Alert(Alert.AlertType.NONE);

        // set alert type
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setTitle("Mensaje");
        a.setContentText(mensaje);
        // show the dialog
        a.show();
        initTabla();
    }


}