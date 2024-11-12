package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Marketplace;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.utils.DataUtil;

public class ModelFactory {
    public static ModelFactory modelFactory;
    private Marketplace marketplace;

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory() {
        marketplace = DataUtil.inicializarDatos();
    }

    public Marketplace getMarketplace() {
        return marketplace;
    }

}
