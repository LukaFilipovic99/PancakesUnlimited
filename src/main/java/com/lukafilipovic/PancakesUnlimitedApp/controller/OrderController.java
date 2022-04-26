package com.lukafilipovic.PancakesUnlimitedApp.controller;

import com.lukafilipovic.PancakesUnlimitedApp.payload.OrderDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.OrderResponseDto;
import com.lukafilipovic.PancakesUnlimitedApp.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    private ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderDto orderDto){
        return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.CREATED);
    }
}
