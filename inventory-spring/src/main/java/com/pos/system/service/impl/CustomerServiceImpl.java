package com.pos.system.service.impl;

import com.pos.system.dto.requestDto.CustomerDto;
import com.pos.system.dto.responsedto.ResponseCustomerDto;
import com.pos.system.dto.responsedto.paginated.PaginatedCustomerDto;
import com.pos.system.entity.Customer;
import com.pos.system.repo.CustomerRepo;
import com.pos.system.service.CustomerService;
import com.pos.system.util.mapper.CustomerMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    private final CustomerMapper customerMapper;

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
    public PaginatedCustomerDto findAllCustomers(String searchText, int page, int size) {
        searchText = "%" + searchText + "%";
        List<Customer> allCustomers = customerRepo.searchCustomers(searchText, PageRequest.of(page, size));
        long customerCount = customerRepo.countCustomers(searchText);
        List<ResponseCustomerDto> dtos = customerMapper.toResponseCustomerDtoList(allCustomers);

        return new PaginatedCustomerDto(
                customerCount,
                dtos
        );
    }
}
