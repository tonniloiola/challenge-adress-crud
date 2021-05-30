package br.com.tonni.adapters;

import br.com.tonni.data.AdressDto;
import br.com.tonni.entity.Adress;
import br.com.tonni.mappers.AdressMapper;
import br.com.tonni.ports.spi.AdressPersistencePort;
import br.com.tonni.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressJpaAdapter implements AdressPersistencePort {

    @Autowired
    private AdressRepository adressRepository;

    @Autowired
    LocationFromGoogle locationFromGoogle;

    @Override
    public List<AdressDto> findAll() {

        List<Adress> adress = (List<Adress>) adressRepository.findAll();
//        locationFromGoogle.getLocationOfAdress(adress.get(0));
        return AdressMapper.INSTANCE.adressListToAdressDtoList(adress);
    }

    @Override
    public AdressDto save(AdressDto adressDto) {
        Adress adress = AdressMapper.INSTANCE.adressDtoToAdress(adressDto);

        if(adress.getLatitude() == null && adress.getLongitude() == null){
            locationFromGoogle.getLocationOfAdress(adress);
        }

        Adress adressSaved = adressRepository.save(adress);

        return AdressMapper.INSTANCE.adressToAdressDto(adressSaved);
    }

    @Override
    public AdressDto  findById(Long adressId) {
        Optional<Adress> adress = adressRepository.findById(adressId);

        if (adress.isPresent()) {
            return AdressMapper.INSTANCE.adressToAdressDto(adress.get());
        }

        return null;
    }

    @Override
    public Optional<AdressDto>  findByIdOptional(Long adressId) {
        Optional<Adress> adress = adressRepository.findById(adressId);

        if (adress.isPresent()) {
            return Optional.ofNullable(AdressMapper.INSTANCE.adressToAdressDto(adress.get()));
        }

        return null;
    }

    @Override
    public Optional<AdressDto>  update(Long adressId, AdressDto adressRequest) {
        Adress adress = AdressMapper.INSTANCE.adressDtoToAdress(adressRequest);

        if(adress.getLatitude() == null && adress.getLongitude() == null){
            locationFromGoogle.getLocationOfAdress(adress);
        }
        Adress adressSaved = adressRepository.save(adress);

        return Optional.ofNullable(AdressMapper.INSTANCE.adressToAdressDto(adressSaved));
    }

    @Override
    public void delete(Long adressId) {
        Optional<Adress> adress = adressRepository.findById(adressId);

        adressRepository.deleteById(adressId);
    }
}

