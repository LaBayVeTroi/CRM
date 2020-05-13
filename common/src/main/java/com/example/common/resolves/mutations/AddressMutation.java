package com.example.common.resolves.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.common.service.AddressService;
import com.example.domain.Address;
import com.example.domain.dto.AddressInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddressMutation implements GraphQLMutationResolver {

    @Autowired
    private AddressService addressService;

    public Address createAddress(AddressInput addressInput) {
        return addressService.save(addressInput.mapper());
    }

    public List<Address> saveAllAddresses(List<AddressInput> addressInputList) {
        List<Address> addresses = new ArrayList<>();
        addressInputList.forEach(addressInput -> addresses.add(addressInput.mapper()));
        return addressService.saveAll(addresses);
    }

    public String deleteAddressById(Integer id) {
        addressService.deleteById(id);
        return "resource with id: " + id + " was deleted";
    }

    public void deleteAllAddresses() {
        addressService.deleteAll();
    }

    public void deleteAllAddresses(List<Integer> ids) {
        ids.forEach(this::deleteAddressById);
    }

    public Address updateAddress(Address address) {
        return addressService.update(address);
    }
}
