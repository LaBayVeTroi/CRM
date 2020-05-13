package com.example.common.service.impl;

import com.example.common.service.AddressService;
import com.example.domain.Address;
import com.example.repository.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends BaseServiceImpl<AddressRepository,Address,Integer> implements AddressService  {
}
