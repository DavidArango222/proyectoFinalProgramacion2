package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;

public class MarketplaceViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab administradorTab;

    @FXML
    void initialize() {
        assert administradorTab != null : "fx:id=\"administradorTab\" was not injected: check your FXML file 'marketplace.fxml'.";

    }
}
