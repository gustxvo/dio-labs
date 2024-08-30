package io.github.gustxvo.bootcamp.claro.domain.model.client;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "address_street", nullable = false)
    private String street;

    @Column(name = "address_number", nullable = false)
    private String number;

    @Column(name = "address_complement")
    private String complement;

    public Address() { }

    public Address(String street, String number, String complement) {
        this.street = street;
        this.number = number;
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
