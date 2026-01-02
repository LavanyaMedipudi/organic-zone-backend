package com.college.organiczone_backend.controller;

import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.college.organiczone_backend.dto.OrderRequestDTO;
import com.college.organiczone_backend.model.Order;
import com.college.organiczone_backend.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@Valid @RequestBody OrderRequestDTO dto) {
        return orderService.placeOrder(dto);
    }

    @GetMapping("/buyer/{email}")
    public List<Order> getOrdersByBuyer(@PathVariable String email) {
        return orderService.getOrdersByBuyer(email);
    }
}







