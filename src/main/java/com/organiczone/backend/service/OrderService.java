package com.college.organiczone_backend.service;

import java.util.List;
import com.college.organiczone_backend.dto.OrderRequestDTO;
import com.college.organiczone_backend.model.Order;

public interface OrderService {

    Order placeOrder(OrderRequestDTO dto);
    List<Order> getOrdersByBuyer(String email);
}


