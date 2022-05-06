package solano.alberto.TL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroAdminController {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegistrarAdministrador;

    @FXML
    private ComboBox<?> cmbCanton;

    @FXML
    private ComboBox<?> cmbDistrito;

    @FXML
    private ComboBox<?> cmbProvincia;

    @FXML
    private DatePicker dtFechaNacimiento;

    @FXML
    private TextField txtApellidos;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    void cancelarRegistroAdministrador(ActionEvent event) {

    }

    @FXML
    void registrarAdministrador(ActionEvent event) {

    }

}
