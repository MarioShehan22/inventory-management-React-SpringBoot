package com.pos.system.controller;

import com.pos.system.dto.requestDto.OrderDetailDto;
import com.pos.system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("api/v1/batch")
@RequiredArgsConstructor
public class BatchController {
    @PostMapping
    public ResponseEntity<StandardResponse> createBatch(@RequestBody OrderDetailDto orderDetailDto) throws SQLException, ClassNotFoundException {
        //orderDetailService.createOrder(orderDetailDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Batch was saved!", orderDetailDto.getOrderId()),
                HttpStatus.CREATED
        );
    }
}
