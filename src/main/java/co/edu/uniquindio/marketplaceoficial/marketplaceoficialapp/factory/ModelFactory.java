package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.factory;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorUsuarioDto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.mapper.MarketplaceMappingImpl;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Marketplace;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Producto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.TipoEstado;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.utils.DataUtil;

import java.util.List;

public class ModelFactory {
    public static ModelFactory modelFactory;
    private Marketplace marketplace;
    private MarketplaceMappingImpl mapper;

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private ModelFactory() {
        marketplace = DataUtil.inicializarDatos();
        mapper = new MarketplaceMappingImpl();
    }

    public Marketplace getMarketplace() {
        return marketplace;
    }

    public boolean agregarVendedor(String nombre, String cedula) {
        return marketplace.agregarVendedor(nombre, cedula);
    }

    public Vendedor obtenerVendedor(String cedula) {
        return marketplace.obtenerVendedor(cedula);
    }

    public boolean eliminarVendedor(String cedula) {
        return marketplace.eliminarVendedor(cedula);
    }

    public List<VendedorUsuarioDto> getVendedoresUsuarioDto() {
        return mapper.getUsuariosVendedoresDto(marketplace.getVendedores(), marketplace.getUsuarios());
    }

    public boolean actualizarVendedorUsuario(String nombreUsuario, String cedula, VendedorUsuarioDto vendedorUsuarioDto) {
        return marketplace.actualizarUsuario( nombreUsuario,  mapper.vendedorUsuarioDtoToUsuario(vendedorUsuarioDto))
                | marketplace.actualizarVendedor(cedula,mapper.vendedorUsuarioDtoToVendedor(vendedorUsuarioDto));
    }

    public boolean eliminarVendedorUsuario(VendedorUsuarioDto vendedorUsuarioDto) {
        return marketplace.eliminarUsuario(vendedorUsuarioDto.nombreUsuario())
                | marketplace.eliminarVendedor(vendedorUsuarioDto.cedula());
    }

    public boolean agregarUsuarioDto(VendedorUsuarioDto vendedorUsuarioDto) {
        return marketplace.crearUsuario(mapper.vendedorUsuarioDtoToUsuario(vendedorUsuarioDto));
    }

    public boolean agregarVendedorDto(VendedorUsuarioDto vendedorUsuarioDto) {
        return marketplace.crearVendedor(mapper.vendedorUsuarioDtoToVendedor(vendedorUsuarioDto));
    }

    public List<Vendedor> obtenerContactos(String cedula) {
        return obtenerVendedor(cedula).getContactos();
    }

    public List<Vendedor> obtenerVendedores() {
        return marketplace.getVendedores();
    }

    public List<Vendedor> obtenerContactosMensajes(String cedulaContacto) {
        return marketplace.getContactosMensajes(cedulaContacto);
    }

    public List<Producto> obtenerProductosVendedor(String cedula) {
        return marketplace.obtenerVendedor(cedula).getProductos();
    }

    public List<Producto> getProductos() {
        return marketplace.getProductos();
    }
}
