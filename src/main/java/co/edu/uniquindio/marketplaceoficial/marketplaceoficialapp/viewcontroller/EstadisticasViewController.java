package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EstadisticasViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker DateFin;

    @FXML
    private DatePicker DateInicio;

    @FXML
    private Button btnGenerarReporte;

    @FXML
    private CheckBox chkAñadirProductosPublicadosVendedor;

    @FXML
    private CheckBox chkAñadirReporteMensajesVendedores;

    @FXML
    private CheckBox chkAñadirTopProductos;

    @FXML
    private CheckBox chkCantidadContactos;

    @FXML
    private CheckBox chkProductosPublicadosFecha;

    @FXML
    private TextField txtCedulaBuscar;

    @FXML
    private TextField txtCedulaVendedor1;

    @FXML
    private TextField txtCedulaVendedor2;

    @FXML
    void onChkAñadirProductosPublicadosVendedor(ActionEvent event) {

    }

    @FXML
    void onChkAñadirReporteMensajesVendedores(ActionEvent event) {

    }

    @FXML
    void onChkAñadirTopProductos(ActionEvent event) {

    }

    @FXML
    void onChkCantidadContactos(ActionEvent event) {

    }

    @FXML
    void onChkProductosPublicadosFecha(ActionEvent event) {

    }

    @FXML
    void onGenerarReporte(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert DateFin != null : "fx:id=\"DateFin\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert DateInicio != null : "fx:id=\"DateInicio\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert btnGenerarReporte != null : "fx:id=\"btnGenerarReporte\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert chkAñadirProductosPublicadosVendedor != null : "fx:id=\"chkAñadirProductosPublicadosVendedor\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert chkAñadirReporteMensajesVendedores != null : "fx:id=\"chkAñadirReporteMensajesVendedores\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert chkAñadirTopProductos != null : "fx:id=\"chkAñadirTopProductos\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert chkCantidadContactos != null : "fx:id=\"chkCantidadContactos\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert chkProductosPublicadosFecha != null : "fx:id=\"chkProductosPublicadosFecha\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert txtCedulaBuscar != null : "fx:id=\"txtCedulaBuscar\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert txtCedulaVendedor1 != null : "fx:id=\"txtCedulaVendedor1\" was not injected: check your FXML file 'estadisticas.fxml'.";
        assert txtCedulaVendedor2 != null : "fx:id=\"txtCedulaVendedor2\" was not injected: check your FXML file 'estadisticas.fxml'.";

    }

}

