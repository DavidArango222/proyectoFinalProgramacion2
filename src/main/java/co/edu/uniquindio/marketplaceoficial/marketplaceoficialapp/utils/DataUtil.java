package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.utils;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.*;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;

import java.time.LocalDateTime;

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
                .fecha(LocalDateTime.of(2024, 1, 15, 10, 30))
                .build();
        Producto producto2 = Producto.builder()
                .nombre("Smoking")
                .categoria("ropa")
                .idProducto("10A")
                .precio(500000)
                .imagen("smoking.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .fecha(LocalDateTime.of(2024, 2, 5, 14, 0))
                .build();
        Producto producto3 = Producto.builder()
                .nombre("Netflix")
                .categoria("entretenimiento")
                .idProducto("30A")
                .precio(17000)
                .imagen("netflix.png")
                .tipoEstado(TipoEstado.PUBLICADO)
                .fecha(LocalDateTime.of(2024, 3, 10, 9, 15))
                .build();
        Producto producto4 = Producto.builder()
                .nombre("Cámara")
                .categoria("tecnología")
                .idProducto("40A")
                .precio(1200000)
                .imagen("camara.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .fecha(LocalDateTime.of(2024, 4, 25, 16, 45))
                .build();
        Producto producto5 = Producto.builder()
                .nombre("Libro")
                .categoria("educación")
                .idProducto("50A")
                .precio(30000)
                .imagen("libro.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .fecha(LocalDateTime.of(2024, 5, 20, 8, 0))
                .build();
        Producto producto6 = Producto.builder()
                .nombre("Celular")
                .categoria("tecnología")
                .idProducto("60A")
                .precio(900000)
                .imagen("celular.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .fecha(LocalDateTime.of(2024, 6, 15, 11, 30))
                .build();
        Producto producto7 = Producto.builder()
                .nombre("Bicicleta")
                .categoria("deportes")
                .idProducto("70A")
                .precio(800000)
                .imagen("bicicleta.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .fecha(LocalDateTime.of(2024, 7, 10, 13, 15))
                .build();
        Producto producto8 = Producto.builder()
                .nombre("Guitarra")
                .categoria("música")
                .idProducto("80A")
                .precio(700000)
                .imagen("guitarra.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .fecha(LocalDateTime.of(2024, 8, 5, 17, 0))
                .build();
        Producto producto9 = Producto.builder()
                .nombre("Reloj")
                .categoria("accesorios")
                .idProducto("90A")
                .precio(150000)
                .imagen("reloj.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .fecha(LocalDateTime.of(2024, 9, 30, 10, 0))
                .build();
        Producto producto10 = Producto.builder()
                .nombre("Zapatos")
                .categoria("ropa")
                .idProducto("100A")
                .precio(200000)
                .imagen("zapatos.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .fecha(LocalDateTime.of(2024, 10, 20, 15, 45))
                .build();
        Producto producto11 = Producto.builder()
                .nombre("Mochila")
                .categoria("accesorios")
                .idProducto("110A")
                .precio(120000)
                .imagen("mochila.jpg")
                .tipoEstado(TipoEstado.PUBLICADO)
                .fecha(LocalDateTime.of(2024, 11, 5, 12, 30))
                .build();
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
        Comentario comentario3 = new Comentario(usuario4, "¿A qué hora se puede ver?");
        Comentario comentario4 = new Comentario(usuario5, "¿Cuántos colores tiene?");
        Comentario comentario5 = new Comentario(usuario6, "¡Lo quiero!");
        Comentario comentario6 = new Comentario(usuario, "¿Todavía está disponible?");
        Comentario comentario7 = new Comentario(usuario2, "¿Hay más stock?");
        Comentario comentario8 = new Comentario(usuario3, "Buen precio");
        Comentario comentario9 = new Comentario(usuario4, "Lo recomiendo");
        Comentario comentario10 = new Comentario(usuario5, "Perfecto para mi trabajo");
        Comentario comentario11 = new Comentario(usuario6, "¿El precio es negociable?");
        Comentario comentario12 = new Comentario(usuario, "¡Excelente calidad!");
        Comentario comentario13 = new Comentario(usuario2, "¿Este producto es nuevo?");
        Comentario comentario14 = new Comentario(usuario3, "Interesado en otro tamaño");
        Comentario comentario15 = new Comentario(usuario4, "¡Muy bonito!");

        vendedor1.getMuro().getPublicaciones().add(publicacion1);
        vendedor2.getMuro().getPublicaciones().add(publicacion2);
        vendedor3.getMuro().getPublicaciones().add(publicacion3);
        vendedor4.getMuro().getPublicaciones().add(publicacion4);
        vendedor5.getMuro().getPublicaciones().add(publicacion5);
        vendedor6.getMuro().getPublicaciones().add(publicacion6);

        publicacion1.getComentarios().add(comentario1);
        publicacion1.getComentarios().add(comentario2);
        publicacion2.getComentarios().add(comentario3);
        publicacion2.getComentarios().add(comentario4);
        publicacion3.getComentarios().add(comentario5);
        publicacion3.getComentarios().add(comentario6);
        publicacion4.getComentarios().add(comentario7);
        publicacion4.getComentarios().add(comentario8);
        publicacion5.getComentarios().add(comentario9);
        publicacion5.getComentarios().add(comentario10);
        publicacion6.getComentarios().add(comentario11);
        publicacion6.getComentarios().add(comentario12);
        publicacion7.getComentarios().add(comentario13);
        publicacion7.getComentarios().add(comentario14);
        publicacion8.getComentarios().add(comentario15);

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

        marketplace.obtenerProductos().add(producto1);
        marketplace.obtenerProductos().add(producto2);
        marketplace.obtenerProductos().add(producto3);
        marketplace.obtenerProductos().add(producto4);
        marketplace.obtenerProductos().add(producto5);
        marketplace.obtenerProductos().add(producto6);
        marketplace.obtenerProductos().add(producto7);
        marketplace.obtenerProductos().add(producto8);
        marketplace.obtenerProductos().add(producto9);
        marketplace.obtenerProductos().add(producto10);
        marketplace.obtenerProductos().add(producto11);

        vendedor1.getMuro().getMensajes().add(mensaje1);
        vendedor2.getMuro().getMensajes().add(mensaje2);
        vendedor3.getMuro().getMensajes().add(mensaje3);
        return marketplace;
    }
}