package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.mapper;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;
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
}
