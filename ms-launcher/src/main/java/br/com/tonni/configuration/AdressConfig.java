package br.com.tonni.configuration;

import br.com.tonni.adapters.AdressJpaAdapter;
import br.com.tonni.adapters.LocationFromGoogle;
import br.com.tonni.ports.api.AdressServicePort;
import br.com.tonni.ports.spi.AdressPersistencePort;
import br.com.tonni.ports.spi.LocationFromGooglePort;
import br.com.tonni.service.AdressServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdressConfig {

    @Bean
    public AdressPersistencePort adressPersistence(){
        return new AdressJpaAdapter();
    }

    @Bean
    public LocationFromGooglePort locationByGoogle(){
        return new LocationFromGoogle();
    }

    @Bean
    public AdressServicePort adressService(){
        return new AdressServiceImpl(adressPersistence(), locationByGoogle());
    }
}
