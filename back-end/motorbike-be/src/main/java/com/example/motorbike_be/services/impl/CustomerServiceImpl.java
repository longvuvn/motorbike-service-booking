package com.example.motorbike_be.services.impl;


import com.example.motorbike_be.dto.customer.request.CustomerRequest;
import com.example.motorbike_be.dto.customer.request.CustomerUpdateRequest;
import com.example.motorbike_be.dto.customer.response.CustomerResponse;
import com.example.motorbike_be.enums.UserStatus;
import com.example.motorbike_be.models.Customer;
import com.example.motorbike_be.models.Role;
import com.example.motorbike_be.repositories.CustomerRepository;
import com.example.motorbike_be.repositories.RoleRepository;
import com.example.motorbike_be.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private static final String AVATAR_URL = "/image/c21f969b5f03d33d43e04f8f136e7682.png";
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository  roleRepository;

    @Override
    public List<CustomerResponse> getAllCustomers() {
        try{
            List<Customer> customers = customerRepository.findAll();
            return customers.stream()
                    .map(customer -> modelMapper.map(customer, CustomerResponse.class))
                    .collect(Collectors.toList());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public CustomerResponse getCustomerById(String id) {
        UUID uuid = UUID.fromString(id);
        Customer customer = customerRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return modelMapper.map(customer, CustomerResponse.class);
    }

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Role customerRole = roleRepository.findByName("CUSTOMER");
        if(customerRepository.existsByEmail(customerRequest.getEmail())){
            throw new DataIntegrityViolationException("Email already exists");
        }
        if(customerRepository.existsByFullName(customerRequest.getFullName())){
            throw new DataIntegrityViolationException("Full Name already exists");
        }
        Customer customer = modelMapper.map(customerRequest, Customer.class);
        customer.setStatus(UserStatus.ACTIVE);
        customer.setAvatar(AVATAR_URL);
        customer.setPassword(passwordEncoder.encode(customerRequest.getPassword()));
        customer.setRole(customerRole);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerResponse.class);
    }

    @Override
    public CustomerResponse updateCustomer(String id, CustomerUpdateRequest customerUpdateRequest) {
        UUID uuid = UUID.fromString(id);
        Customer customer = customerRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        modelMapper.map(customerUpdateRequest, customer);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerResponse.class);
    }

    @Override
    public void deleteCustomer(String id) {
        UUID uuid = UUID.fromString(id);
        Customer customer = customerRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customerRepository.delete(customer);
    }
}
