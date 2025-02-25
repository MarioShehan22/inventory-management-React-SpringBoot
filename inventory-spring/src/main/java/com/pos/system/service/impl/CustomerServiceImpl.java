package com.pos.system.service.impl;

import com.pos.system.dto.CustomerDto;
import com.pos.system.entity.Customer;
import com.pos.system.repo.CustomerRepo;
import com.pos.system.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public void createCustomer(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setEmail(dto.getEmail());
        customer.setName(dto.getName());
        customer.setContact(dto.getContact());
        customer.setSalary(dto.getSalary());
        customerRepo.save(customer);
    }

    @Override
    public void updateCustomer(CustomerDto dto, String customerId){
        Optional<Customer> selectedCustomer = customerRepo.findUserByCustomerId(customerId);
        if (selectedCustomer.isEmpty()) throw new RuntimeException();
        selectedCustomer.get().setEmail(dto.getEmail());
        selectedCustomer.get().setName(dto.getName());
        selectedCustomer.get().setContact(dto.getContact());
        selectedCustomer.get().setSalary(dto.getSalary());
        selectedCustomer.get().setId(customerId);
        customerRepo.save(selectedCustomer.get());
    }

    @Override
    public void deleteCustomer(String id) {
        Optional<Customer> selectedCustomer = customerRepo.findUserByCustomerId(id);
        if (selectedCustomer.isEmpty()) throw new RuntimeException();
        customerRepo.delete(selectedCustomer.get());
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        List<Customer> allUsers = customerRepo.findAll();
        List<CustomerDto> dtos = new ArrayList<>();
        allUsers.forEach(e -> {
            dtos.add(
                    new CustomerDto(
                    e.getId(),
                    e.getName(),
                    e.getEmail(),
                    e.getContact(),
                    e.getSalary()
            ));
        });
        return dtos;
    }
}
