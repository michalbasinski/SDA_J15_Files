package pl.sda.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Adnotacja ignoruje nieznane pola w trakcie serializacji/deseralizacji
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String city;
    private String street;
    private String postalCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
