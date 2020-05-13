package com.example.common.resolves.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.common.service.AddressService;
import com.example.domain.Address;
import com.example.domain.dto.AddressInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMutation implements GraphQLMutationResolver {

    @Autowired
    private AddressService addressService;

    public Address createAddress(AddressInput addressInput) {
        return addressService.save(addressInput.mapper());
    }

}
