package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

public class Mensaje {
    private String mensaje;
    private Vendedor remitente;
    private Vendedor destinatario;

    public Mensaje(String mensaje, Vendedor remitente, Vendedor destinatario) {
        this.mensaje = mensaje;
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public Mensaje() {}

    public String getMensaje() {
        return mensaje;
    }

    public Vendedor getRemitente() {
        return remitente;
    }

    public Vendedor getDestinatario() {
        return destinatario;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "mensaje='" + mensaje + '\'' +
                ", remitente=" + remitente.getNombre() +
                ", destinatario=" + destinatario.getNombre() +
                '}';
    }
}

