package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.memento.TabPersistenciaManager;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller.LoginViewController;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller.MarketplaceViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Login extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Scene scene = new Scene(loginLoader.load());
        LoginViewController LoginController = loginLoader.getController();
        primaryStage.setTitle("TradeHub");
        primaryStage.getIcons().add(new Image("file:src/main/resources/images/tradehub-icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    @Override
    public void stop() {
        TabPersistenciaManager.limpiarDatos();
        TabPersistenciaManager.limpiarArchivo();
    }

    public static void main(String[] args) {
        launch();
    }
}
