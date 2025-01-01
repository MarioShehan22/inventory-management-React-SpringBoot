package com.pos.system.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pos.system.dto.LoyaltyCardDto;
import com.pos.system.service.LoyaltyCardService;
import com.pos.system.util.StandardResponse;

@RestController
@RequestMapping("/api/v1/loyalCard")
public class LoyaltyCardController {

    private final LoyaltyCardService loyaltyCardService;

    @Autowired
    public LoyaltyCardController(LoyaltyCardService loyaltyCardService) {
        this.loyaltyCardService = loyaltyCardService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createLoyaltyCard(@RequestBody LoyaltyCardDto loyaltyCardDto) throws SQLException, ClassNotFoundException {
        loyaltyCardService.saveLoyaltyData(loyaltyCardDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "LoyaltyCard was saved!", loyaltyCardDto.getCardType()),
                HttpStatus.CREATED
        );
    }
    // @PutMapping(path = "/{customerId}")
    // public ResponseEntity<StandardResponse> updateLoyaltyCard(@RequestBody CustomerDto dto, @PathVariable String customerId) throws SQLException, ClassNotFoundException {
    //     loyaltyCardService.updateCustomer(dto, customerId);
    //     return new ResponseEntity<>(
    //             new StandardResponse( 201,"customer was updated!",dto.getName()),
    //             HttpStatus.CREATED
    //     );
    // }
    // @GetMapping(path = "/list")
    // public ResponseEntity<StandardResponse> findAllLoyaltyCard() throws SQLException, ClassNotFoundException {
    //     return new ResponseEntity<>(
    //             new StandardResponse(200, "Data List!", loyaltyCardService.findAllCustomers()),
    //             HttpStatus.OK
    //     );
    // }
    // @DeleteMapping("/{id}")
    // public ResponseEntity<StandardResponse> deleteLoyaltyCard(@PathVariable long id) throws SQLException, ClassNotFoundException {
    //     loyaltyCardService.deleteCustomer(id);
    //     return new ResponseEntity<>(
    //             new StandardResponse( 204 ," was Deleted!",id),
    //             HttpStatus.NO_CONTENT
    //     );
    // }
}
