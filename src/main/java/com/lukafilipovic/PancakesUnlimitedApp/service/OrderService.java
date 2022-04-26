package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.payload.OrderDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderDto orderDto);
}
