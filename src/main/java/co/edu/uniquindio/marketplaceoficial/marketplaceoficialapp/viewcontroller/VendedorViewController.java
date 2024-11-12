package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller.VendedorController;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Marketplace;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IObservador;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class VendedorViewController implements IObservador {
    VendedorController vendedorController;
    Marketplace marketplace;
    Vendedor vendedor;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCrearProducto;

    @FXML
    private Button btnEliminarProducto;

    @FXML
    private Button btnModificarProducto;

    @FXML
    private ImageView imgProducto;

    @FXML
    private Label labelCategoria;

    @FXML
    private Label labelCedula;

    @FXML
    private Label labelEstado;

    @FXML
    private Label labelId;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelPrecio;

    @FXML
    private RadioButton rbCancelado;

    @FXML
    private RadioButton rbPublicado;

    @FXML
    private RadioButton rbVendido;

    @FXML
    private TableView<Producto> tableProductos;

    @FXML
    private TableColumn<Producto, String> tcCategoria;

    @FXML
    private TableColumn<Producto, String> tcEstado;

    @FXML
    private TableColumn<Producto, String> tcId;

    @FXML
    private TableColumn<Producto, String> tcImagen;

    @FXML
    private TableColumn<Producto, String> tcNombre;

    @FXML
    private TableColumn<Producto, String> tcPrecio;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtImagen;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    void cancelado(ActionEvent event) {

    }

    @FXML
    void crearProducto(ActionEvent event) {

    }

    @FXML
    void eliminarProducto(ActionEvent event) {

    }

    @FXML
    void modificarProducto(ActionEvent event) {

    }

    @FXML
    void publicado(ActionEvent event) {

    }

    @FXML
    void vendido(ActionEvent event) {

    }

    @FXML
    void initialize() {
        vendedorController = new VendedorController();
        marketplace = ModelFactory.getInstance().getMarketplace();
        marketplace.agregarObservador(this);
        vendedor = marketplace.obtenerVendedor(labelCedula.getText());
        actualizar();
    }

    @Override
    public void actualizar() {
        initDataBindingTableProductos();
    }

    private void initDataBindingTableProductos() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcPrecio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrecio()).asString());
        tcCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        tcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoEstado().toString()));
        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdProducto()));
        tcImagen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getImagen()));
    }

    public void updateView(String cedula) {
        labelCedula.setText("Vendedor: "+cedula);
        Vendedor vendedor = vendedorController.obtenerVendedor(cedula);
        if(vendedor != null) {
            labelCedula.setText(vendedor.getCedula());
        }else{
            labelCedula.setText("Vendedor no existe");
        }
    }
}
