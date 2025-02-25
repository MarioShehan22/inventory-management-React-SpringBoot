package com.pos.system.controller;

import com.pos.system.dto.ItemDetailDto;
import com.pos.system.service.ItemDetailService;
import com.pos.system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/itemDetails")
@CrossOrigin()
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
    @GetMapping(path = "/findAllTotalAmountPerProducts/list")
    public ResponseEntity<StandardResponse> findAllTotalAmountPerProducts() throws SQLException, ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(200, "Data List!", itemDetailService.findAllTotalAmountPerProducts()),
                HttpStatus.OK
        );
    }@GetMapping(path = "/findAllTotalQtyPerProducts/list")
    public ResponseEntity<StandardResponse> findAllTotalQtyPerProducts() throws SQLException, ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(200, "Data List!", itemDetailService.findAllTotalQTYPerProducts()),
                HttpStatus.OK
        );
    }

}
