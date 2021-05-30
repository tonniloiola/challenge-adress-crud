package br.com.tonni.entity;

public final class AdressBuilder {
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

    private AdressBuilder() {
    }

    public static AdressBuilder anAdress() {
        return new AdressBuilder();
    }

    public AdressBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public AdressBuilder withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public AdressBuilder withNumber(Integer number) {
        this.number = number;
        return this;
    }

    public AdressBuilder withComplement(String complement) {
        this.complement = complement;
        return this;
    }

    public AdressBuilder withNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
        return this;
    }

    public AdressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AdressBuilder withState(String state) {
        this.state = state;
        return this;
    }

    public AdressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public AdressBuilder withZipcode(String zipcode) {
        this.zipcode = zipcode;
        return this;
    }

    public AdressBuilder withLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public AdressBuilder withLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public Adress build() {
        Adress adress = new Adress();
        adress.setId(id);
        adress.setStreetName(streetName);
        adress.setNumber(number);
        adress.setComplement(complement);
        adress.setNeighbourhood(neighbourhood);
        adress.setCity(city);
        adress.setState(state);
        adress.setCountry(country);
        adress.setZipcode(zipcode);
        adress.setLatitude(latitude);
        adress.setLongitude(longitude);
        return adress;
    }
}
