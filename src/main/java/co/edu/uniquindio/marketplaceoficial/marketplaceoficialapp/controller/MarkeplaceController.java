package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;

public class MarkeplaceController {
    ModelFactory modelFactory;

    public MarkeplaceController() {
        modelFactory = ModelFactory.getInstance();
    }

    public Vendedor obtenerVendedor(String cedulaVendedor) {
        return modelFactory.obtenerVendedor(cedulaVendedor);
    }
}
