package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder.ProductoBuilder;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;
import javafx.scene.image.Image;

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    private Image imagen;
    private TipoEstado tipoEstado;
    private String idProducto;

    public Producto() {
    }

    public Producto(String nombre,
                    double precio,
                    String categoria,
                    Image imagen,
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

    public Image getImagen() {
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
}

