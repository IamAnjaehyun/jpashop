package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    //JPA 위해 그냥 만들기만 해놓음, 쓰라고 만든건 아니여서 protected
    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
