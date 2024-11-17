package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller.LoginController;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorUsuarioDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.utils.MarketplaceConstantes.*;

public class LoginViewController {
    private LoginController loginController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtUsuario;

    @FXML
    void initialize() {
        loginController = new LoginController();
    }

    @FXML
    void onActionLogin(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String contrasena = txtContrasena.getText();

        VendedorUsuarioDto vendedor = loginController.autenticarUsuario(usuario, contrasena);

        if (vendedor != null) {
            abrirMarketplaceView(vendedor);
        } else {
            mostrarMensaje(TITULO_INCORRECTO, HEADER, BODY_INCORRECTO, Alert.AlertType.ERROR);
        }
    }

    private void abrirMarketplaceView(VendedorUsuarioDto vendedor) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplaceoficial/marketplaceoficialapp/marketplace.fxml"));
            Parent root = loader.load();
            MarketplaceViewController marketplaceController = loader.getController();
            marketplaceController.mostrarTabVendedor(vendedor.cedula());
            Stage stage = (Stage) txtUsuario.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            mostrarMensaje(TITULO_ERROR_VISTA_MARKETPLACE, HEADER, BODY_ERROR_VISTA_MARKETPLACE, Alert.AlertType.ERROR);
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

}
