package com.example.factory.SoftwareEngineering.controller;

import store.dao.*;
import com.example.factory.SoftwareEngineering.entity.Order;
import com.example.factory.SoftwareEngineering.entity.StoreItem;
import com.example.factory.SoftwareEngineering.entity.User;
import com.example.factory.SoftwareEngineering.repository.StoreItemRepository;
import com.example.factory.SoftwareEngineering.repository.UserRepository;
import com.example.factory.SoftwareEngineering.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class EmployeeController {

    @Autowired
    private orderRepository orderRepository;
    CustomerDAO cdao = new CustomerDAO();
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoreItemRepository storeItemRepository;

    @GetMapping("/orders")
    public List<Order> fetchOrders(){
        return orderRepository.findAll();
    }

    @GetMapping("/users")
    public List<User> fetchUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/storeItems")
    public List<StoreItem> fetchStoreItems(){
        return storeItemRepository.findAll();
    }


}
