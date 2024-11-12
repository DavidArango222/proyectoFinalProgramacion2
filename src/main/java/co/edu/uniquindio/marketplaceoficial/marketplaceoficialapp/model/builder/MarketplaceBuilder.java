package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Marketplace;

public class MarketplaceBuilder {
    protected String nombre;

    public MarketplaceBuilder nombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public Marketplace build(){
        return new Marketplace(nombre);
    }
}