package com.example.factory.SoftwareEngineering.repository;

import com.example.factory.SoftwareEngineering.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<Order, Long> {

}
