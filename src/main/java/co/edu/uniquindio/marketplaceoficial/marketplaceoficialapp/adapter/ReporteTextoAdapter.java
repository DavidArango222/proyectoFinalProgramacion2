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
            writer.write(contenido);
            System.out.println("Reporte exportado a " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al exportar el reporte: " + e.getMessage());
        }
    }
}

