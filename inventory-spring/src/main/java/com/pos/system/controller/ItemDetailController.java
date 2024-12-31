package com.pos.system.controller;

import com.pos.system.dto.CustomerDto;
import com.pos.system.dto.ItemDetailDto;
import com.pos.system.service.CustomerService;
import com.pos.system.service.ItemDetailService;
import com.pos.system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/itemDetails")
public class ItemDetailController {
    private final ItemDetailService itemDetailService;

    @Autowired
    public ItemDetailController(ItemDetailService itemDetailService) {
        this.itemDetailService = itemDetailService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createItemDetail(@RequestBody ItemDetailDto itemDetailDto) throws SQLException, ClassNotFoundException {
        itemDetailService.createItemDetail(itemDetailDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Item was saved!", itemDetailDto.getItemDetailId()),
                HttpStatus.CREATED
        );
    }
}
