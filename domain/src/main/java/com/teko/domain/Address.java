package com.teko.domain;

import com.teko.proto.AddTagRequest;
import com.teko.proto.AddressTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@Entity
public class Address {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "address_line")
    private String addressLine;
    private String street;
    private String city;
    private String state;
    private String postcode;
    private String country;

    public static Address fromProto(AddressTranfer addressTranfer){
        return Address.builder()
                .id(addressTranfer.getId())
                .addressLine(addressTranfer.getAddressLine())
                .street(addressTranfer.getStreet())
                .city(addressTranfer.getCity())
                .postcode(addressTranfer.getPostcode())
                .country(addressTranfer.getCountry())
                .build();
    }

    public AddressTranfer toProto(){
        return AddressTranfer.newBuilder()
                .setId(this.id)
                .setAddressLine(this.addressLine)
                .setStreet(this.street)
                .setCity(this.city)
                .setPostcode(this.postcode)
                .setCountry(this.country)
                .build();
    }
}
