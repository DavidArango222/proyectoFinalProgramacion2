package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Administrador;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Usuario;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;

public class UsuarioBuilder {
    protected String nombreUsuario, contrasena;
    protected Vendedor vendedorAsociado;
    protected Administrador administradorAsociado;

    public UsuarioBuilder nombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        return this;
    }

    public UsuarioBuilder contrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }

    public UsuarioBuilder vendedorAsociado(Vendedor vendedor) {
        this.vendedorAsociado = vendedor;
        return this;
    }

    public UsuarioBuilder administradorAsociado(Administrador administrador) {
        this.administradorAsociado = administrador;
        return this;
    }

    public Usuario build() {
        return new Usuario(nombreUsuario, contrasena, vendedorAsociado, administradorAsociado);
    }
}
