package br.com.tonni.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The streetName field is required.")
    @Column(name="streetname",nullable = false)
    private String streetName;

    @NotNull(message = "The number field is required.")
    @Column(name="numberadress", nullable = false)
    private Integer number;

    @Column
    private String complement;

    @NotNull(message = "The neighbourhood field is required.")
    @Column(nullable = false)
    private String neighbourhood;

    @NotNull(message = "The city field is required.")
    @Column(nullable = false)
    private String city;

    @NotNull(message = "The state field is required.")
    @Column(name="stateadress",nullable = false)
    private String state;

    @NotNull(message = "The country field is required.")
    @Column(nullable = false)
    private String country;

    @NotNull(message = "The zipcode field is required.")
    @Column(nullable = false)
    private String zipcode;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


}
