package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller.MarketplaceViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader marketplaceLoader = new FXMLLoader(getClass().getResource("marketplace.fxml"));
        Scene scene = new Scene(marketplaceLoader.load());
        MarketplaceViewController marketplaceController = marketplaceLoader.getController();
        primaryStage.setScene(scene);
        primaryStage.setTitle("TradeHub");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}