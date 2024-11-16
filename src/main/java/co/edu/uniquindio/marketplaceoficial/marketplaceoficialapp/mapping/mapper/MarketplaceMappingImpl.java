package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.mapper;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.UsuarioDto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorUsuarioDto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Usuario;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.builder.UsuarioBuilder;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services.IMarketplaceMapping;

import java.util.ArrayList;
import java.util.List;

public class MarketplaceMappingImpl implements IMarketplaceMapping {

    @Override
    public List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores) {
        if(listaVendedores== null){
            return null;
        }
        List<VendedorDto> listaVendedoresDto = new ArrayList<VendedorDto>(listaVendedores.size());
        for(Vendedor vendedor: listaVendedores){
            listaVendedoresDto.add(vendedorToVendedorDto(vendedor));
        }
        return listaVendedoresDto;
    }

    @Override
    public VendedorDto vendedorToVendedorDto(Vendedor vendedor) {
        return new VendedorDto(
                vendedor.getNombre(),
                vendedor.getApellido(),
                vendedor.getCedula(),
                vendedor.getDireccion());
    }

    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto) {
        return Vendedor.builder()
                .nombre(vendedorDto.nombre())
                .apellido(vendedorDto.apellido())
                .cedula(vendedorDto.cedula())
                .direccion(vendedorDto.direccion())
                .build();
    }

    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        return new UsuarioDto(usuario.getNombreUsuario(), usuario.getContrasena());
    }

    public List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios) {
        if (listaUsuarios == null) {
            return null;
        }
        List<UsuarioDto> usuariosDto = new ArrayList<UsuarioDto>(listaUsuarios.size());
        for (Usuario usuario : listaUsuarios) {
            usuariosDto.add(usuarioToUsuarioDto(usuario));
        }

        return usuariosDto;
    }

    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        return new UsuarioBuilder()
                .nombreUsuario(usuarioDto.nombreUsuario())
                .contrasena(usuarioDto.contrasena())
                .build();
    }

    public List<VendedorUsuarioDto> getUsuariosVendedoresDto(List<Vendedor> listaVendedores
            , List<Usuario> listaUsuarios) {
        if (listaUsuarios == null || listaVendedores == null) {
            return null;
        }

        int tamanoLista = listaUsuarios.size() + listaVendedores.size();
        List<VendedorUsuarioDto> vendedoresUsuarioDto = new ArrayList<VendedorUsuarioDto>(tamanoLista);
        verificarUsuarioExiste(listaVendedores, listaUsuarios);
        for (Vendedor vendedor : listaVendedores) {
            String nombreVendedor = vendedor.getNombre();
            String apellidoVendedor = vendedor.getApellido();
            String cedulaVendedor = vendedor.getCedula();
            String direccionVendedor = vendedor.getDireccion();
            Usuario usuario = vendedor.getUsuarioAsociado();
            String nombreUsuario = (usuario != null) ? usuario.getNombreUsuario() : "Vendedor sin usuario";
            String contrasena = (usuario != null) ? usuario.getContrasena() : "Vendedor sin usuario";
            VendedorUsuarioDto vendedorUsuario = new VendedorUsuarioDto(
                    nombreVendedor,
                    apellidoVendedor,
                    cedulaVendedor,
                    direccionVendedor,
                    nombreUsuario,
                    contrasena
            );
            vendedoresUsuarioDto.add(vendedorUsuario);
        }
        for (Usuario usuario : listaUsuarios) {
            String username = (usuario != null) ? usuario.getNombreUsuario() : "Vendedor sin usuario";
            String password = (usuario != null) ? usuario.getContrasena() : "Vendedor sin usuario";
            VendedorUsuarioDto vendedorUsuarioDto = new VendedorUsuarioDto(
                    username, password,
                    "", "", "", ""
            );
        }

        return vendedoresUsuarioDto;
    }

    public Vendedor vendedorUsuarioDtoToVendedor(VendedorUsuarioDto vendedorUsuarioDto) {
        if (!vendedorUsuarioDto.nombreUsuario().isEmpty() && !vendedorUsuarioDto.contrasena().isEmpty()) {
            Usuario usuario = Usuario.builder()
                    .nombreUsuario(vendedorUsuarioDto.nombreUsuario())
                    .contrasena(vendedorUsuarioDto.contrasena())
                    .build();
            return Vendedor.builder()
                    .nombre(vendedorUsuarioDto.nombre())
                    .apellido(vendedorUsuarioDto.apellido())
                    .direccion(vendedorUsuarioDto.direccion())
                    .cedula(vendedorUsuarioDto.cedula())
                    .usuarioAsociado(usuario)
                    .build();
        } else {
            return Vendedor.builder()
                    .nombre(vendedorUsuarioDto.nombre())
                    .apellido(vendedorUsuarioDto.apellido())
                    .direccion(vendedorUsuarioDto.direccion())
                    .cedula(vendedorUsuarioDto.cedula())
                    .build();
        }
    }

    public Usuario vendedorUsuarioDtoToUsuario(VendedorUsuarioDto vendedorUsuarioDto) {
        return new UsuarioBuilder()
                .nombreUsuario(vendedorUsuarioDto.nombreUsuario())
                .contrasena(vendedorUsuarioDto.contrasena())
                .build();
    }

    public List<Vendedor> vendedoresUsuarioDtoToVendedores(List<VendedorUsuarioDto> listaVendedoresUsuarioDto) {
        if (listaVendedoresUsuarioDto == null) throw new IllegalArgumentException("DTOUSUARIOVENDEDORE NULL LIST");
        List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
        for (VendedorUsuarioDto vendedorUsuarioDto : listaVendedoresUsuarioDto) {
            Vendedor vendedor = vendedorUsuarioDtoToVendedor(vendedorUsuarioDto);
            Usuario usuario = vendedorUsuarioDtoToUsuario(vendedorUsuarioDto);
            if (verificarUsuarioDatosCompletos(usuario)) vendedor.setUsuarioAsociado(usuario);
            if (verificarVendedorDatosCompletos(vendedor)) listaVendedores.add(vendedor);
        }

        return listaVendedores;
    }

    public List<Usuario> vendedoresUsuarioDtoToUsuario(List<VendedorUsuarioDto> listavendedoresUsuarioDto) {
        if (listavendedoresUsuarioDto == null) throw new IllegalArgumentException("DTOUSUARIOVENDEDORE NULL LIST");
        verificarUsuarioExisteDto(listavendedoresUsuarioDto);
        List<Usuario> listaUsuarios = new ArrayList<>();
        for (VendedorUsuarioDto vendedorUsuarioDto : listavendedoresUsuarioDto) {
            Usuario usuario = vendedorUsuarioDtoToUsuario(vendedorUsuarioDto);
            if (verificarUsuarioDatosCompletos(usuario)) listaUsuarios.add(usuario);
        }

        return listaUsuarios;
    }

    public void verificarUsuarioExiste(List<Vendedor> listaVendedores, List<Usuario> listaUsuarios) {
        for (Vendedor vendedor : listaVendedores) {
            listaUsuarios.remove(vendedor.getUsuarioAsociado());
        }
    }

    public boolean verificarVendedorDatosCompletos(Vendedor vendedor) {
        return !vendedor.getNombre().isEmpty() && !vendedor.getNombre().isBlank() &&
                !vendedor.getApellido().isEmpty() && !vendedor.getApellido().isBlank() &&
                !vendedor.getDireccion().isEmpty() && !vendedor.getDireccion().isBlank() &&
                !vendedor.getCedula().isEmpty() && !vendedor.getCedula().isBlank();
    }

    public boolean verificarUsuarioDatosCompletos(Usuario usuario) {
        return !usuario.getNombreUsuario().isEmpty() && !usuario.getNombreUsuario().isBlank() &&
                !usuario.getContrasena().isEmpty() && !usuario.getContrasena().isBlank();
    }

    public void verificarUsuarioExisteDto(List<VendedorUsuarioDto> listaVendedoresUsuarioDto) {
        for (VendedorUsuarioDto usuarioVendedorDto : listaVendedoresUsuarioDto) {
            Vendedor vendedor = vendedorUsuarioDtoToVendedor(usuarioVendedorDto);
            Usuario usuario = vendedorUsuarioDtoToUsuario(usuarioVendedorDto);
            if (verificarUsuarioDatosCompletos(usuario) && verificarVendedorDatosCompletos(vendedor)) {
                listaVendedoresUsuarioDto.remove(usuarioVendedorDto);
            }
        }
    }
}

