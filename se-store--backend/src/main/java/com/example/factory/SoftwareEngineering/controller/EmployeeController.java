package com.example.factory.SoftwareEngineering.controller;

import store.dao.*;
import com.example.factory.SoftwareEngineering.entity.Order;
import com.example.factory.SoftwareEngineering.entity.StoreItem;
import com.example.factory.SoftwareEngineering.entity.Transaction;
import com.example.factory.SoftwareEngineering.entity.User;
import com.example.factory.SoftwareEngineering.entity.UserLogin;
import com.example.factory.SoftwareEngineering.repository.StoreItemRepository;
import com.example.factory.SoftwareEngineering.repository.UserRepository;
import com.example.factory.SoftwareEngineering.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8081/")
public class EmployeeController {

    @Autowired
    private orderRepository orderRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoreItemRepository storeItemRepository;

    //Order API Calls

    @GetMapping("/orders")
    public List<Order> fetchOrders(){
        return orderRepository.findAll();
    }

    //User/Login API Calls

    @GetMapping("/users")
    public List<User> fetchUsers(){
        return userRepository.findAll();
    }

    //Input obj = {'userLogin':{'username':'the actual username', 'password':'hashed password'}}
    //Ouput = if it is the correct, it will return back an object that has values in all fields including firstname
    //If it is incorrect it will return the same object expept everything is an empty string or -1 for ints
    @PostMapping("/user/Auth")
    public User login(@RequestBody UserLogin login){
        //call DAO 
        User returnUser = new User();
        
        returnUser.setFirstName("Brandon");
        returnUser.setLastName("Whatley");
        returnUser.setUsername("brandon");
        returnUser.setUserId(1);

        return returnUser;
    }

    //Input Obj = {'username': 'actual username'}
    //Output = The balance of the user in the form of the double, and
    //If there is no user with that username return -1
    @PostMapping("user/balance")
    public double checkBalance(@RequestBody String username){
        //Call the DAO
        
        return 500;
    }
    

    //Items/Transactions API Calls


    //There is no input for this call
    //You will just return according ot the object that it is currently returning.
    @GetMapping("/storeItems")
    public List<StoreItem> fetchStoreItems(){
        return storeItemRepository.findAll();
    }

    @PostMapping("/storeItem/Qty")
    public int checkQty(@RequestBody String itemID){
        return 5;
    }

    @PostMapping("/reorder/item")
    public boolean reorderItem(@RequestBody String itemID){
        return true;
    }
    //Input obj = {'username': 'the username in question'}
    //Return is going to be an array of objects with the values being named the following
    //itemTitle, itemCat, itemSpecs, purchaseDate, itemResult, itemPrice
    @PostMapping("/orders/byUser")
    public List<Order> fetchOrdersByUser(@RequestBody String username){

        //replace return with the array of transactions for the username
        return orderRepository.findAll();
    }

    //Input obj = some object as the transaction obj
    //Return true or false on whether the transaction succecceded or not
    @PostMapping("/insert/order")
    public boolean insertTransaction(@RequestBody Transaction transaction){
        //Call the DAO to insert the transaction

        return true;
    }


}
