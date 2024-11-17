package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;

import java.util.List;


public class VendedorController {
    ModelFactory modelFactory;

    public VendedorController() {
        modelFactory = ModelFactory.getInstance();
    }

    public ModelFactory getModelFactory() {
        return modelFactory;
    }

    public Vendedor obtenerVendedor(String cedula) {
        return modelFactory.obtenerVendedor(cedula);
    }

    public boolean crearProducto(Producto producto) {
        return modelFactory.crearProducto(producto);
    }
}
