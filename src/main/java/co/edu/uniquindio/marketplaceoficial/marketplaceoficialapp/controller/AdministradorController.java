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

    public boolean actualizarVendedorUsuario(String nombreUsuario, String cedula, VendedorUsuarioDto vendedorUsuarioDto) {
        return modelFactory.actualizarVendedorUsuario( nombreUsuario, cedula, vendedorUsuarioDto);
    }

    public boolean eliminarVendedorUsuario(VendedorUsuarioDto vendedorUsuarioDto) {
        return modelFactory.eliminarVendedorUsuario(vendedorUsuarioDto);

    }

    public boolean agregarUsuarioDto(VendedorUsuarioDto vendedorUsuarioDto) {
        return modelFactory.agregarUsuarioDto(vendedorUsuarioDto);
    }

    public boolean agregarVendedorDto(VendedorUsuarioDto vendedorUsuarioDto) {
        return modelFactory.agregarVendedorDto(vendedorUsuarioDto);
    }
}
