package jpajava.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    String street;
    String city;
    String zipCode;

    public Address() {
    }

    public Address(final String street, final String city, final String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
}
