package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;
import javafx.scene.image.Image;

public class ProductoBuilder {
    protected String nombre;
    protected double precio;
    protected String categoria;
    protected Image imagen;
    protected TipoEstado tipoEstado;
    protected String idProducto;

    public ProductoBuilder nombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public ProductoBuilder precio(double precio){
        this.precio=precio;
        return this;
    }

    public ProductoBuilder categoria(String categoria){
        this.categoria=categoria;
        return this;
    }

    public ProductoBuilder imagen(Image imagen){
        this.imagen=imagen;
        return this;
    }

    public ProductoBuilder tipoEstado(TipoEstado tipoEstado){
        this.tipoEstado=tipoEstado;
        return this;
    }

    public ProductoBuilder idProducto(String idProducto){
        this.idProducto=idProducto;
        return this;
    }

    public Producto build(){
        return new Producto(nombre,
                precio,
                categoria,
                imagen,
                tipoEstado,
                idProducto);
    }
}
