package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.MappingCls.MapDtosEntities;
import com.lukafilipovic.PancakesUnlimitedApp.exceptions.IdNotFoundException;
import com.lukafilipovic.PancakesUnlimitedApp.exceptions.OrderApiException;
import com.lukafilipovic.PancakesUnlimitedApp.model.Order;
import com.lukafilipovic.PancakesUnlimitedApp.model.Pancake;
import com.lukafilipovic.PancakesUnlimitedApp.payload.OrderDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.OrderResponseDto;
import com.lukafilipovic.PancakesUnlimitedApp.repository.OrderRepository;
import com.lukafilipovic.PancakesUnlimitedApp.repository.PancakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService{
    private OrderRepository orderRepository;
    private PancakeRepository pancakeRepository;

    @Autowired
    public OrderServiceImplementation(OrderRepository orderRepository, PancakeRepository pancakeRepository) {
        this.orderRepository = orderRepository;
        this.pancakeRepository = pancakeRepository;
    }

    @Override
    public OrderResponseDto createOrder(OrderDto orderDto) {
        Order order=new Order();
        for (Long id: orderDto.getPancakeIds()) {
            Pancake pancake = pancakeRepository.findById(id).orElseThrow(() -> new IdNotFoundException("Pancake Id not found."));
            if (pancake.getOrder()==null) {
                order.getListOfPancakes().add(pancake);
            }
            else throw new OrderApiException("Cannot add pancake to multiple orders.");
        }
        order.setTime(LocalTime.now());
        order.setDescription(orderDto.getDescription());
        Order newOrder=orderRepository.save(order);
        for (Pancake p: newOrder.getListOfPancakes()){
            p.setOrder(newOrder);
            pancakeRepository.save(p);
        }
        return MapDtosEntities.mapOrderToDto(newOrder);
    }
}
