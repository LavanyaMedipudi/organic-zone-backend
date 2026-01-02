package com.college.organiczone_backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.college.organiczone_backend.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByBuyerEmail(String buyerEmail);

}
