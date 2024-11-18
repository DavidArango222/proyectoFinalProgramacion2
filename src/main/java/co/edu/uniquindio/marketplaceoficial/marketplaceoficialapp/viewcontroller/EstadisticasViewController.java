package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.adapter.ReporteTextoAdapter;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller.EstadisticasController;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Marketplace;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.ReporteAdapter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EstadisticasViewController {
    private EstadisticasController estadisticasController;

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
        anadirProductosPublicadosVendedor();
    }

    private void anadirProductosPublicadosVendedor() {
        txtCedulaBuscar.setDisable(true);
        boolean selected = chkAñadirProductosPublicadosVendedor.isSelected();
        txtCedulaBuscar.setDisable(!selected);
    }

    @FXML
    void onChkAñadirReporteMensajesVendedores(ActionEvent event) {
        anadirReporteMensajesVendedores();
    }

    private void anadirReporteMensajesVendedores() {
        txtCedulaVendedor1.setDisable(true);
        txtCedulaVendedor2.setDisable(true);
        boolean selected = chkAñadirReporteMensajesVendedores.isSelected();
        txtCedulaVendedor1.setDisable(!selected);
        txtCedulaVendedor2.setDisable(!selected);
    }

    @FXML
    void onChkAñadirTopProductos(ActionEvent event) {
        anadirTopProductos();
    }

    private void anadirTopProductos() {
        chkAñadirTopProductos.isSelected();
    }

    @FXML
    void onChkCantidadContactos(ActionEvent event) {
        cantidadContactos();
    }

    private void cantidadContactos() {
        chkCantidadContactos.isSelected();
    }

    @FXML
    void onChkProductosPublicadosFecha(ActionEvent event) {
        productosPublicadosFecha();
    }

    private void productosPublicadosFecha() {
        DateInicio.setDisable(true);
        DateFin.setDisable(true);
        boolean selected = chkProductosPublicadosFecha.isSelected();
        DateInicio.setDisable(!selected);
        DateFin.setDisable(!selected);
    }

    @FXML
    void onGenerarReporte(ActionEvent event) {
        generarReporte();
    }

    private void generarReporte() {
        StringBuilder contenidoReporte = new StringBuilder();
        if (chkAñadirReporteMensajesVendedores.isSelected()) {
            int mensajes = estadisticasController.contarMensajesVendedores(
                    txtCedulaVendedor1.getText(),
                    txtCedulaVendedor2.getText());
            contenidoReporte.append("Cantidad de mensajes enviados entre vendedores: ").append(mensajes).append("\n");
        }
        if (chkProductosPublicadosFecha.isSelected()) {
            LocalDate fechaInicioLocal = DateInicio.getValue();
            LocalDate fechaFinLocal = DateFin.getValue();

            LocalDateTime fechaInicio = fechaInicioLocal.atStartOfDay();
            LocalDateTime fechaFin = fechaFinLocal.atTime(23, 59, 59);

            int productosFecha = estadisticasController.contarProductosFechas(fechaInicio, fechaFin);
            contenidoReporte.append("Cantidad de productos publicados entre fechas: ").append(productosFecha).append("\n");
        }
        if (chkAñadirProductosPublicadosVendedor.isSelected()) {
            int productosVendedor = estadisticasController.contarProductosPorVendedor(txtCedulaBuscar.getText());
            contenidoReporte.append("Cantidad de productos publicados por el vendedor: ").append(productosVendedor).append("\n");
        }
        if (chkCantidadContactos.isSelected()) {
            Map<String, Integer> contactosPorVendedor = estadisticasController.contarContactosPorVendedor();
            contenidoReporte.append("Cantidad de contactos por vendedor:\n");

            for (Map.Entry<String, Integer> entry : contactosPorVendedor.entrySet()) {
                String cedula = entry.getKey();
                Integer cantidadContactos = entry.getValue();
                contenidoReporte.append("Vendedor (Cédula: ").append(cedula).append("): ").append(cantidadContactos).append(" contactos\n");
            }
        }
        if (chkAñadirTopProductos.isSelected()) {
            List<Producto> topProductos = estadisticasController.obtenerTopProductosLikes();
            contenidoReporte.append("Top 10 productos con más likes:\n");
            for (Producto producto : topProductos) {
                contenidoReporte.append(producto.getNombre()).append("\n");
            }
        }
        ReporteAdapter adapter = new ReporteTextoAdapter("src/main/java/co/edu/uniquindio/marketplaceoficial/marketplaceoficialapp/reportes/reporte.txt");
        adapter.exportarReporte(contenidoReporte.toString());
    }

    @FXML
    void initialize() {
        estadisticasController= new EstadisticasController();
    }

}

