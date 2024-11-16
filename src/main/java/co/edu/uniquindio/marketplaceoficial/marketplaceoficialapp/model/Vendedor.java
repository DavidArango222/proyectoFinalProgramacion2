package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;


import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder.VendedorBuilder;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IObservable;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IObservador;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IProductoCrud;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona implements IProductoCrud, IObservable {
    private ObservableList<IObservador> observadorList = FXCollections.observableArrayList();
    private List<Producto> productos = new ArrayList<>();
    private Muro muro;
    private Usuario usuarioAsociado;

    public Vendedor() {
    }

    public Vendedor(String nombre,
                    String apellido,
                    String cedula,
                    String direccion, Usuario usuarioAsociado) {
        super(nombre,apellido,cedula,direccion);
        this.usuarioAsociado=usuarioAsociado;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }

    public Muro getMuro() {
        return muro;
    }

    public static VendedorBuilder builder(){
        return new VendedorBuilder();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @Override
    public boolean crearProducto(String nombre,
                                 double precio,
                                 String categoria,
                                 String imagen,
                                 TipoEstado tipoEstado,
                                 String idProducto) {
        Producto productoExistente = buscarProducto(idProducto);
        if(productoExistente == null){
            Producto producto = Producto.builder()
                    .nombre(nombre)
                    .precio(precio)
                    .categoria(categoria)
                    .imagen(imagen)
                    .tipoEstado(tipoEstado)
                    .idProducto(idProducto)
                    .build();
            getProductos().add(producto);
            notificarObservadores();
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean eliminarProducto(String idProducto) {
        Producto productoExistente = buscarProducto(idProducto);
        if(productoExistente != null){
            getProductos().remove(productoExistente);
            notificarObservadores();
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean actualizarProducto(String nombre,
                                      double precio,
                                      String categoria,
                                      String imagen,
                                      TipoEstado tipoEstado,
                                      String idProducto) {
        Producto productoExistente = buscarProducto(idProducto);
        if (productoExistente != null) {
            productoExistente = Producto.builder()
                    .nombre(nombre)
                    .precio(precio)
                    .categoria(categoria)
                    .imagen(imagen)
                    .tipoEstado(tipoEstado)
                    .build();
            getProductos().add(productoExistente);
            notificarObservadores();
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String obtenerProducto(String idProducto) {
        for (Producto producto : getProductos()) {
            if (producto.getIdProducto().equals(idProducto)) {
                return producto.toString();
            }
        }
        return null;
    }

    private Producto buscarProducto(String idProducto) {
        Producto productoExistente = null;
        for (Producto producto: getProductos()) {
            if(producto.getIdProducto().equals(idProducto)){
                productoExistente = producto;
                break;
            }
        }

        return  productoExistente;
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
