package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Administrador;

public class AdministradorBuilder {
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String direccion;
    protected String usuario;
    protected String contrasena;

    public AdministradorBuilder nombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public AdministradorBuilder apellido(String apellido){
        this.apellido=apellido;
        return this;
    }

    public AdministradorBuilder cedula(String cedula){
        this.cedula=cedula;
        return this;
    }

    public AdministradorBuilder direccion(String direccion){
        this.direccion=direccion;
        return this;
    }

    public AdministradorBuilder usuario(String usuario){
        this.usuario=usuario;
        return this;
    }

    public AdministradorBuilder contrasena(String contrasena){
        this.contrasena=contrasena;
        return this;
    }

    public Administrador build(){
        return new Administrador(nombre,
                apellido,
                cedula,
                direccion);
    }

}
