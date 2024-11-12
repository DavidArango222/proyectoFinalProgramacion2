package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller.AdminController;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Marketplace;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminViewController {
    MarketplaceViewController marketplaceViewController;
    AdminController adminController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtxCedulaEliminar;

    @FXML
    void onActionAgregar(ActionEvent event) {
        agregarVendedor();
    }

    @FXML
    void onActionEliminar(ActionEvent event) {
        eliminarVendedor();
    }

    @FXML
    void initialize() {
        adminController = new AdminController();
    }

    public void setMarketplaceController(MarketplaceViewController marketplaceViewController) {
        this.marketplaceViewController = marketplaceViewController;
    }

    private void agregarVendedor() {
        String nombre = txtNombre.getText();
        String cedula = txtCedula.getText();
        if (cedula != null && !cedula.isEmpty()) {
            if(adminController.agregarVendedor(nombre, cedula)){
                marketplaceViewController.agregarTabVendedor(cedula);
            }else{
                System.out.println("Vendedor ya existe");
            }
        } else {
            System.out.println("Cédula no puede estar vacía.");
        }
    }

    private void eliminarVendedor() {
        String cedula = txtxCedulaEliminar.getText();
        if (cedula != null && !cedula.isEmpty()) {
            if(adminController.eliminarVendedor(cedula)){
                marketplaceViewController.eliminarTabVendedor(cedula);
            }
        }
    }

}

