package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.payload.Request.OrderDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.OrderResponseDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.OrderResponseWithPriceDto;

public interface OrderService {
    OrderResponseDto createOrder(OrderDto orderDto);
    OrderResponseWithPriceDto getOrderById(long id);
}
