package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

public class Comentario {
    private Usuario autor;
    private String contenido;

    public Comentario(Usuario autor, String contenido) {
        this.autor = autor;
        this.contenido = contenido;
    }

    public Usuario getAutor() {
        return autor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}

