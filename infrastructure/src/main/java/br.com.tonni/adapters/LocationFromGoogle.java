package br.com.tonni.adapters;

import br.com.tonni.data.AdressDto;
import br.com.tonni.entity.Adress;
import br.com.tonni.ports.spi.LocationFromGooglePort;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocationFromGoogle implements LocationFromGooglePort {

    @Autowired
    private RestTemplate restTemplate;

//    public String getLocation()
//    {
//        final String uri = "https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";
//
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
//
//        System.out.println(result);
//
//        return result;
//    }

//    public Adress getLocationOfAdress(Adress adress) {
//        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw");
//        try {
//            String address2 = "";
//            if (adress.getNumber() != null && adress.getNumber() > 0 ) {
//                address2 += (address2.length() > 0 ? ", " : "") + adress.getNumber();
//            }
//            if (adress.getStreetName() != null && adress.getStreetName().length() > 0 ) {
//                address2 += (address2.length() > 0 ? ", " : "") + adress.getStreetName();
//            }
//            if (adress.getZipcode() != null && adress.getZipcode().length() > 0 ) {
//                address2 += (address2.length() > 0 ? ", " : "") + adress.getZipcode();
//            }
//            if (adress.getCity() != null && adress.getCity().length() > 0 ) {
//                address2 += (address2.length() > 0 ? ", " : "") + adress.getCity();
//            }
//            if (adress.getState() != null && adress.getState().length() > 0 ) {
//                address2 += (address2.length() > 0 ? ", " : "") + adress.getState();
//            }
//            if (adress.getCountry() != null && adress.getCountry() != null && adress.getCountry().length() > 0 ) {
//                address2 += (address2.length() > 0 ? ", " : "") + adress.getCountry();
//            }
//            if (address2.length() > 0) {
////                address2 = "1600+Amphitheatre+Parkway,+Mountain+View,+CA";
//                GeocodingResult[] results =  GeocodingApi.geocode(context, address2).await();
//                adress.setLatitude(results[0].geometry.location.lat);
//                adress.setLongitude(results[0].geometry.location.lng);
//                return adress;
//            } else {
////                log.error("Unable to geocode address of " + adress.getFullName() + ": No address available");
//                return null;
//            }
//        } catch (Exception e) {
////            log.error("Unable to geocode address of " + adress.getFullName() + ": " + e.toString());
//            return null;
//        }
//
//    }

    @Override
    public AdressDto getLocationOfAdress(AdressDto adress) {
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw");
        try {
            String address2 = "";
            if (adress.getNumber() != null && adress.getNumber() > 0 ) {
                address2 += (address2.length() > 0 ? ", " : "") + adress.getNumber();
            }
            if (adress.getStreetName() != null && adress.getStreetName().length() > 0 ) {
                address2 += (address2.length() > 0 ? ", " : "") + adress.getStreetName();
            }
            if (adress.getZipcode() != null && adress.getZipcode().length() > 0 ) {
                address2 += (address2.length() > 0 ? ", " : "") + adress.getZipcode();
            }
            if (adress.getCity() != null && adress.getCity().length() > 0 ) {
                address2 += (address2.length() > 0 ? ", " : "") + adress.getCity();
            }
            if (adress.getState() != null && adress.getState().length() > 0 ) {
                address2 += (address2.length() > 0 ? ", " : "") + adress.getState();
            }
            if (adress.getCountry() != null && adress.getCountry() != null && adress.getCountry().length() > 0 ) {
                address2 += (address2.length() > 0 ? ", " : "") + adress.getCountry();
            }
            if (address2.length() > 0) {
//                address2 = "1600+Amphitheatre+Parkway,+Mountain+View,+CA";
                GeocodingResult[] results =  GeocodingApi.geocode(context, address2).await();
                adress.setLatitude(results[0].geometry.location.lat);
                adress.setLongitude(results[0].geometry.location.lng);
                return adress;
            } else {
//                log.error("Unable to geocode address of " + adress.getFullName() + ": No address available");
                return null;
            }
        } catch (Exception e) {
//            log.error("Unable to geocode address of " + adress.getFullName() + ": " + e.toString());
            return null;
        }
    }
}
