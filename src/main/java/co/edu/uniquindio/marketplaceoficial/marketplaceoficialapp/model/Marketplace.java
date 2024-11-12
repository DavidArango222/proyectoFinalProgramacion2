package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder.MarketplaceBuilder;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IObservable;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IObservador;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IVendedorCrud;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;

import java.util.ArrayList;
import java.util.List;

public class Marketplace implements IVendedorCrud, IObservable {
    private String nombre;
    private List<Vendedor> vendedores = new ArrayList<>();
    private List<Administrador> administrador = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<IObservador> observadorList = new ArrayList<>();

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public List<Administrador> getAdministrador() {
        return administrador;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Marketplace(){}

    public Marketplace(String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static MarketplaceBuilder builder(){
        return new MarketplaceBuilder();
    }

    @Override
    public boolean crearVendedor(String nombre,
                                 String apellido,
                                 String cedula,
                                 String direccion,
                                 String usuario,
                                 String contrasena) {
        Vendedor vendedorExistente = obtenerVendedor(cedula);
        if(vendedorExistente == null){
            Vendedor vendedor = Vendedor.builder()
                    .nombre(nombre)
                    .apellido(apellido)
                    .cedula(cedula)
                    .direccion(direccion)
                    .build();
            getVendedores().add(vendedor);
            return true;
        }else{
            return false;
        }
    }

    public boolean crearVendedor(Vendedor vendedor){
        Vendedor vendedorEncontrado = obtenerVendedor(vendedor.getCedula());
        if(vendedorEncontrado == null){
            getVendedores().add(vendedor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean eliminarVendedor(String cedula) {
        Vendedor vendedorExistente = buscarVendedor(cedula);
        if(vendedorExistente != null){
            getVendedores().remove(vendedorExistente);
            return true;
        }else{
            return false;
        }
    }

    public boolean actualizarVendedor(String cedula, Vendedor vendedor) {
        Vendedor vendedorEncontrado = obtenerVendedor(cedula);
        if (vendedorEncontrado!=null){
            for (Vendedor vendedor1 : vendedores) {
                if (vendedor1.getCedula().equals(cedula)) {
                    vendedor1.setNombre(vendedor.getNombre());
                    vendedor1.setApellido(vendedor.getApellido());
                    vendedor1.setDireccion(vendedor.getDireccion());
                    vendedor1.setCedula(vendedor.getCedula());
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Vendedor obtenerVendedor(String cedula) {
        for (Vendedor vendedor : getVendedores()) {
            if (vendedor.getCedula().equals(cedula)) {
                return vendedor;
            }
        }
        return null;
    }

    private Vendedor buscarVendedor(String cedula) {
        Vendedor vendedorExistente = null;
        for (Vendedor vendedor: getVendedores()) {
            if(vendedor.getCedula().equals(cedula)){
                vendedorExistente = vendedor;
                break;
            }
        }

        return  vendedorExistente;
    }

    @Override
    public String toString() {
        return "Marketplace {" +
                "nombre='" + nombre + '\'' +
                '}';
    }


    @Override
    public void agregarObservador(IObservador observador) {
        observadorList.add(observador);
    }

    @Override
    public void eliminarObservador(IObservador observador) {
        observadorList.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        observadorList.forEach(IObservador::actualizar);
    }

}