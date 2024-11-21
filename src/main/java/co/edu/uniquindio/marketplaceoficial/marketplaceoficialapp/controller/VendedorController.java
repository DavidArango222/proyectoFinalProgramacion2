package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;

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
        if (cedula == null || cedula.isEmpty()) {
            System.out.println("Cédula inválida: " + cedula);
            return null;
        }
        return modelFactory.obtenerVendedor(cedula);
    }
}
