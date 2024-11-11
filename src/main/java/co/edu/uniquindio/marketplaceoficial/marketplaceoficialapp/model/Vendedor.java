package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;


import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder.VendedorBuilder;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IProductoCrud;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona implements IProductoCrud {
    private List<Producto> productos =new ArrayList<>();
    private Muro muro;

    public Vendedor() {
    }

    public Vendedor(String nombre,
                    String apellido,
                    String cedula,
                    String direccion) {
        super(nombre,apellido,cedula,direccion);
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
                                 Image imagen,
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
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean actualizarProducto(String nombre,
                                      double precio,
                                      String categoria,
                                      Image imagen,
                                      TipoEstado tipoEstado,
                                      String idProducto,
                                      String idProductoNuevo) {
        Producto productoExistente = buscarProducto(idProducto);
        if (productoExistente != null) {
            productoExistente = Producto.builder()
                    .nombre(nombre)
                    .precio(precio)
                    .categoria(categoria)
                    .imagen(imagen)
                    .tipoEstado(tipoEstado)
                    .idProducto(idProductoNuevo)
                    .build();
            getProductos().add(productoExistente);
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
}
