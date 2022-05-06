package solano.alberto.TL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import solano.alberto.UI.RegistrarClienteUI;
import solano.alberto.UI.RegistrarConductorUI;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class RegistroClienteController implements Initializable {

    RegistrarClienteUI objUI = new RegistrarClienteUI();

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegistrarCliente;

    @FXML
    private DatePicker dtFechaNacimiento;

    @FXML
    private ComboBox<String> cmbCanton;

    @FXML
    private ComboBox<String> cmbDistrito;

    @FXML
    private ComboBox<String> cmbProvincia;

    @FXML
    private RadioButton rbFemenino;

    @FXML
    private RadioButton rbMasculino;

    @FXML
    private TextField txtAvatar;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtDireccionExacta;

    @FXML
    private TextField txtCelular;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            initCombo();
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

    @FXML
    void cancelarRegistroCliente(ActionEvent event) {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtIdentificacion.setText("");
        txtCorreo.setText("");
        txtContrasena.setText("");
        txtDireccionExacta.setText("");
        txtAvatar.setText("");
        txtCelular.setText("");
    }

    @FXML
    void registrarCliente(ActionEvent event) throws IOException {

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
        String celular = txtCelular.getText();
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
        String sexo = "";
        if (rbFemenino.isSelected()) {
            sexo = "F";
        } else if (rbMasculino.isSelected()) {
            sexo = "M";
        }
        String mensaje = objUI.registrarCliente(nombre, apellido, identificacion, fechaNacimiento, correo, clave, provincia, canton, distrito, direccionExacta, sexo, avatar, celular);
        if (mensaje.contains("Error")) {
            //Para la alerta
            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();
        } else {
            //Para la alerta
            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();

            String direccion = objUI.volverLogin();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(direccion));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();

            Stage myStage = (Stage) this.btnRegistrarCliente.getScene().getWindow();
            myStage.close();
        }


    }

    @FXML
    void cantonSeleccion(ActionEvent event) throws Exception {
        cmbDistrito.setItems(objUI.distritosCantones(cmbCanton.getValue()));
    }

    @FXML
    void provinciaSeleccion(ActionEvent event) throws Exception {

        cmbCanton.setItems(objUI.cantonesProvincias(cmbProvincia.getValue()));
    }

}
