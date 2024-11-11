package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;
    private Persona personaAsociada;

    public Usuario(String nombreUsuario,
                   String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Persona getPersonaAsociada() {
        return personaAsociada;
    }
}
