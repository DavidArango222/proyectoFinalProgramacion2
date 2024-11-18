package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.adapter;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.ReporteAdapter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

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
            document.add(new Paragraph(contenido));
            document.close();

            System.out.println("Reporte exportado a PDF en: " + rutaArchivo);

        } catch (Exception e) {
            System.err.println("Error al exportar el reporte: " + e.getMessage());
        }
    }
}



