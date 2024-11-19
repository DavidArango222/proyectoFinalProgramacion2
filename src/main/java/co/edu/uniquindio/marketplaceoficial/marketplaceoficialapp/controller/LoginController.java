package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.controller;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory.ModelFactory;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorUsuarioDto;

public class LoginController {

    private ModelFactory modelFactory;
    private static VendedorUsuarioDto vendedorLogueado;


    public LoginController() {
        modelFactory = ModelFactory.getInstance();
    }


    public VendedorUsuarioDto autenticarUsuario(String usuario, String contrasena) {

        VendedorUsuarioDto vendedor = modelFactory.getVendedoresUsuarioDto()
                .stream()
                .filter(v -> v.nombreUsuario().equals(usuario) && v.contrasena().equals(contrasena))
                .findFirst()
                .orElse(null);

        if (vendedor != null) {
            vendedorLogueado = vendedor;
        }

        return vendedor;
    }

    public static VendedorUsuarioDto getVendedorLogueado() {
        return vendedorLogueado;
    }
}

