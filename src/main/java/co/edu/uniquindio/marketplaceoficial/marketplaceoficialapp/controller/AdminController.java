package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;

public class AdminController {
    ModelFactory modelFactory;

    public AdminController() {
        modelFactory = ModelFactory.getInstance();
    }

    public boolean agregarVendedor(String nombre, String cedula) {
        return modelFactory.agregarVendedor(nombre, cedula);
    }

    public boolean eliminarVendedor(String cedula) {
        return modelFactory.eliminarVendedor(cedula);
    }

}
