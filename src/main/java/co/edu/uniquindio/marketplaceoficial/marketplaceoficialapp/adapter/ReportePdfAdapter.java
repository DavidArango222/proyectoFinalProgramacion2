package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.adapter;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.ReporteAdapter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

public class ReportePdfAdapter implements ReporteAdapter {

    private String rutaArchivo;

    public ReportePdfAdapter(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void exportarReporte(String contenido) {
        try {
            PdfWriter writer = new PdfWriter(rutaArchivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            Paragraph titulo = new Paragraph("Reporte")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setBold()
                    .setFontSize(18);

            String fechaActual = java.time.LocalDate.now().toString();
            Paragraph fecha = new Paragraph(fechaActual)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12);

            Paragraph realizadoPor = new Paragraph("Reporte realizado por: Administrador")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(12);

            Paragraph subtitulo = new Paragraph("Información del reporte:")
                    .setBold()
                    .setFontSize(14)
                    .setMarginTop(20);

            Paragraph contenidoReporte = new Paragraph(contenido)
                    .setFontSize(12)
                    .setMarginTop(10);

            document.add(titulo);
            document.add(fecha);
            document.add(realizadoPor);
            document.add(new Paragraph("\n")); // Línea en blanco para separar
            document.add(subtitulo);
            document.add(contenidoReporte);

            document.close();

            System.out.println("Reporte exportado a PDF en: " + rutaArchivo);

        } catch (Exception e) {
            System.err.println("Error al exportar el reporte: " + e.getMessage());
        }
    }

}



