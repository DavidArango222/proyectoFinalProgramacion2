package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Marketplace;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;

import java.util.List;

public class MuroController {
    ModelFactory modelFactory;

    public MuroController() {
        this.modelFactory = ModelFactory.getInstance();
    }


    public Marketplace getModelFactory() {
        return modelFactory.getMarketplace();
    }

    public List<Vendedor> obtenerContactos(String cedula) {
        return modelFactory.obtenerContactos(cedula);
    }

    public List<Vendedor> obtenerVendedores() {
        return modelFactory.obtenerVendedores();
    }

    public List<Vendedor> obtenerContactosMensajes(String cedula) {
        return modelFactory.obtenerContactosMensajes(cedula);
    }

    public Vendedor obtenerVendedor(String cedula) {
        return modelFactory.obtenerVendedor(cedula);
    }


    public List<Producto> getProductos() {
        return modelFactory.getProductos();
    }

    public List<Producto> obtenerProductos(String cedula) {
        return modelFactory.obtenerProductos(cedula);
    }

    public void agregarContacto(String cedula, String cedula1) {
        modelFactory.agregarContacto(cedula, cedula1);
    }
}