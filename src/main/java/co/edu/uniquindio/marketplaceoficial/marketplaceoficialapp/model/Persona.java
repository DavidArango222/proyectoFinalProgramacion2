package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private Usuario usuarioAsociado;

    public Persona() {
    }

    public Persona(String nombre,
                   String apellido,
                   String cedula,
                   String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", usuarioAsociado=" + usuarioAsociado +
                '}';
    }
}
