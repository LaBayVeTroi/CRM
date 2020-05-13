package com.example.common.resolves.querys;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.common.service.AddressService;
import com.example.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressQuery implements GraphQLQueryResolver {

    @Autowired
    private AddressService addressService;

    public List<Address> getAllAddresses() {
        return addressService.findAll();
    }
}
