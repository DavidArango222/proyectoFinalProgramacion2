package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder.MarketplaceBuilder;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IObservable;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IObservador;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IVendedorCrud;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Marketplace implements IVendedorCrud, IObservable {
    private String nombre;
    private List<Vendedor> vendedores = new ArrayList<>();
    private List<Administrador> administrador = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<IObservador> observadorList = new ArrayList<>();
    private List<Producto> productos = new ArrayList<>();

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public List<Administrador> getAdministrador() {
        return administrador;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Producto> getProductos() {
        List<Producto> productosActualizados = new ArrayList<>();
        agregarProductosVendedores(productosActualizados);
        return productosActualizados;
    }

    private void agregarProductosVendedores(List<Producto> listaProductos) {
        for (Vendedor vendedor : vendedores) {
            List<Producto> productosVendedor = vendedor.getProductos();
            listaProductos.addAll(productosVendedor);
        }
    }

    public Marketplace(){}

    public Marketplace(String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void agregarVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
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
            notificarObservadores();
            return true;
        }else{
            return false;
        }
    }

    public boolean crearVendedor(Vendedor vendedor){
        Vendedor vendedorEncontrado = obtenerVendedor(vendedor.getCedula());
        if(vendedorEncontrado == null){
            getVendedores().add(vendedor);
            notificarObservadores();
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
            notificarObservadores();
            return true;
        }else{
            return false;
        }
    }

    public boolean actualizarVendedor(String cedula, Vendedor vendedor) {
        Vendedor vendedorEncontrado = obtenerVendedor(cedula);
        if (vendedorEncontrado!=null){
            for (Vendedor vendedor1 : getVendedores()) {
                if (vendedor1.getCedula().equals(cedula)) {
                    vendedor1.setNombre(vendedor.getNombre());
                    vendedor1.setApellido(vendedor.getApellido());
                    vendedor1.setDireccion(vendedor.getDireccion());
                    vendedor1.setCedula(vendedor.getCedula());
                    notificarObservadores();
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Vendedor obtenerVendedor(String cedula) {
        System.out.println("Buscando vendedor con cédula: " + cedula);
        for (Vendedor vendedor : getVendedores()) {
            System.out.println("Comparando con vendedor: " + vendedor.getCedula());
            if (vendedor.getCedula().equals(cedula)) {
                System.out.println("Vendedor encontrado: " + vendedor.getNombre());
                return vendedor;
            }
        }
        System.out.println("No se encontró ningún vendedor con la cédula: " + cedula);
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

    public boolean crearUsuario(String nombreUsuario,
                                String contrasena,
                                Vendedor vendedorAsociado,
                                Administrador administradorAsociado){
        Usuario usuarioEncontrado = obtenerUsuario(nombreUsuario);
        if(verificarUsuarioExiste(nombreUsuario)){
            if (usuarioEncontrado == null) {
                Usuario usuario = Usuario.builder()
                        .nombreUsuario(nombreUsuario)
                        .contrasena(contrasena)
                        .vendedorAsociado(vendedorAsociado)
                        .administradorAsociado(administradorAsociado)
                        .build();
                agregarUsuario(usuario);
                notificarObservadores();
                return true;
            }
        }
        return  false;
    }

    public boolean crearUsuario(Usuario nuevoUsuario){
        Usuario usuarioEncontrado = obtenerUsuario(nuevoUsuario.getNombreUsuario());
        if (verificarUsuarioExiste(nuevoUsuario.getNombreUsuario())){
            if (usuarioEncontrado == null) {
                agregarUsuario(nuevoUsuario);
                notificarObservadores();
                return true;
            }
        }
        return false;
    }

    public boolean eliminarUsuario(String nombreUsuario) {
        Usuario usuarioEncontrado = obtenerUsuario(nombreUsuario);
        if (usuarioEncontrado!=null) {
            usuarios.remove(usuarioEncontrado);
            notificarObservadores();
            return true;
        }
        return false;
    }

    public boolean actualizarUsuario(String nombreUsuario, Usuario usuario) {
        Usuario usarioEncontrado = obtenerUsuario(nombreUsuario);
        if (usarioEncontrado!=null){
            for (Usuario usuario1 : usuarios) {
                if (usuario1.getNombreUsuario().equals(nombreUsuario)) {
                    usuario1.setNombreUsuario(usuario.getNombreUsuario());
                    usuario1.setContrasena(usuario.getContrasena());
                    notificarObservadores();
                    return true;
                }
            }
        }

        return false;
    }

    private Usuario obtenerUsuario(String nombreUsuario) {
        Usuario usuario = null;
        for (Usuario usuario1 : usuarios) {
            if (usuario1.getNombreUsuario().equals(nombreUsuario)
                    || !usuario1.getNombreUsuario().isBlank()) {
                usuario = usuario1;
                break;
            }
        }


        return usuario;
    }

    private boolean verificarUsuarioExiste(String nombreUsuario) {
        if (nombreUsuario==null || nombreUsuario.isBlank()){
            return false;
        }
        for(Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) || !usuario.getNombreUsuario().isEmpty()){
                return false;
            }
        }

        return true;
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

    public boolean agregarVendedor(String nombre, String cedula) {
        Vendedor vendedor = obtenerVendedor(cedula);
        if (vendedor == null) {
            vendedor = new Vendedor();
            vendedor.setNombre(nombre);
            vendedor.setCedula(cedula);
            getVendedores().add(vendedor);
            return true;
        }else{
            return false;
        }
    }

    public int contarMensajesVendedores(String cedula1, String cedula2) {
        Vendedor vendedor1 = obtenerVendedor(cedula1);
        Vendedor vendedor2 = obtenerVendedor(cedula2);
        if (vendedor1 == null || vendedor2 == null) return 0;
        return vendedor1.contarMensajes(vendedor2) + vendedor2.contarMensajes(vendedor1);
    }

    public int contarProductosFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        int contador = 0;
        for (Producto producto : productos) {
            if (producto.getFecha() != null &&
                    !producto.getFecha().isBefore(fechaInicio) &&
                    !producto.getFecha().isAfter(fechaFin)) {
                contador++;
            }
        }
        return contador;
    }

    public int contarProductosPorVendedor(String cedulaVendedor) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getCedula().equals(cedulaVendedor)) {
                return vendedor.getProductos().size();
            }
        }
        return 0;
    }

    public Map<String, Integer> contarContactosPorVendedor() {
        Map<String, Integer> contactosPorVendedor = new HashMap<>();

        for (Vendedor vendedor : vendedores) {
            contactosPorVendedor.put(
                    vendedor.getCedula(),
                    vendedor.getContactos().size()
            );
        }

        return contactosPorVendedor;
    }

    public List<Producto> obtenerTopProductosLikes() {
        Map<Producto, Integer> productoLikesMap = new HashMap<>();

        for (Producto producto : productos) {
            Vendedor vendedor = producto.getVendedor(); // Se asume que cada producto tiene un vendedor asociado
            if (vendedor != null && vendedor.getMuro() != null) {
                Muro muro = vendedor.getMuro();

                for (Publicacion publicacion : muro.getPublicaciones()) {
                    if (publicacion != null) {
                        productoLikesMap.put(
                                producto,
                                productoLikesMap.getOrDefault(producto, 0) + publicacion.getLike()
                        );
                    }
                }
            }
        }

        return productoLikesMap.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) // Ordenar por likes
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<Vendedor> getContactosMensajes(String cedulaContacto) {
        return obtenerVendedor(cedulaContacto).getContactos();
    }

}