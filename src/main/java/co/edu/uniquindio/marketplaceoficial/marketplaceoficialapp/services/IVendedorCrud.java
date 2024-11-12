package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;

public interface IVendedorCrud {
    boolean crearVendedor(String nombre, String apellido, String cedula,String direccion,
                          String usuario,
                          String contrasena);
    boolean eliminarVendedor(String cedula);
    boolean actualizarVendedor(String cedula, Vendedor vendedor);
    Vendedor obtenerVendedor(String cedula);
}