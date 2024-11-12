package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder.ProductoBuilder;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;
import javafx.scene.image.Image;

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    private String imagen;
    private TipoEstado tipoEstado;
    private String idProducto;

    public Producto() {
    }

    public Producto(String nombre,
                    double precio,
                    String categoria,
                    String imagen,
                    TipoEstado tipoEstado,
                    String idProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.imagen = imagen;
        this.tipoEstado = tipoEstado;
        this.idProducto = idProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public TipoEstado getTipoEstado() {
        return tipoEstado;
    }

    public static ProductoBuilder builder(){
        return new ProductoBuilder();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", imagen=" + imagen +
                ", tipoEstado=" + tipoEstado +
                '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setTipoEstado(TipoEstado tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }
}

