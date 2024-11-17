package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.strategy;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.EstrategiaLogin;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.viewcontroller.MarketplaceViewController;

public class EstrategiaLoginVendedor implements EstrategiaLogin {

    @Override
    public void abrirTab(MarketplaceViewController controller, String cedula) {
        controller.mostrarTabVendedor(cedula);
    }
}

