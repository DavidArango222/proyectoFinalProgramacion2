package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Usuario;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;

public class VendedorBuilder {
    protected String nombre;
    protected String apellido;
    protected String cedula;
    protected String direccion;
    protected Usuario usuarioAsociado;

    public VendedorBuilder nombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public VendedorBuilder usuarioAsociado(Usuario usuarioAsociado){
        this.usuarioAsociado=usuarioAsociado;
        return this;
    }

    public VendedorBuilder apellido(String apellido){
        this.apellido=apellido;
        return this;
    }

    public VendedorBuilder cedula(String cedula){
        this.cedula=cedula;
        return this;
    }

    public VendedorBuilder direccion(String direccion){
        this.direccion=direccion;
        return this;
    }

    public Vendedor build(){
        return new Vendedor(nombre,
                apellido,
                cedula,
                direccion, usuarioAsociado);
    }
}
