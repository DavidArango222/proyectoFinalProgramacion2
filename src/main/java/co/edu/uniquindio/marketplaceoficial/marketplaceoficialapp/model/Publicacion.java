package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private int like;
    private List<Comentario> comentarios = new ArrayList<>();

    public Publicacion(int like) {
        this.like = like;
    }

    public int getLike() {
        return like;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }
}
