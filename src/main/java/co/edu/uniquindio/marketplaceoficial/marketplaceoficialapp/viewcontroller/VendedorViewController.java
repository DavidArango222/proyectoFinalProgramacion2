package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller.VendedorController;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorUsuarioDto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Marketplace;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IObservador;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class VendedorViewController implements IObservador {
    VendedorController vendedorController;
    Marketplace marketplace;
    Producto productoSeleccionado;
    String cedula;

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
        marketplace = vendedorController.getModelFactory().getMarketplace();
        marketplace.agregarObservador(this);
        actualizar();
    }

    private void initView() {
        initDataBindingTableProductos();
        listenerSelection();
    }

    private void mostrarInformacionProductoLabel(Producto productoSeleccionado) {
        labelId.setText(productoSeleccionado.getIdProducto());
        labelNombre.setText(productoSeleccionado.getNombre());
        labelPrecio.setText(String.valueOf(productoSeleccionado.getPrecio()));
        labelCategoria.setText(productoSeleccionado.getCategoria());
        labelEstado.setText(productoSeleccionado.getTipoEstado().toString());
    }


    private void listenerSelection() {
        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            if (productoSeleccionado != null) {
                mostrarInformacionProducto(productoSeleccionado);
                mostrarInformacionProductoLabel(productoSeleccionado);
            }
        });
    }

    private void mostrarInformacionProducto(Producto productoSeleccionado) {
        txtNombre.setText(productoSeleccionado.getNombre());
        txtPrecio.setText(String.valueOf(productoSeleccionado.getPrecio()));
        txtCategoria.setText(productoSeleccionado.getCategoria());
        txtId.setText(productoSeleccionado.getIdProducto());
        txtImagen.setText(productoSeleccionado.getImagen());
    }

    public void updateView(String cedula) {
        this.cedula = cedula;
        labelCedula.setText(cedula);
        obtenerProductosVendedor(cedula);
    }

    private void obtenerProductosVendedor(String cedula) {
        Vendedor vendedor = marketplace.obtenerVendedor(cedula);
        if (vendedor == null) {
            System.out.println("No se encontró ningún vendedor con la cédula: " + cedula);
            return;
        }
        List<Producto> productos = vendedor.getProductos();
        if (productos.isEmpty()) {
            System.out.println("El vendedor no tiene productos.");
        }
        ObservableList<Producto> listaProductosObservables = FXCollections.observableArrayList(productos);
        tableProductos.setItems(listaProductosObservables);
    }

    @Override
    public void actualizar() {
        updateView(cedula);
        initView();
    }

    private void initDataBindingTableProductos() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcPrecio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrecio()).asString());
        tcCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        tcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoEstado().toString()));
        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdProducto()));
        tcImagen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getImagen()));
    }

}
