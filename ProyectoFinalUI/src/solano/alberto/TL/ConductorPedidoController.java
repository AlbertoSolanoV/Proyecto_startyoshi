package solano.alberto.TL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import solano.alberto.UI.ConductorPedidoUI;
import solano.alberto.clasesTablas.pedidosTabla;
import solano.alberto.clasesTablas.tarjetaTabla;

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ConductorPedidoController implements Initializable {
    ConductorPedidoUI objUI = new ConductorPedidoUI();
    @FXML
    private Button btnAceptarPedido;

    @FXML
    private Button btnFinalizarPedido;

    @FXML
    private TableColumn<pedidosTabla, String> colCantonC;

    @FXML
    private TableColumn<pedidosTabla, String> colCantonP;

    @FXML
    private TableColumn<pedidosTabla, String> colCodigoC;

    @FXML
    private TableColumn<pedidosTabla, String> colCodigoP;

    @FXML
    private TableColumn<pedidosTabla, String> colDescripcionC;

    @FXML
    private TableColumn<pedidosTabla, String> colDescripcionP;

    @FXML
    private TableColumn<pedidosTabla, String> colDistritoC;

    @FXML
    private TableColumn<pedidosTabla, String> colDistritoP;

    @FXML
    private TableColumn<pedidosTabla, String> colEstadoC;

    @FXML
    private TableColumn<pedidosTabla, String> colEstadoP;

    @FXML
    private TableColumn<pedidosTabla, String> colFechaCreacionC;

    @FXML
    private TableColumn<pedidosTabla, String> colFechaCreacionP;

    @FXML
    private TableColumn<pedidosTabla, String> colProvinciaC;

    @FXML
    private TableColumn<pedidosTabla, String> colProvinciaP;

    @FXML
    private TableView<pedidosTabla> tblMisPedidos;

    @FXML
    private TableView<pedidosTabla> tblPedidos;

    private ObservableList<pedidosTabla> pedido;
    private ObservableList<pedidosTabla> misPedidos;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            initTablaPedidos();
            initTablaMisPedidos();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initTablaPedidos() throws Exception {
        try {
            pedido = FXCollections.observableArrayList();

            colCantonP.setCellValueFactory(new PropertyValueFactory("canton"));
            colCodigoP.setCellValueFactory(new PropertyValueFactory("codigo"));
            colDescripcionP.setCellValueFactory(new PropertyValueFactory("descrpcion"));
            colDistritoP.setCellValueFactory(new PropertyValueFactory("distrito"));
            colProvinciaP.setCellValueFactory(new PropertyValueFactory("provincia"));
            colEstadoP.setCellValueFactory(new PropertyValueFactory("estado"));
            colFechaCreacionP.setCellValueFactory(new PropertyValueFactory("fechaCreacion"));


            tblPedidos.setItems(objUI.imprimirPedidos());

        } catch (Exception e) {
            throw e;
        }
    }

    public void initTablaMisPedidos() throws Exception {
        try {
            misPedidos = FXCollections.observableArrayList();

            colCantonC.setCellValueFactory(new PropertyValueFactory("canton"));
            colCodigoC.setCellValueFactory(new PropertyValueFactory("codigo"));
            colDescripcionC.setCellValueFactory(new PropertyValueFactory("descrpcion"));
            colDistritoC.setCellValueFactory(new PropertyValueFactory("distrito"));
            colProvinciaC.setCellValueFactory(new PropertyValueFactory("provincia"));
            colEstadoC.setCellValueFactory(new PropertyValueFactory("estado"));
            colFechaCreacionC.setCellValueFactory(new PropertyValueFactory("fechaCreacion"));


            tblMisPedidos.setItems(objUI.imprimirPedidosConductor());

        } catch (Exception e) {
            throw e;
        }
    }

    @FXML
    void PedidoAceptado(ActionEvent event) throws Exception {
        try {
            pedidosTabla objPedido = tblPedidos.getSelectionModel().getSelectedItem();

            String mensaje = objUI.aceptarPedido(objPedido.getCodigo());

            //Para la alerta
            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();
            initTablaPedidos();
            initTablaMisPedidos();
        } catch (Exception e) {
            throw e;
        }
    }

    @FXML
    void finalizarPedido(ActionEvent event) throws Exception {
        try {
            pedidosTabla objPedido = tblMisPedidos.getSelectionModel().getSelectedItem();

           String mensaje = objUI.finalizaPedido(objPedido.getCodigo());

            //Para la alerta
            Alert a = new Alert(Alert.AlertType.NONE);

            // set alert type
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setTitle("Mensaje");
            a.setContentText(mensaje);
            // show the dialog
            a.show();
            initTablaPedidos();
            initTablaMisPedidos();

        } catch (Exception e) {
            throw e;
        }
    }


}
