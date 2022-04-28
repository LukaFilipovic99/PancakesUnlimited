package com.lukafilipovic.PancakesUnlimitedApp.controller;

import com.lukafilipovic.PancakesUnlimitedApp.payload.Request.OrderDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.OrderResponseDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.OrderResponseWithPriceDto;
import com.lukafilipovic.PancakesUnlimitedApp.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    private ResponseEntity<OrderResponseDto> createOrder(@Valid @RequestBody OrderDto orderDto){
        return new ResponseEntity<>(orderService.createOrder(orderDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<OrderResponseWithPriceDto> getOrderById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }


}
