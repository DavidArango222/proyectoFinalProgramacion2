package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller.AdministradorController;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorUsuarioDto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IObservador;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.utils.MarketplaceConstantes.*;

public class AdministradorViewController implements IObservador {
    MarketplaceViewController marketplaceViewController;
    AdministradorController administradorController;
    ObservableList<VendedorUsuarioDto> listaVendedores = FXCollections.observableArrayList();
    VendedorUsuarioDto vendedorSeleccionado;


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
        agregarVendedor();
    }

    @FXML
    void onActionEliminar(ActionEvent event) {
        eliminarVendedor();

    }

    @FXML
    void onActualizarVendedor(ActionEvent event) {
        actualizarVendedor();

    }

    @FXML
    void initialize() {
        administradorController = new AdministradorController();
        initView();
        actualizar();
    }

    private void initView() {
        initDataBinding();
        listenerSelection();
    }

    private void listenerSelection() {
        tableVendedor.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
            if (vendedorSeleccionado != null) {
                mostrarInformacionVendedor(vendedorSeleccionado);
            }
        });
    }

    private void obtenerVendedores() {
        listaVendedores.addAll(administradorController.getVendedoresUsuarioDto());
        tableVendedor.getItems().clear();
        tableVendedor.setItems(listaVendedores);
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        tcDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().direccion()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        tcUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreUsuario()));
        tcContrasena.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().contrasena()));
    }

    private void agregarVendedor() {
        VendedorUsuarioDto vendedorUsuarioDto = crearVendedor();
        if (datosValidosUsuario(vendedorUsuarioDto) && datosValidosVendedor(vendedorUsuarioDto)) {
            boolean usuarioAgregado = administradorController.agregarUsuarioDto(vendedorUsuarioDto);
            boolean vendedorAgregado = administradorController.agregarVendedorDto(vendedorUsuarioDto);
            if (listaVendedores.size() < 11) {
                if (usuarioAgregado && vendedorAgregado) {
                    listaVendedores.addAll(vendedorUsuarioDto);
                    marketplaceViewController.agregarTabVendedor(vendedorUsuarioDto.cedula());
                    limpiarCampos();
                    tableVendedor.refresh();
                    mostrarMensaje(TITULO_VENDEDOR_USUARIO_AGREGADO, HEADER, BODY_VENDEDOR_USUARIO_AGREGADO, Alert.AlertType.INFORMATION);
                } else {
                    mostrarMensaje(TITULO_VENDEDOR_USUARIO_NO_AGREGADO, HEADER, BODY_VENDEDOR_USUARIO_NO_AGREGADO, Alert.AlertType.ERROR);
                }
            } else{
                mostrarMensaje(TITULO_MAXIMO_VENDEDORES,HEADER,BODY_MAXIMO_VENDEDORES, Alert.AlertType.WARNING);
            }
        }else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.INFORMATION);
        }
    }

    private void eliminarVendedor() {
        if (datosValidosUsuario(vendedorSeleccionado) && datosValidosVendedor(vendedorSeleccionado))
            if (administradorController.eliminarVendedorUsuario(vendedorSeleccionado)) {
                marketplaceViewController.eliminarTabVendedor(vendedorSeleccionado.cedula());
                listaVendedores.remove(vendedorSeleccionado);
                limpiarCampos();
                tableVendedor.refresh();
                mostrarMensaje(TITULO_VENDEDOR_USUARIO_ELIMINADO, HEADER, BODY_VENDEDOR_USUARIO_ELIMINADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_VENDEDOR_USUARIO_NO_ELIMINADO, HEADER, BODY_VENDEDOR_USUARIO_NO_ELIMINADO, Alert.AlertType.ERROR);
            }else {
            mostrarMensaje(TITULO_NO_SELECCIONADO, HEADER, BODY_NO_SELECCIONADO, Alert.AlertType.INFORMATION);
            }
    }

    private void actualizarVendedor() {
        VendedorUsuarioDto vendedorUsuarioDto = crearVendedor();
        String cedulaVieja = vendedorSeleccionado.cedula();
        if (datosValidosUsuario(vendedorUsuarioDto) && datosValidosVendedor(vendedorUsuarioDto)) {
            if (administradorController.actualizarVendedorUsuario(vendedorSeleccionado.nombreUsuario(), vendedorSeleccionado.cedula(), vendedorUsuarioDto)) {
                actualizarUsuarioVendedorListaObserver(vendedorUsuarioDto);
                marketplaceViewController.actualizarTabVendedor(cedulaVieja, vendedorUsuarioDto.cedula());
                limpiarCampos();
                tableVendedor.refresh();
                mostrarMensaje(TITULO_VENDEDOR_USUARIO_ACTUALIZADO, HEADER, BODY_VENDEDOR_USUARIO_ACTUALIZADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_VENDEDOR_USUARIO_NO_ACTUALIZADO, HEADER, BODY_VENDEDOR_USUARIO_NO_ACTUALIZADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_NO_SELECCIONADO, HEADER, BODY_NO_SELECCIONADO, Alert.AlertType.INFORMATION);
        }
    }



    public void setMarketplaceController(MarketplaceViewController marketplaceViewController) {
        this.marketplaceViewController = marketplaceViewController;
    }

    private void mostrarInformacionVendedor(VendedorUsuarioDto vendedorSeleccionado) {
        if (vendedorSeleccionado != null) {
            txtNombre.setText(vendedorSeleccionado.nombre());
            txtApellido.setText(vendedorSeleccionado.apellido());
            txtDireccion.setText(vendedorSeleccionado.direccion());
            txtCedula.setText(vendedorSeleccionado.cedula());
            txtUsuario.setText(vendedorSeleccionado.nombreUsuario());
            txtContrasena.setText(vendedorSeleccionado.contrasena());
        }
    }

    private VendedorUsuarioDto crearVendedor() {
        return new VendedorUsuarioDto(txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtDireccion.getText(),
                txtUsuario.getText(),
                txtContrasena.getText());
    }

    private boolean datosValidosVendedor(VendedorUsuarioDto vendedorUsuarioDto) {
        if(vendedorUsuarioDto.nombre().isEmpty() ||
                vendedorUsuarioDto.apellido().isEmpty() ||
                vendedorUsuarioDto.cedula().isEmpty() ||
                vendedorUsuarioDto.direccion().isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    private boolean datosValidosUsuario(VendedorUsuarioDto vendedorUsuarioDto) {
        if(vendedorUsuarioDto.nombreUsuario().isBlank() ||
                vendedorUsuarioDto.contrasena().isBlank()){
            return false;
        }else{
            return true;
        }
    }

    private void actualizarUsuarioVendedorListaObserver(VendedorUsuarioDto vendedorUsuarioDto) {
        for (int i = 0; i < listaVendedores.size(); i++) {
            if (listaVendedores.get(i).cedula().equals(vendedorSeleccionado.cedula())) {
                listaVendedores.set(i, vendedorUsuarioDto);
                break;
            }
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtDireccion.clear();
        txtCedula.clear();
        txtUsuario.clear();
        txtContrasena.clear();
    }


    @Override
    public void actualizar() {
        obtenerVendedores();
    }
}

