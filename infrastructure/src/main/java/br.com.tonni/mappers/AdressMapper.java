package br.com.tonni.mappers;

import br.com.tonni.data.AdressDto;
import br.com.tonni.entity.Adress;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdressMapper {

    AdressMapper INSTANCE = Mappers.getMapper(AdressMapper.class);

    AdressDto adressToAdressDto(Adress adress);

    Adress adressDtoToAdress(AdressDto adressDto);

    List<AdressDto> adressListToAdressDtoList(List<Adress> adressList);

    List<Adress> adressDtoListToadressList(List<AdressDto> AdressDtoList);
}
