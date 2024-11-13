package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller.AdministradorController;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorUsuarioDto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AdministradorViewController {
    MarketplaceViewController marketplaceViewController;
    AdministradorController administradorController;
    ObservableList<VendedorUsuarioDto> listaVendedores = FXCollections.observableArrayList();
    VendedorUsuarioDto vendedorUsuarioSeleccionado;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableView<VendedorUsuarioDto> tableVendedor;

    @FXML
    private TableColumn<VendedorUsuarioDto, String> tcApellido;

    @FXML
    private TableColumn<VendedorUsuarioDto, String> tcCedula;

    @FXML
    private TableColumn<VendedorUsuarioDto, String> tcContrasena;

    @FXML
    private TableColumn<VendedorUsuarioDto, String> tcDireccion;

    @FXML
    private TableColumn<VendedorUsuarioDto, String> tcNombre;

    @FXML
    private TableColumn<VendedorUsuarioDto, String> tcUsuario;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtContrasena;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtUsuario;

    @FXML
    void onActionAgregar(ActionEvent event) {

    }

    @FXML
    void onActionEliminar(ActionEvent event) {

    }

    @FXML
    void onActualizarVendedor(ActionEvent event) {

    }


    @FXML
    void initialize() {
        administradorController = new AdministradorController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerVendedores();
        tableVendedor.getItems().clear();
        tableVendedor.setItems(listaVendedores);
        listenerSelection();
    }

    private void listenerSelection() {
    }

    private void obtenerVendedores() {
        listaVendedores.addAll(administradorController.getVendedoresUsuarioDto());
    }

    private void initDataBinding() {

    }

    public void setMarketplaceController(MarketplaceViewController marketplaceViewController) {
        this.marketplaceViewController = marketplaceViewController;
    }



}

