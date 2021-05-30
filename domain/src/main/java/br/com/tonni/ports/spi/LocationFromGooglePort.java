package br.com.tonni.ports.spi;

import br.com.tonni.data.AdressDto;

public interface LocationFromGooglePort {

    AdressDto getLocationOfAdress(AdressDto adress);
}
