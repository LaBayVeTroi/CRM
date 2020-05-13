package com.example.domain.dto;

import com.example.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressInput implements Input<Address> {
    private String addressLine;
    private String street;
    private String city;
    private String state;
    private String postcode;
    private String country;

    @Override
    public Address mapper() {
        return Address.builder().addressLine(this.getAddressLine())
                .city(this.getCity())
                .country(this.getCountry())
                .postcode(this.getPostcode())
                .state(this.getState())
                .street(this.getStreet())
                .build();
    }
}
