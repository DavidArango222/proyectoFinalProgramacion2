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
        Usuario usuario4 = Usuario.builder()
                .nombreUsuario("andrea")
                .contrasena("andrea123")
                .build();
        Usuario usuario5 = Usuario.builder()
                .nombreUsuario("lucas")
                .contrasena("lucas123")
                .build();
        Usuario usuario6 = Usuario.builder()
                .nombreUsuario("sofia")
                .contrasena("sofia123")
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
        Vendedor vendedor4 = Vendedor.builder()
                .nombre("Andrea")
                .apellido("Martinez")
                .cedula("1023456789")
                .direccion("Medellín")
                .usuarioAsociado(usuario4)
                .build();
        Vendedor vendedor5 = Vendedor.builder()
                .nombre("Lucas")
                .apellido("Fernandez")
                .cedula("123987654")
                .direccion("Cali")
                .usuarioAsociado(usuario5)
                .build();
        Vendedor vendedor6 = Vendedor.builder()
                .nombre("Sofía")
                .apellido("Lopez")
                .cedula("1122446688")
                .direccion("Pereira")
                .usuarioAsociado(usuario6)
                .build();
        vendedor1.getContactos().add(vendedor2);
        vendedor2.getContactos().add(vendedor3);
        vendedor3.getContactos().add(vendedor4);
        vendedor4.getContactos().add(vendedor5);
        vendedor5.getContactos().add(vendedor6);
        vendedor6.getContactos().add(vendedor1);
        marketplace.getAdministrador().add(administrador);
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
        Producto producto4 = Producto.builder()
                .nombre("Cámara")
                .categoria("tecnología")
                .idProducto("40A")
                .precio(1200000)
                .imagen("camara.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .build();
        Producto producto5 = Producto.builder()
                .nombre("Libro")
                .categoria("educación")
                .idProducto("50A")
                .precio(30000)
                .imagen("libro.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .build();
        Producto producto6 = Producto.builder()
                .nombre("Celular")
                .categoria("tecnología")
                .idProducto("60A")
                .precio(900000)
                .imagen("celular.jpg")
                .tipoEstado(TipoEstado.PUBLICADO).build();
        Producto producto7 = Producto.builder()
                .nombre("Bicicleta")
                .categoria("deportes")
                .idProducto("70A")
                .precio(800000)
                .imagen("bicicleta.jpg")
                .tipoEstado(TipoEstado.PUBLICADO).build();
        Producto producto8 = Producto.builder()
                .nombre("Guitarra")
                .categoria("música")
                .idProducto("80A")
                .precio(700000)
                .imagen("guitarra.jpg")
                .tipoEstado(TipoEstado.PUBLICADO).build();
        Producto producto9 = Producto.builder()
                .nombre("Reloj")
                .categoria("accesorios")
                .idProducto("90A")
                .precio(150000)
                .imagen("reloj.jpg")
                .tipoEstado(TipoEstado.PUBLICADO).build();
        Producto producto10 = Producto.builder()
                .nombre("Zapatos")
                .categoria("ropa")
                .idProducto("100A")
                .precio(200000)
                .imagen("zapatos.jpg")
                .tipoEstado(TipoEstado.PUBLICADO).build();
        Producto producto11 = Producto.builder()
                .nombre("Mochila")
                .categoria("accesorios")
                .idProducto("110A")
                .precio(120000)
                .imagen("mochila.jpg")
                .tipoEstado(TipoEstado.PUBLICADO).build();
        Publicacion publicacion1 = new Publicacion(15, producto1);
        Publicacion publicacion2 = new Publicacion(20, producto2);
        Publicacion publicacion3 = new Publicacion(25, producto3);
        Publicacion publicacion4 = new Publicacion(30, producto4);
        Publicacion publicacion5 = new Publicacion(12, producto5);
        Publicacion publicacion6 = new Publicacion(10, producto6);
        Publicacion publicacion7 = new Publicacion(18, producto7);
        Publicacion publicacion8 = new Publicacion(22, producto8);
        Publicacion publicacion9 = new Publicacion(16, producto9);
        Publicacion publicacion10 = new Publicacion(14, producto10);
        Publicacion publicacion11 = new Publicacion(13, producto11);
        producto1.setPublicacion(publicacion1);
        producto2.setPublicacion(publicacion2);
        producto3.setPublicacion(publicacion3);
        producto4.setPublicacion(publicacion4);
        producto5.setPublicacion(publicacion5);
        producto6.setPublicacion(publicacion6);
        producto7.setPublicacion(publicacion7);
        producto8.setPublicacion(publicacion8);
        producto9.setPublicacion(publicacion9);
        producto10.setPublicacion(publicacion10);
        producto11.setPublicacion(publicacion11);

        vendedor1.getProductos().add(producto2);
        vendedor2.getProductos().add(producto1);
        vendedor3.getProductos().add(producto3);
        vendedor4.getProductos().add(producto4);
        vendedor5.getProductos().add(producto5);
        vendedor6.getProductos().add(producto6);
        vendedor1.getProductos().add(producto7);
        vendedor2.getProductos().add(producto8);
        vendedor3.getProductos().add(producto9);
        vendedor4.getProductos().add(producto10);
        vendedor5.getProductos().add(producto11);
        Mensaje mensaje1 = new Mensaje("Hola, ¿cómo estás?", vendedor1, vendedor2);
        Mensaje mensaje2 = new Mensaje("¿Tienes disponibles más productos?", vendedor2, vendedor1);
        Mensaje mensaje3 = new Mensaje("Me interesa tu oferta.", vendedor3, vendedor4);
        Comentario comentario1 = new Comentario(usuario2, "¡Qué buen producto!");
        Comentario comentario2 = new Comentario(usuario3, "Me interesa, ¿cómo puedo comprar?");

        vendedor1.getMuro().getPublicaciones().add(publicacion1);

        publicacion1.getComentarios().add(comentario1);
        publicacion1.getComentarios().add(comentario2);
        marketplace.getVendedores().add(vendedor1);
        marketplace.getVendedores().add(vendedor2);
        marketplace.getVendedores().add(vendedor3);
        marketplace.getVendedores().add(vendedor4);
        marketplace.getVendedores().add(vendedor5);
        marketplace.getVendedores().add(vendedor6);

        marketplace.getUsuarios().add(usuario);
        marketplace.getUsuarios().add(usuario2);
        marketplace.getUsuarios().add(usuario3);
        marketplace.getUsuarios().add(usuario4);
        marketplace.getUsuarios().add(usuario5);
        marketplace.getUsuarios().add(usuario6);

        marketplace.getMensajes().add(mensaje1);
        marketplace.getMensajes().add(mensaje2);
        marketplace.getMensajes().add(mensaje3);

        marketplace.getProductos().add(producto1);
        marketplace.getProductos().add(producto2);
        marketplace.getProductos().add(producto3);
        marketplace.getProductos().add(producto4);
        marketplace.getProductos().add(producto5);
        marketplace.getProductos().add(producto6);
        marketplace.getProductos().add(producto7);
        marketplace.getProductos().add(producto8);
        marketplace.getProductos().add(producto9);
        marketplace.getProductos().add(producto10);
        marketplace.getProductos().add(producto11);

        vendedor1.getMuro().getMensajes().add(mensaje1);
        vendedor2.getMuro().getMensajes().add(mensaje2);
        vendedor3.getMuro().getMensajes().add(mensaje3);
        return marketplace;
    }
}