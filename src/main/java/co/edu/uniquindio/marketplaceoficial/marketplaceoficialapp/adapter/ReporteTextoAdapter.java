package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.adapter;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.ReporteAdapter;

import java.io.FileWriter;
import java.io.IOException;

public class ReporteTextoAdapter implements ReporteAdapter {
    private String rutaArchivo;

    public ReporteTextoAdapter(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void exportarReporte(String contenido) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            StringBuilder reporte = new StringBuilder();
            reporte.append(centrarTexto("Reporte")).append(System.lineSeparator());
            reporte.append(centrarTexto(obtenerFechaActual())).append(System.lineSeparator());
            reporte.append(centrarTexto("Reporte realizado por: Administrador")).append(System.lineSeparator());
            reporte.append(System.lineSeparator());
            reporte.append("Información del reporte: ").append(System.lineSeparator());
            reporte.append(contenido);
            writer.write(reporte.toString());
            System.out.println("Reporte exportado a " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al exportar el reporte: " + e.getMessage());
        }
    }

    private String obtenerFechaActual() {
        return java.time.LocalDate.now().toString();
    }

    private String centrarTexto(String texto) {
        int anchoPagina = 80;
        int espacios = (anchoPagina - texto.length()) / 2;
        return " ".repeat(Math.max(0, espacios)) + texto;
    }

}

