package br.com.tonni.service;

import br.com.tonni.data.AdressDto;
import br.com.tonni.ports.api.AdressServicePort;
import br.com.tonni.ports.spi.AdressPersistencePort;
import br.com.tonni.ports.spi.LocationFromGooglePort;

import java.util.List;
import java.util.Optional;

public class AdressServiceImpl implements AdressServicePort {

    private AdressPersistencePort adressPersistencePort;

    private LocationFromGooglePort locationFromGooglePort;

    public AdressServiceImpl(AdressPersistencePort adressPersistencePort, LocationFromGooglePort locationFromGooglePort) {
        this.adressPersistencePort = adressPersistencePort;
        this.locationFromGooglePort = locationFromGooglePort;
    }

    @Override
    public List<AdressDto> findAll(){
        return this.adressPersistencePort.findAll();
    }

    @Override
    public AdressDto findById(Long id){
        return this.adressPersistencePort.findById(id);
    }

    @Override
    public AdressDto save(AdressDto adress) {
        if(validationLatAndLong(adress)){
            locationFromGooglePort.getLocationOfAdress(adress);
        }

        return this.adressPersistencePort.save(adress);
    }

    @Override
    public Optional<AdressDto> update(Long adressId, AdressDto adressRequest) {
        if(validationLatAndLong(adressRequest)){
            locationFromGooglePort.getLocationOfAdress(adressRequest);
        }
        return adressPersistencePort.findByIdOptional(adressId)
                .map(adress -> {
                    adress.setStreetName (adressRequest.getStreetName());
                    adress.setNumber(adressRequest.getNumber());
                    adress.setComplement(adressRequest.getComplement());
                    adress.setNeighbourhood(adressRequest.getNeighbourhood());
                    adress.setCity(adressRequest.getCity());
                    adress.setState(adressRequest.getState());
                    adress.setCountry(adressRequest.getCountry());
                    adress.setZipcode(adressRequest.getZipcode());
                    adress.setLatitude(adressRequest.getLatitude());
                    adress.setLongitude(adressRequest.getLongitude());

                    return this.save(adress);
                });
    }

    @Override
    public Optional<Object> delete(Long adressId) {
        return adressPersistencePort.findByIdOptional(adressId)
                .map(adress -> {
                    return this.delete(adressId);
                });
    }

    private boolean validationLatAndLong(AdressDto adress) {
        return adress.getLatitude() == null && adress.getLongitude() == null;
    }

}
