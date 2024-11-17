package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder.AdministradorBuilder;

public class Administrador extends Persona{
    private Usuario usuarioAsociado;
    public Administrador(){}

    public Administrador(String nombre,
                         String apellido,
                         String cedula,
                         String direccion, Usuario usuarioAsociado) {
        super(nombre,apellido,cedula,direccion);
        this.usuarioAsociado=usuarioAsociado;
    }

    public static AdministradorBuilder builder(){
        return new AdministradorBuilder();
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }
}
