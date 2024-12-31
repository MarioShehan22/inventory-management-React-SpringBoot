package com.pos.system.controller;

import com.pos.system.dto.CustomerDto;
import com.pos.system.service.CustomerService;
import com.pos.system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createCustomer(@RequestBody CustomerDto customerDto) throws SQLException, ClassNotFoundException {
        customerService.createCustomer(customerDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Customer was saved!", customerDto.getName()),
                HttpStatus.CREATED
        );
    }
    @PutMapping(path = "/{customerId}")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerDto dto, @PathVariable String customerId) throws SQLException, ClassNotFoundException {
        customerService.updateCustomer(dto, customerId);
        return new ResponseEntity<>(
                new StandardResponse( 201,"customer was updated!",dto.getName()),
                HttpStatus.CREATED
        );
    }
    @GetMapping(path = "/list")
    public ResponseEntity<StandardResponse> findAllCustomer() throws SQLException, ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(200, "Data List!", customerService.findAllCustomers()),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable long id) throws SQLException, ClassNotFoundException {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(
                new StandardResponse( 204 ," was Deleted!",id),
                HttpStatus.NO_CONTENT
        );
    }
}
