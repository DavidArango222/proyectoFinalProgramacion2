package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;
import javafx.scene.image.Image;

import java.time.LocalDateTime;

public class ProductoBuilder {
    protected String nombre;
    protected double precio;
    protected String categoria;
    protected String imagen;
    protected TipoEstado tipoEstado;
    protected String idProducto;
    protected LocalDateTime fecha;
    protected Vendedor vendedorAsociado;

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

    public ProductoBuilder imagen(String imagen){
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
    public ProductoBuilder fecha(LocalDateTime fecha){
        this.fecha=fecha;
        return this;
    }

    public ProductoBuilder vendedor(Vendedor vendedor){
        this.vendedorAsociado=vendedor;
        return this;
    }

    public Producto build(){
        return new Producto(nombre,
                precio,
                categoria,
                imagen,
                tipoEstado,
                idProducto,
                fecha,vendedorAsociado);
    }
}
