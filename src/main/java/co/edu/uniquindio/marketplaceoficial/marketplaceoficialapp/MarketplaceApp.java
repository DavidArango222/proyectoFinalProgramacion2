package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller.MarketplaceViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MarketplaceApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader marketplaceLoader = new FXMLLoader(getClass().getResource("marketplace.fxml"));
        Scene scene = new Scene(marketplaceLoader.load());
        MarketplaceViewController marketplaceController = marketplaceLoader.getController();
        primaryStage.setTitle("TradeHub");
        primaryStage.getIcons().add(new Image("file:src/main/resources/images/tradehub-icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}