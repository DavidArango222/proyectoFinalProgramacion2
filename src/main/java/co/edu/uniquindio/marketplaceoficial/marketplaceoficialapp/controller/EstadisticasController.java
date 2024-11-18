package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class EstadisticasController {
    ModelFactory modelFactory;

    public EstadisticasController() {
        modelFactory = ModelFactory.getInstance();
    }

    public int contarMensajesVendedores(String text, String text1) {
        return modelFactory.contarMensajesVendedores( text,  text1);
    }

    public int contarProductosFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        return modelFactory.contarProductosFechas( fechaInicio,  fechaFin);
    }

    public int contarProductosPorVendedor(String text) {
        return modelFactory.contarProductosPorVendedor( text);
    }

    public List<Producto> obtenerTopProductosLikes() {
        return modelFactory.obtenerTopProductosLikes();
    }

    public Map<String, Integer> contarContactosPorVendedor() {
        return modelFactory.contarContactosPorVendedor();
    }
}
