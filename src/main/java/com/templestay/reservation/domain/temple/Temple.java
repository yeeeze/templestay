package com.templestay.reservation.domain.temple;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Getter
@Entity
public class Temple {

    @Id
    private BigInteger id;
    private String name;
    private String address;
    private String contact;

    public Temple() {
    }

    public Temple(BigInteger id, String name, String address, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
}
