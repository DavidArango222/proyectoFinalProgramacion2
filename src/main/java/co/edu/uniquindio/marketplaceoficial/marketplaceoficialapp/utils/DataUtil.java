package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.utils;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.*;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;

public class DataUtil{
    public static Marketplace inicializarDatos() {
        Marketplace marketplace = Marketplace.builder()
                .nombre("Trade Hub")
                .build();
        Usuario usuario = Usuario.builder()
                .nombreUsuario("david")
                .contrasena("david123")
                .build();
        Usuario usuario2 = Usuario.builder()
                .nombreUsuario("valery")
                .contrasena("valery123")
                .build();
        Usuario usuario3 = Usuario.builder()
                .nombreUsuario("carlos")
                .contrasena("carlos123")
                .build();
        Usuario usuarioadmin = Usuario.builder()
                .nombreUsuario("admin")
                .contrasena("admin123")
                .build();
        Administrador administrador = Administrador.builder()
                .nombre("Britney")
                .apellido("Spears")
                .cedula("123456789")
                .direccion("New York")
                .usuario(usuarioadmin)
                .build();
        Vendedor vendedor1 = Vendedor.builder()
                .nombre("David")
                .apellido("Arango")
                .cedula("1124312515")
                .direccion("Armenia")
                .usuarioAsociado(usuario)
                .build();
        Vendedor vendedor2 = Vendedor.builder()
                .nombre("Valery")
                .apellido("Ortiz")
                .cedula("1044213851")
                .direccion("Caicedonia")
                .usuarioAsociado(usuario2)
                .build();
        Vendedor vendedor3 = Vendedor.builder()
                .nombre("Carlos")
                .apellido("Garcia")
                .cedula("987654321")
                .direccion("Bogotá")
                .usuarioAsociado(usuario3)
                .build();
        vendedor1.getContactos().add(vendedor2);
        vendedor2.getContactos().add(vendedor1);
        vendedor3.getContactos().add(vendedor1);
        marketplace.getAdministrador().add(administrador);
        marketplace.getVendedores().add(vendedor1);
        marketplace.getVendedores().add(vendedor2);
        marketplace.getVendedores().add(vendedor3);
        marketplace.getUsuarios().add(usuario);
        marketplace.getUsuarios().add(usuario2);
        marketplace.getUsuarios().add(usuario3);
        Producto producto1 = Producto.builder()
                .nombre("Vaca")
                .categoria("animal")
                .idProducto("20A")
                .precio(1500000)
                .imagen("vaca.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .build();
        Producto producto2 = Producto.builder()
                .nombre("Smoking")
                .categoria("ropa")
                .idProducto("10A")
                .precio(500000)
                .imagen("smoking.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .build();
        Producto producto3 = Producto.builder()
                .nombre("Netflix")
                .categoria("entretenimiento")
                .idProducto("30A")
                .precio(17000)
                .imagen("netflix.png")
                .tipoEstado(TipoEstado.PUBLICADO)
                .build();
        vendedor3.getProductos().add(producto3);
        vendedor1.getProductos().add(producto2);
        vendedor2.getProductos().add(producto1);
        return marketplace;
    }
}