package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private int like;
    private List<Comentario> comentarios = new ArrayList<>();
    private Producto producto;

    public Publicacion(int like, Producto producto) {
        this.like = like;
        this.producto=producto;
    }

    public int getLike() {
        return like;
    }

    public Producto getProducto() {
        return producto;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
