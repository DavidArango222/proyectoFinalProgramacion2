package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller.LoginController;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller.MuroController;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorUsuarioDto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.mapper.MarketplaceMappingImpl;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.*;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IObservador;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class MuroViewController implements IObservador {
    MuroController muroController;
    Marketplace marketplace;
    String cedula = MarketplaceViewController.getCurrentCedula();
    Producto productoSeleccionado;
    ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    ObservableList<Vendedor> contactos = FXCollections.observableArrayList();
    MarketplaceViewController marketplaceViewController;
    VendedorUsuarioDto usuarioActual;
    MarketplaceMappingImpl mapper;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarContacto;

    @FXML
    private Button btnEnviarComentario;

    @FXML
    private Button btnEnviarMensaje;

    @FXML
    private Button btnLike;

    @FXML
    private Label comentario;

    @FXML
    private TextField comentarioVendedor;

    @FXML
    private ImageView imgProducto;

    @FXML
    private Label labelCantidadComentarios;

    @FXML
    private Label labelCantidadLikes;

    @FXML
    private Label labelCategoria;

    @FXML
    private Label labelEstado;

    @FXML
    private Label labelMensaje;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelPrecio;

    @FXML
    private Label labelIdProducto;

    @FXML
    private TableView<Comentario> tableComentarios;

    @FXML
    private TableView<Vendedor> tableContactosAgregados;

    @FXML
    private TableView<Vendedor> tableContactosMensajes;

    @FXML
    private TableView<Producto> tableProductos;

    @FXML
    private TableView<Vendedor> tableVendedores;

    @FXML
    private TableColumn<Vendedor, String> tcApellidoContacto;

    @FXML
    private TableColumn<Vendedor, String> tcApellidoMensaje;

    @FXML
    private TableColumn<Vendedor, String> tcApellidoVendedor;

    @FXML
    private TableColumn<Producto, String> tcCategoria;

    @FXML
    private TableColumn<Vendedor, String> tcCedulaContacto;

    @FXML
    private TableColumn<Vendedor, String> tcCedulaMensaje;

    @FXML
    private TableColumn<Vendedor, String> tcCedulaVendedor;

    @FXML
    private TableColumn<Comentario, String> tcComentarios;

    @FXML
    private TableColumn<Vendedor, String> tcDireccionContacto;

    @FXML
    private TableColumn<Vendedor, String> tcDireccionMensaje;

    @FXML
    private TableColumn<Vendedor, String> tcDireccionVendedor;

    @FXML
    private TableColumn<Producto, String> tcEstado;

    @FXML
    private TableColumn<Producto, String> tcFecha;

    @FXML
    private TableColumn<Producto, String> tcId;

    @FXML
    private TableColumn<Producto, String> tcImagen;

    @FXML
    private TableColumn<Producto, String> tcNombre;

    @FXML
    private TableColumn<Vendedor, String> tcNombreContacto;

    @FXML
    private TableColumn<Vendedor, String> tcNombreMensaje;

    @FXML
    private TableColumn<Vendedor, String> tcNombreVendedor;

    @FXML
    private TableColumn<Producto, String> tcPrecio;

    @FXML
    private TextArea txtMensajes;

    @FXML
    private TextField txtComentarioProducto;

    @FXML
    void onActionAgregarContacto(ActionEvent event) {
        agregarContacto();
    }

    private void agregarContacto() {
        Vendedor vendedor = tableVendedores.getSelectionModel().getSelectedItem();
        if (vendedor == null) {
            System.out.println("Debe seleccionar un vendedor.");
            return;
        }
        muroController.agregarContacto(cedula, vendedor.getCedula());
        actualizar();
    }

    @FXML
    void onActionEnviarComentario(ActionEvent event) {
        if (productoSeleccionado != null) {
            String comentarioText = txtComentarioProducto.getText();
            if (!comentarioText.isEmpty() && usuarioActual != null) {
                Comentario nuevoComentario = new Comentario(mapper.vendedorUsuarioDtoToUsuario(usuarioActual), comentarioText);

                productoSeleccionado.getPublicacion().getComentarios().add(nuevoComentario);

                txtComentarioProducto.clear();

                mostrarComentariosProducto();
            }
        }

    }

    @FXML
    void onActionEnviarMensaje(ActionEvent event) {
        Vendedor contactoSeleccionado = tableContactosMensajes.getSelectionModel().getSelectedItem();
        if (contactoSeleccionado == null) {
            System.out.println("Debe seleccionar un contacto.");
            return;
        }
        String mensajeTexto = comentarioVendedor.getText();
        if (mensajeTexto == null || mensajeTexto.isEmpty()) {
            System.out.println("El mensaje está vacío.");
            return;
        }
        Mensaje nuevoMensaje = new Mensaje(
                mensajeTexto,
                muroController.obtenerVendedor(cedula), // Emisor
                contactoSeleccionado                    // Receptor
        );
        muroController.enviarMensaje(cedula, nuevoMensaje);
        comentarioVendedor.clear();
        mostrarMensajesContacto(contactoSeleccionado);
        actualizar();
    }

    @FXML
    void onActionLike(ActionEvent event) {
        darLike();
    }

    private void darLike() {
        if (productoSeleccionado != null) {
            productoSeleccionado.getPublicacion().agregarLike();
            mostrarLikesDelProducto();
        }
    }

    @FXML
    void initialize() {
        if (cedula == null || cedula.isEmpty()) {
            System.out.println("Cédula no válida.");
            return;
        }
        muroController = new MuroController();
        marketplace = muroController.getModelFactory();
        mapper = new MarketplaceMappingImpl();
        usuarioActual= LoginController.getVendedorLogueado();
        marketplace.agregarObservador(this);
        initView();
        actualizar();
        if (!tableContactosMensajes.getItems().isEmpty()) {
            tableContactosMensajes.getSelectionModel().select(0);
            mostrarMensajesContacto(tableContactosMensajes.getSelectionModel().getSelectedItem());
        }
    }

    public void verificarPermisosAcciones() {
        VendedorUsuarioDto vendedorLogueado = LoginController.getVendedorLogueado();

        if(vendedorLogueado!=null){
            boolean esVendedorActual = this.cedula.equals(vendedorLogueado.cedula());

            if (esVendedorActual) {
                txtMensajes.setDisable(false);
                btnAgregarContacto.setDisable(false);
                btnEnviarMensaje.setDisable(false);
            } else {
                btnEnviarMensaje.setDisable(true);
                txtMensajes.setDisable(true);
                btnAgregarContacto.setDisable(true);
            }
        }else {
            txtMensajes.setDisable(false);
            btnAgregarContacto.setDisable(false);
            btnEnviarMensaje.setDisable(false);
        }
    }



    private void initView() {
        initDataBindingTableProductos();
        initDataBindingTableComentarios();
        initDataBindingTableContactosAgregados();
        initDataBindingTableContactosMensajes();
        initDataBindingTableVendedores();
        listenerSelectionTableProducto();
        listenerSelectionTableContactosAgregados();
        listenerSelectionTableContactosMensajes();
        agregarLikes();
        agregarComentarios();
        verificarPermisosAcciones();
    }

    private void listenerSelectionTableContactosMensajes() {
        tableContactosMensajes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                mostrarMensajesContacto(newSelection);
            }
        });
    }

    private void mostrarMensajesContacto(Vendedor contactoSeleccionado) {
        if (contactoSeleccionado == null) {
            txtMensajes.clear();
            return;
        }
        List<Mensaje> mensajes = muroController.getMensajesEntreUsuarios(cedula, contactoSeleccionado.getCedula());
        if (mensajes != null && !mensajes.isEmpty()) {
            String mensajesConcatenados = mensajes.stream()
                    .map(m -> m.getRemitente().getNombre() + ": " + m.getMensaje())
                    .collect(Collectors.joining("\n"));
            txtMensajes.setText(mensajesConcatenados);
        } else {
            txtMensajes.setText("No hay mensajes aún.");
        }
    }

    private void initDataBindingTableComentarios() {
        tcComentarios.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContenido()));
    }

    private void agregarComentarios() {
        tableProductos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                productoSeleccionado = newValue;
                mostrarComentariosProducto();
            }
        });
    }

    private void agregarLikes() {
        ObservableList<Producto> productos = FXCollections.observableArrayList(muroController.getProductos());
        tableProductos.setItems(productos);

        tableProductos.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                productoSeleccionado = newValue;
                mostrarLikesDelProducto();
            }
        });
    }

    private void mostrarComentariosProducto() {
        if (productoSeleccionado != null && productoSeleccionado.getPublicacion() != null) {
            List<Comentario> comentarios = productoSeleccionado.getPublicacion().getComentarios();
            ObservableList<Comentario> comentariosList = FXCollections.observableArrayList(comentarios);
            tableComentarios.setItems(comentariosList);
        } else {
            tableComentarios.setItems(FXCollections.observableArrayList());
        }
    }

    private void mostrarLikesDelProducto() {
        if (productoSeleccionado != null && productoSeleccionado.getPublicacion() != null) {
            int likes = productoSeleccionado.getPublicacion().getLike();
            labelCantidadLikes.setText("Likes: " + likes);
        } else {
            labelCantidadLikes.setText("Likes: 0");
        }
    }


    private void listenerSelectionTableContactosAgregados() {
        tcNombreContacto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellidoContacto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcCedulaContacto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcDireccionContacto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
    }

    private void initDataBindingTableVendedores() {
        tcNombreVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellidoVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcCedulaVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcDireccionVendedor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
    }


    private void listenerSelectionTableProducto() {
        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            if (productoSeleccionado != null) {
                mostrarInformacionProductoLabel(productoSeleccionado);
            }
        });
    }

    private void mostrarInformacionProductoLabel(Producto productoSeleccionado) {
        labelNombre.setText(productoSeleccionado.getNombre());
        labelPrecio.setText(String.valueOf(productoSeleccionado.getPrecio()));
        labelCategoria.setText(productoSeleccionado.getCategoria());
        labelIdProducto.setText(productoSeleccionado.getIdProducto());
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


    private void initDataBindingTableContactosMensajes() {
        tcNombreMensaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellidoMensaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcCedulaMensaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcDireccionMensaje.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
    }

    private void initDataBindingTableContactosAgregados() {
        tcNombreContacto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellidoContacto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcCedulaContacto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcDireccionContacto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
    }

    private void initDataBindingTableProductos() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcPrecio.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrecio()).asString());
        tcCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategoria()));
        tcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoEstado().toString()));
        tcId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdProducto()));
        tcImagen.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getImagen()));

        tcFecha.setCellValueFactory(cellData -> {
            LocalDateTime fecha = cellData.getValue().getFecha();
            return new SimpleStringProperty(fecha != null ? fecha.toString() : "Sin fecha");
        });
    }

    @Override
    public void actualizar() {
        obtenerProductosVendedor();
        obtenerContantosAgregados(cedula);
        obtenerVendedores();
        obtenerContactosMensajes();
        Vendedor contactoSeleccionado = tableContactosMensajes.getSelectionModel().getSelectedItem();
        if (contactoSeleccionado != null) {
            mostrarMensajesContacto(contactoSeleccionado);
        }
    }


    private void obtenerContactosMensajes() {
        List<Vendedor> contactosMensajes = MarketplaceViewController.obtenerContactosVendedor(cedula);
        ObservableList<Vendedor> listaContactosMensajesObservables = FXCollections.observableArrayList(contactosMensajes);
        tableContactosMensajes.setItems(listaContactosMensajesObservables);
    }

    private void obtenerProductosVendedor() {
        // Obtener el vendedor actual
        Vendedor vendedor = muroController.obtenerVendedor(cedula);
        if (vendedor != null) {
            // Obtener solo los productos del vendedor actual
            List<Producto> productosVendedor = vendedor.getProductos();
            ObservableList<Producto> listaProductosObservables = FXCollections.observableArrayList(productosVendedor);
            tableProductos.setItems(listaProductosObservables);
        } else {
            System.out.println("No se encontraron productos para el vendedor con cédula: " + cedula);
            tableProductos.setItems(FXCollections.observableArrayList());
        }
    }


    private void obtenerVendedores() {
        List<Vendedor> vendedores = muroController.obtenerVendedores();
        ObservableList<Vendedor> listaVendedoresObservables = FXCollections.observableArrayList(vendedores);
        tableVendedores.setItems(listaVendedoresObservables);
    }

    private void obtenerContantosAgregados(String cedula) {
        if (cedula == null || cedula.isEmpty()) {
            System.out.println("Cédula no válida.");
            return;
        }
        Vendedor vendedor = muroController.obtenerVendedor(cedula);
        if (vendedor != null && vendedor.getContactos() != null) {
            contactos.setAll(vendedor.getContactos());
            tableContactosAgregados.setItems(contactos);
        } else {
            System.out.println("No se encontraron contactos para la cédula: " + cedula);
        }
    }
}