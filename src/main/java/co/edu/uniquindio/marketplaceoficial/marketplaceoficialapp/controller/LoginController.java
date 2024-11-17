package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorUsuarioDto;

public class LoginController {

    private ModelFactory modelFactory;

    public LoginController() {
        modelFactory = ModelFactory.getInstance();
    }

    public VendedorUsuarioDto autenticarUsuario(String usuario, String contrasena) {
        return modelFactory.getVendedoresUsuarioDto()
                .stream()
                .filter(v -> v.nombreUsuario().equals(usuario) && v.contrasena().equals(contrasena))
                .findFirst()
                .orElse(null);
    }
}

