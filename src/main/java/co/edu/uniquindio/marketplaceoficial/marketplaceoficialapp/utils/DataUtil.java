package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.utils;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Administrador;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Marketplace;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;

public class DataUtil{
    public static Marketplace inicializarDatos() {
        Marketplace marketplace = Marketplace.builder()
                .nombre("Trade Hub")
                .build();
        Administrador administrador = Administrador.builder()
                .nombre("Britney")
                .apellido("Spears")
                .cedula("123456789")
                .direccion("New York")
                .usuario("powerrangerrojo")
                .contrasena("sheknows")
                .build();
        Vendedor vendedor1 = Vendedor.builder()
                .nombre("David")
                .apellido("Arango")
                .cedula("1124312515")
                .direccion("Armenia")
                .build();
        Vendedor vendedor2 = Vendedor.builder()
                .nombre("Valery")
                .apellido("Ortiz")
                .cedula("1044213851")
                .direccion("Caicedonia")
                .build();
        marketplace.getAdministrador().add(administrador);
        marketplace.getVendedores().add(vendedor1);
        marketplace.getVendedores().add(vendedor2);
        Producto producto1 = Producto.builder()
                .nombre("Vaca")
                .categoria("animal")
                .idProducto("20A")
                .precio(1500000)
                .imagen("vaca.png")
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
        vendedor1.getProductos().add(producto2);
        vendedor2.getProductos().add(producto1);
        return marketplace;
    }
}