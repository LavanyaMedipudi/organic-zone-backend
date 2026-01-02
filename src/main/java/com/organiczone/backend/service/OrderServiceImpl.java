package com.college.organiczone_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.organiczone_backend.dto.OrderRequestDTO;
import com.college.organiczone_backend.model.Order;
import com.college.organiczone_backend.model.Product;
import com.college.organiczone_backend.repository.OrderRepository;
import com.college.organiczone_backend.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Order placeOrder(OrderRequestDTO dto) {

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // STOCK VALIDATION
        if (dto.getQuantity() > product.getQuantity()) {
            throw new RuntimeException("Insufficient stock available");
        }

        // CALCULATE TOTAL PRICE
        double totalPrice = product.getPrice() * dto.getQuantity();

        // REDUCE PRODUCT QUANTITY
        product.setQuantity(product.getQuantity() - dto.getQuantity());
        productRepository.save(product);

        // CREATE ORDER
        Order order = new Order();
        order.setProductId(product.getId());
        order.setBuyerEmail(dto.getBuyerEmail());
        order.setQuantity(dto.getQuantity());
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrdersByBuyer(String email) {
        throw new UnsupportedOperationException("Unimplemented method 'getOrdersByBuyer'");
    }
}
