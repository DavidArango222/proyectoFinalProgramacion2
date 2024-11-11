package co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.services;

import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.mapping.dto.VendedorDto;
import co.edu.uniquindio.marketplaceoficial.marketplaceoficialapp.model.Vendedor;

import java.util.List;

public interface IMarketplaceMapping {
    List<VendedorDto> getVendedoresDto(List<Vendedor> listaVendedores);
    VendedorDto vendedorToVendedorDto(Vendedor vendedor);
    Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto);
}
