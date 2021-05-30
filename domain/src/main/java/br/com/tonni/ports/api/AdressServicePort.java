package br.com.tonni.ports.api;

import br.com.tonni.data.AdressDto;

import java.util.List;
import java.util.Optional;

public interface AdressServicePort {

    List<AdressDto> findAll();

    AdressDto save(AdressDto adress);

    AdressDto findById(Long adressId);

    Optional<AdressDto> update(Long adressId, AdressDto adressRequest);

    Optional<Object> delete(Long adressId);
}
