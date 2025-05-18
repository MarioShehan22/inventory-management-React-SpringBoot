package com.pos.system.controller;

import com.pos.system.dto.requestDto.OrderDetailDto;
import com.pos.system.service.OrderDetailService;
import com.pos.system.util.StandardResponse;
import jakarta.validation.constraints.Max;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<StandardResponse> createOrder(@RequestBody OrderDetailDto orderDetailDto) throws SQLException, ClassNotFoundException {
        String id = orderDetailService.createOrder(orderDetailDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Order was saved!", id),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/list",params = {"page","size"})
    public ResponseEntity<StandardResponse> findAllOrders(@RequestParam(value = "page") int page, @RequestParam(value = "size") @Max(50) int size) throws SQLException, ClassNotFoundException {

        return new ResponseEntity<>(
                new StandardResponse(200, "Data List!", orderDetailService.findAllOrders(page,size)),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteOrder(@PathVariable String id) throws SQLException, ClassNotFoundException {
        orderDetailService.deleteOrder(id);
        return new ResponseEntity<>(
                new StandardResponse( 204 ," was Deleted!",id),
                HttpStatus.NO_CONTENT
        );
    }
}
