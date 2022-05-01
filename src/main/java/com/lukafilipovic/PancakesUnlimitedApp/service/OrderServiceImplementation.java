package com.lukafilipovic.PancakesUnlimitedApp.service;

import com.lukafilipovic.PancakesUnlimitedApp.MappingCls.MappingToDto;
import com.lukafilipovic.PancakesUnlimitedApp.exceptions.IdNotFoundException;
import com.lukafilipovic.PancakesUnlimitedApp.exceptions.OrderApiException;
import com.lukafilipovic.PancakesUnlimitedApp.model.Ingredient;
import com.lukafilipovic.PancakesUnlimitedApp.model.Order;
import com.lukafilipovic.PancakesUnlimitedApp.model.Pancake;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Request.OrderDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.OrderResponseDto;
import com.lukafilipovic.PancakesUnlimitedApp.payload.Response.OrderResponseWithPriceDto;
import com.lukafilipovic.PancakesUnlimitedApp.repository.OrderRepository;
import com.lukafilipovic.PancakesUnlimitedApp.repository.PancakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
        order.setDateTime(LocalDateTime.now());
        order.setDescription(orderDto.getDescription());
        Order newOrder=orderRepository.save(order);
        for (Pancake p: newOrder.getListOfPancakes()){
            p.setOrder(newOrder);
            pancakeRepository.save(p);
        }
        return MappingToDto.mapOrderToDto(newOrder);
    }

    @Override
    public OrderResponseWithPriceDto getOrderById(long id) {
        Order order=orderRepository.findById(id).orElseThrow(()-> new IdNotFoundException("Order Id not found."));
        Map<Pancake,Double> pancakePrices=sumPancakesPrices(order);
        double orderPrice=sumOrderPrice(pancakePrices);
        if (orderPrice>200.0) orderPrice=0.9*orderPrice;
        else if (orderPrice>100.0) orderPrice=0.95*orderPrice;

        Map<Pancake,Double> pancakePricesHealthy=new HashMap<>();
        System.out.println(pancakePricesHealthy);
        for (Pancake p: pancakePrices.keySet()){
            if (isPancakeHealthy(p)) pancakePricesHealthy.put(p,0.85*pancakePrices.get(p));
            else pancakePricesHealthy.put(p,pancakePrices.get(p));
        }
        double orderPriceHealthy=sumOrderPrice(pancakePricesHealthy);
        OrderResponseWithPriceDto orderResponseWithPriceDto;
        if (orderPrice<=orderPriceHealthy) orderResponseWithPriceDto= MappingToDto.mapOrderWithPriceToDto(order,orderPrice,pancakePrices);
        else orderResponseWithPriceDto= MappingToDto.mapOrderWithPriceToDto(order,orderPriceHealthy,pancakePricesHealthy);
        return orderResponseWithPriceDto;
    }

    private boolean isPancakeHealthy(Pancake p){
        boolean healthy=false;
        int numOfIngredients=0;
        int numOfHealthyIngredients=0;
        for (Ingredient i:p.getPancakeIngredients()){
            numOfIngredients++;
            if(i.getHealthy().equals(true)) numOfHealthyIngredients++;
        }
        if(numOfHealthyIngredients>(0.75*numOfIngredients)) healthy=true;
        return healthy;
    }

    private Map<Pancake,Double> sumPancakesPrices(Order order){
        Map<Pancake,Double> pancakePrices=new HashMap<>();
        for (Pancake p: order.getListOfPancakes()){
            double pancakePrice=0.0;
            for(Ingredient i:p.getPancakeIngredients()){
                pancakePrice+=i.getPrice();
            }
            pancakePrices.put(p,pancakePrice);
        }
        return pancakePrices;
    }

    private double sumOrderPrice(Map<Pancake,Double> pancakePrices){
        double orderPrice=0.0;
        for (Pancake p:pancakePrices.keySet()) orderPrice+=pancakePrices.get(p);
        return orderPrice;
    }
}
