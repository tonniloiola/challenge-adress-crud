package br.com.tonni.data;

public final class AdressDtoBuilder {
    private Long id;
    private String streetName;
    private Integer number;
    private String complement;
    private String neighbourhood;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private Double latitude;
    private Double longitude;

    private AdressDtoBuilder() {
    }

    public static AdressDtoBuilder anAdressDto() {
        return new AdressDtoBuilder();
    }

    public AdressDtoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public AdressDtoBuilder withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public AdressDtoBuilder withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public AdressDtoBuilder withComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public AdressDtoBuilder withNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
        return this;
    }

    public AdressDtoBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AdressDtoBuilder withState(String state) {
        this.state = state;
        return this;
    }

    public AdressDtoBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public AdressDtoBuilder withZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public AdressDtoBuilder withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public AdressDtoBuilder withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public AdressDto build() {
        AdressDto adressDto = new AdressDto();
        adressDto.setId(id);
        adressDto.setStreetName(streetName);
        adressDto.setNumber(number);
        adressDto.setComplement(complement);
        adressDto.setNeighbourhood(neighbourhood);
        adressDto.setCity(city);
        adressDto.setState(state);
        adressDto.setCountry(country);
        adressDto.setZipcode(zipcode);
        adressDto.setLatitude(latitude);
        adressDto.setLongitude(longitude);
        return adressDto;
    }
}
