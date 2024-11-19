package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller.LoginController;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import static co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.utils.MarketplaceConstantes.*;

public class VendedorViewController implements IObservador {
    VendedorController vendedorController;
    Marketplace marketplace;
    Producto productoSeleccionado;
    String cedula;
    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Tab tabMuro;

    @FXML
    private Tab tabProductos;

    @FXML
    private Button btnCrearProducto;

    @FXML
    private Button btnEliminarProducto;

    @FXML
    private Button btnModificarProducto;

    @FXML
    private Button btnLogout;

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
    void onActionLogout(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/marketplaceoficial/marketplaceoficialapp/login.fxml"));
            Parent root = loader.load();
            Scene loginScene = new Scene(root);
            Stage stage = (Stage) btnLogout.getScene().getWindow();
            stage.setScene(loginScene);
            stage.show();
        } catch (IOException e) {
            mostrarMensaje("Error", "No se pudo cargar la pantalla de inicio de sesión", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void cancelado(ActionEvent event) {
        seleccionCancelado();
    }

    private void seleccionCancelado() {
        rbCancelado.setSelected(true);
        rbVendido.setSelected(false);
        rbPublicado.setSelected(false);
    }

    @FXML
    void crearProducto(ActionEvent event) {
        agregarProducto();
    }

    private void agregarProducto() {
        Producto producto = crearProducto();
        Vendedor vendedor = vendedorController.obtenerVendedor(cedula);
        if(datosValidos(producto)){
            if(vendedor.crearProducto(producto)){
                listaProductos.add(producto);
                limpiarCampos();
                mostrarMensaje(TITULO_PRODUCTO_AGREGADO, HEADER,
                        BODY_PRODUCTO_AGREGADO, Alert.AlertType.INFORMATION);
                actualizar();
            }else{
                mostrarMensaje(TITULO_PRODUCTO_NO_AGREGADO, HEADER,
                        BODY_PRODUCTO_NO_AGREGADO, Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    @FXML
    void eliminarProducto(ActionEvent event) {
        eliminarProductoo();
    }

    private void eliminarProductoo() {
        Vendedor vendedor = vendedorController.obtenerVendedor(cedula);
        if(datosValidos(productoSeleccionado)){
            if(vendedor.eliminarProducto(productoSeleccionado.getIdProducto())){
                listaProductos.remove(productoSeleccionado);
                limpiarCampos();
                tableProductos.refresh();
                mostrarMensaje(TITULO_PRODUCTO_ELIMINADO,HEADER,
                        BODY_PRODUCTO_ELIMINADO,Alert.AlertType.CONFIRMATION);
                actualizar();
            } else{
                mostrarMensaje(TITULO_PRODUCTO_NO_ELIMINADO,HEADER,
                        BODY_PRODUCTO_NO_ELIMINADO, Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje(TITULO_INCOMPLETO,HEADER,BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    @FXML
    void modificarProducto(ActionEvent event) {
        actualizarProducto();
    }

    private void actualizarProducto() {
        Producto producto = crearProducto();
        Vendedor vendedor = vendedorController.obtenerVendedor(cedula);
        if (datosValidos(producto)) {
            if (vendedor.actualizarProducto(productoSeleccionado.getIdProducto(),producto)) {
                actualizarListObserver(producto);
                limpiarCampos();
                tableProductos.refresh();
                mostrarMensaje(TITULO_PRODUCTO_ACTUALIZADO, HEADER, BODY_PRODUCTO_ACTUALIZADO, Alert.AlertType.CONFIRMATION);
                actualizar();
            } else {
                mostrarMensaje(TITULO_PRODUCTO_NO_ACTUALIZADO, HEADER, BODY_PRODUCTO_NO_ACTUALIZADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    @FXML
    void publicado(ActionEvent event) {
        seleccionPublicado();
    }

    private void seleccionPublicado() {
        rbPublicado.setSelected(true);
        rbVendido.setSelected(false);
        rbCancelado.setSelected(false);
    }

    @FXML
    void vendido(ActionEvent event) {
        seleccionVendido();
    }

    private void seleccionVendido() {
        rbVendido.setSelected(true);
        rbPublicado.setSelected(false);
        rbCancelado.setSelected(false);
    }

    @FXML
    void initialize() {
        vendedorController = new VendedorController();
        marketplace = vendedorController.getModelFactory().getMarketplace();
        marketplace.agregarObservador(this);
        initView();
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
        String rutaBase = "src/main/resources/images/";
        String rutaImagenCompleta = rutaBase + productoSeleccionado.getImagen();
        try {
            imgProducto.setImage(new javafx.scene.image.Image("file:" + rutaImagenCompleta));
            System.out.println("Imagen cargada correctamente: " + rutaImagenCompleta);
        } catch (Exception e) {
            System.out.println("Error al cargar la imagen: " + rutaImagenCompleta);
            imgProducto.setImage(null);
        }
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

    public void updateView(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            return;
        }
        this.cedula = cedula;
        labelCedula.setText(cedula);
        System.out.println("Cédula actualizada en la vista: " + cedula);

        obtenerProductosVendedor(cedula);

        verificarPermisosTabs();
    }

    private void verificarPermisosTabs() {
        VendedorUsuarioDto vendedorLogueado = LoginController.getVendedorLogueado();

        if(vendedorLogueado!=null){
            boolean esVendedorActual = this.cedula.equals(vendedorLogueado.cedula());

            if (esVendedorActual) {
                tabProductos.setDisable(false);
                tabMuro.setDisable(false);
            } else {
                tabProductos.setDisable(true);
                tabMuro.setDisable(false);
            }
        }else{
            tabProductos.setDisable(false);
            tabMuro.setDisable(false);
        }
    }



    private void obtenerProductosVendedor(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            System.out.println("La cédula es nula o vacía. No se pueden obtener los productos.");
            return;
        }
        Vendedor vendedor = vendedorController.obtenerVendedor(cedula);
        if (vendedor == null) {
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
        if (cedula == null || cedula.isEmpty()) {
            return;
        }
        System.out.println("Actualizando vista para la cédula: " + cedula);
        obtenerProductosVendedor(cedula);
    }

    private void initDataBindingTableProductos() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcPrecio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrecio()).asString());
        tcCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        tcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoEstado().toString()));
        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdProducto()));
        tcImagen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getImagen()));
    }

    private boolean datosValidos(Producto producto) {
        if (producto.getNombre().isEmpty() ||
                producto.getIdProducto().isEmpty() ||
                producto.getTipoEstado() == null ||
                producto.getCategoria().isEmpty() ||
                producto.getImagen().isEmpty() ||
                producto.getPrecio()==0) {
            return false;
        }
        return true;
    }

    private Producto crearProducto() {
        TipoEstado estado = null;
        if (rbVendido.isSelected()) {
            estado = TipoEstado.VENDIDO;
        } else if (rbCancelado.isSelected()) {
            estado = TipoEstado.CANCELADO;
        } else if (rbPublicado.isSelected()) {
            estado = TipoEstado.PUBLICADO;
        } else {
            mostrarMensaje(TITULO_INCOMPLETO,HEADER,BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
        return Producto.builder()
                .nombre(txtNombre.getText())
                .tipoEstado(estado)
                .idProducto(txtId.getText())
                .categoria(txtCategoria.getText())
                .precio(Integer.parseInt(txtPrecio.getText()))
                .imagen(txtImagen.getText())
                .build();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void actualizarListObserver(Producto producto) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getIdProducto().equals(productoSeleccionado.getIdProducto())) {
                listaProductos.set(i, producto);
                break;
            }
        }
    }

    private void mostrarInformacionProducto(Producto productoSeleccionado) {
        if (productoSeleccionado != null) {
            txtNombre.setText(productoSeleccionado.getNombre());
            txtId.setText(productoSeleccionado.getIdProducto());
            txtPrecio.setText(String.valueOf(productoSeleccionado.getPrecio()));
            txtCategoria.setText(productoSeleccionado.getCategoria());
            txtImagen.setText(productoSeleccionado.getImagen());
            rbPublicado.setSelected(false);
            rbVendido.setSelected(false);
            rbCancelado.setSelected(false);
            if (productoSeleccionado.getTipoEstado().equals(TipoEstado.PUBLICADO)) {
                rbPublicado.setSelected(true);
            } else if (productoSeleccionado.getTipoEstado().equals(TipoEstado.VENDIDO)) {
                rbVendido.setSelected(true);
            } else if (productoSeleccionado.getTipoEstado().equals(TipoEstado.CANCELADO)) {
                rbCancelado.setSelected(true);
            }
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtId.clear();
        txtImagen.clear();
        txtPrecio.clear();
        txtCategoria.clear();
        rbCancelado.setSelected(false);
        rbVendido.setSelected(false);
        rbPublicado.setSelected(false);
    }

}
