package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder.UsuarioBuilder;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private Vendedor vendedorAsociado;
    private Administrador administradorAsociado;

    public Usuario(String nombreUsuario, String contrasena, Vendedor vendedorAsociado, Administrador administradorAsociado) {
        this.administradorAsociado = administradorAsociado;
        this.vendedorAsociado = vendedorAsociado;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Vendedor getVendedorAsociado() {
        return vendedorAsociado;
    }

    public void setVendedorAsociado(Vendedor vendedorAsociado) {
        this.vendedorAsociado = vendedorAsociado;
    }

    public Administrador getAdministradorAsociado() {
        return administradorAsociado;
    }

    public void setAdministradorAsociado(Administrador administradorAsociado) {
        this.administradorAsociado = administradorAsociado;
    }
}
