package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Marketplace;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Mensaje;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
import javafx.beans.property.Property;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Mensaje> getMensajes() {
        return modelFactory.getMensajes();
    }

    public List<Mensaje> getMensajesVendedor(String cedula) {
        return modelFactory.getMensajesVendedor(cedula);
    }

    public void enviarMensaje(String cedula, Mensaje mensaje) {
        modelFactory.enviarMensaje(cedula, mensaje);
    }

    public List<Mensaje> getMensajesEntreUsuarios(String cedulaEmisor, String cedulaReceptor) {
        // Filtrar mensajes entre emisor y receptor
        return modelFactory.getMensajesEntreUsuarios(cedulaEmisor, cedulaReceptor);
    }
}