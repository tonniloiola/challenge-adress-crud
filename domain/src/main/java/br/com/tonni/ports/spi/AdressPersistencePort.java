package br.com.tonni.ports.spi;

import br.com.tonni.data.AdressDto;

import java.util.List;
import java.util.Optional;

public interface AdressPersistencePort {

    List<AdressDto> findAll();

    AdressDto save(AdressDto adress);

    Optional<AdressDto> findByIdOptional(Long adressId);

    AdressDto findById(Long adressId);

    Optional<AdressDto> update(Long adressId, AdressDto adressRequest);

    void delete(Long adressId);

}
