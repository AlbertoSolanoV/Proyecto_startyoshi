package solano.alberto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import solano.alberto.logic.gestorUsuarios;


public class Iniciador extends Application {

    public void start(Stage primaryStage) throws Exception {
         gestorUsuarios objGestor = new gestorUsuarios();
        if(objGestor.existeAdmin().equals("No existe")){
            Parent root = FXMLLoader.load(getClass().getResource("RegistrarAdmin.fxml"));
            primaryStage.setTitle("Login");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }else{
            Parent root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
            primaryStage.setTitle("Login");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        }



    }

}
