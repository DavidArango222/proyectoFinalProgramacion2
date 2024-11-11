package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services;

import javafx.scene.image.Image;

public interface IProductoCrud {
    boolean crearProducto(String nombre,
                          double precio,
                          String categoria,
                          Image imagen,
                          TipoEstado tipoEstado, String idProducto);
    boolean eliminarProducto(String idProducto);
    boolean actualizarProducto(String nombre,
                               double precio,
                               String categoria,
                               Image imagen,
                               TipoEstado tipoEstado,
                               String idProducto,
                               String idProductoNuevo);
    String obtenerProducto(String idProducto);
}
