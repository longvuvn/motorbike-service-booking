package com.example.motorbike_be.services.impl;

import com.example.motorbike_be.dto.address.request.AddressRequest;
import com.example.motorbike_be.dto.address.request.AddressUpdateRequest;
import com.example.motorbike_be.dto.address.request.UnDefaultAddressRequest;
import com.example.motorbike_be.dto.address.response.AddressResponse;
import com.example.motorbike_be.models.Address;
import com.example.motorbike_be.models.Customer;
import com.example.motorbike_be.repositories.AddressRepository;
import com.example.motorbike_be.repositories.CustomerRepository;
import com.example.motorbike_be.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;




@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<AddressResponse> getAddressByCustomerId(String customerId) {
        UUID customerUuid = UUID.fromString(customerId);
        List<Address> getAllAddress = addressRepository.findActiveAddresses(customerUuid);
        return getAllAddress.stream()
                .map(address -> modelMapper.map(address, AddressResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public AddressResponse createAddress(String customerId, AddressRequest request) {
        UUID customerUuid = UUID.fromString(customerId);
        Customer customer = customerRepository.findById(customerUuid)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Address address = modelMapper.map(request, Address.class);
        address.setCustomer(customer);
        if(!addressRepository.existsByCustomerId(customer.getId())){
            address.setDefault(true);
        }else{
            address.setDefault(false);
        }
        return modelMapper.map(addressRepository.save(address), AddressResponse.class);
    }

    @Override
    public AddressResponse updateAddress(String addressId, AddressUpdateRequest request) {
        UUID addreessUuid = UUID.fromString(addressId);
        Address address = addressRepository.findById(addreessUuid)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        modelMapper.map(request, address);
        Address updatedAddress = addressRepository.save(address);
        return modelMapper.map(updatedAddress, AddressResponse.class);
    }

    @Override
    public AddressResponse unDefaultAddress(String customerId, UnDefaultAddressRequest request) {
        UUID customerUuid = UUID.fromString(customerId);
        UUID addressUuid = UUID.fromString(request.getId());
        List<Address> addressList =
                addressRepository.findActiveAddresses(customerUuid);
        boolean found = false;
        Address defaultAddress = null;
        for (Address address : addressList) {
            if (address.getId().equals(addressUuid)) {
                address.setDefault(true);
                found = true;
                defaultAddress = address;
            } else {
                address.setDefault(false);
            }
        }
        if (!found) {
            throw new RuntimeException("Address does not belong to customer");
        }
        addressRepository.saveAll(addressList);
        return modelMapper.map(defaultAddress, AddressResponse.class);
    }


    @Override
    public void deleteAddress(String addressId) {
        UUID addressUuid = UUID.fromString(addressId);
        Address address = addressRepository.findById(addressUuid)
                .orElseThrow(() -> new RuntimeException("Address not found"));
        addressRepository.delete(address);
    }
}