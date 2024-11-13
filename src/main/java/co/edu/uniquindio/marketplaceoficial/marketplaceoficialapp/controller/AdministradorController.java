package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorUsuarioDto;

import java.util.List;

public class AdministradorController {
    ModelFactory modelFactory;

    public AdministradorController() {
        modelFactory = ModelFactory.getInstance();
    }


    public List<VendedorUsuarioDto> getVendedoresUsuarioDto() {
        return modelFactory.getVendedoresUsuarioDto();
    }
}
