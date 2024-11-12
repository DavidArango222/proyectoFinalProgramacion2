package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder.AdministradorBuilder;

public class Administrador extends Persona{
    public Administrador(){}

    public Administrador(String nombre,
                         String apellido,
                         String cedula,
                         String direccion) {
        super(nombre,apellido,cedula,direccion);
    }

    public static AdministradorBuilder builder(){
        return new AdministradorBuilder();
    }
}
