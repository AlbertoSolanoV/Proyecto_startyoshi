package solano.alberto.TL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import solano.alberto.UI.HistorialPedidosUI;
import solano.alberto.clasesTablas.facturaTabla;
import solano.alberto.clasesTablas.pedidosTabla;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistorialPedidosController implements Initializable {
    HistorialPedidosUI objUI = new HistorialPedidosUI();
    @FXML
    private Button btnCancelar;

    @FXML
    private TableColumn<pedidosTabla, String> colCanton;

    @FXML
    private TableColumn<facturaTabla, String> colCodFactura;

    @FXML
    private TableColumn<pedidosTabla, String> colCodigoP;

    @FXML
    private TableColumn<pedidosTabla, String> colDistrito;

    @FXML
    private TableColumn<pedidosTabla, String> colEstado;

    @FXML
    private TableColumn<pedidosTabla, String> colFechaCreacion;

    @FXML
    private TableColumn<facturaTabla, String> colFechaCreacionF;

    @FXML
    private TableColumn<pedidosTabla, String> colProvincia;

    @FXML
    private TableColumn<pedidosTabla, String> colServicio;

    @FXML
    private TableColumn<facturaTabla, String> colTotalC;

    @FXML
    private TableView<facturaTabla> tblFactura;

    @FXML
    private Button btnVolver;

    @FXML
    private TableView<pedidosTabla> tblPedido;

    private ObservableList<pedidosTabla> pedido;


    @FXML
    void cancelarPedido(ActionEvent event) throws Exception {
        try {
            pedidosTabla objPedido = tblPedido.getSelectionModel().getSelectedItem();
            String mensaje = "";
            if (objPedido.getEstado().equals("Cancelado") || objPedido.getEstado().equals("En proceso")) {
                mensaje = "No se puede cancelar ese pedido, solo las que estan en Registrado";
                Alert a = new Alert(Alert.AlertType.NONE);

                // set alert type
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setTitle("Mensaje");
                a.setContentText(mensaje);
                // show the dialog
                a.show();

            } else {
                mensaje = objUI.cancelarEstado(objPedido.getCodigo());

                //Para la alerta
                Alert a = new Alert(Alert.AlertType.NONE);

                // set alert type
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setTitle("Mensaje");
                a.setContentText(mensaje);
                // show the dialog
                a.show();
                initTablaPedidos();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        try {
            initTablaPedidos();
            initTablaFactura();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initTablaPedidos() throws Exception {
        try {
            pedido = FXCollections.observableArrayList();

            colCodigoP.setCellValueFactory(new PropertyValueFactory("codigo"));
            colCanton.setCellValueFactory(new PropertyValueFactory("canton"));
            colDistrito.setCellValueFactory(new PropertyValueFactory("distrito"));
            colEstado.setCellValueFactory(new PropertyValueFactory("estado"));
            colFechaCreacion.setCellValueFactory(new PropertyValueFactory("fechaCreacion"));
            colProvincia.setCellValueFactory(new PropertyValueFactory("provincia"));
            colServicio.setCellValueFactory(new PropertyValueFactory("descrpcion"));


            tblPedido.setItems(objUI.imprimirPedidos());

        } catch (Exception e) {
            throw e;
        }
    }

    public void initTablaFactura() throws Exception {
        try {
            pedido = FXCollections.observableArrayList();

            colCodFactura.setCellValueFactory(new PropertyValueFactory("codigo"));
            colFechaCreacionF.setCellValueFactory(new PropertyValueFactory("fechaCreacion"));
            colTotalC.setCellValueFactory(new PropertyValueFactory("total"));


            tblFactura.setItems(objUI.imprimirFactura());

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
