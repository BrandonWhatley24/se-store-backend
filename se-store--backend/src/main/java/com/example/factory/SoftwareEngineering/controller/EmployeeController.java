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

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    // DAOs to call
    CustomerDAO cdao = new CustomerDAO();
    InventoryDAO idao = new InventoryDAO();
    OrderDAO odao = new OrderDAO();

    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

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
        
        String username = login.getUsername();
        String password = login.getPassword();
        
        // DAO call
        Customer cust = cdao.checkPassword(username, password);

        User returnUser = new User();
        returnUser.setUserId(cust.getCustID());
        returnUser.setUsername(cust.getCustUsername());
        returnUser.setFirstName(cust.getCustFName());
        returnUser.setLastName(cust.getCustLName());
        returnUser.setBalance(cust.getCustBalance());

        return returnUser;
    }

    //Input Obj = {'username': 'actual username'}
    //Output = The balance of the user in the form of the double, and
    //If there is no user with that username return -1
    @PostMapping("user/balance")
    public double checkBalance(@RequestBody String username){
        
        Customer cust = cdao.getItem(username);
        
        return Double.parseDouble(cust.getCustBalance());
    }
    

    //Items/Transactions API Calls


    //There is no input for this call
    //You will just return according to the object that it is currently returning.
    @GetMapping("/storeItems")
    public List<StoreItem> fetchStoreItems(){

        List<Inventory> inv = idao.getAll();
        List<StoreItem> returnInv = new ArrayList<StoreItem>(inv.size());

        for(Inventory item : inv){

            StoreItem returnItem = new StoreItem();

            returnItem.setItemId(item.getInvID());
            returnItem.setItemTitle(item.getName());
        //  returnItem.setItemCat(item.get???());
        //  returnItem.getItemSpecs(item.get???());
            returnItem.setItemPrice(item.getSalePrice());
            returnItem.setItemQty(item.getQtyOnHand());

            returnInv.add(returnItem);

        }

        return returnInv;
    }

    @PostMapping("/storeItem/Qty")
    public int checkQty(@RequestBody String itemID){

        int newitemID = Integer.parseInt(itemID);
        
        Inventory item = idao.getItem(newitemID);
        int qty = item.getQtyOnHand();

        return qty;
    }

    @PostMapping("/reorder/item")
    public boolean reorderItem(@RequestBody String itemID){

        int newitemID = Integer.parseInt(itemID);
        
        Inventory inv = idao.getItem(newitemID);
        int qty = inv.getQtyOnHand();
        
        // Something something contact Factory API

        return true;
    }

    //Input obj = {'username': 'the username in question'}
    //Return is going to be an array of objects with the values being named the following
    //itemTitle, itemCat, itemSpecs, purchaseDate, itemResult, itemPrice
    @PostMapping("/orders/byUser")
    public List<Order> fetchOrdersByUser(@RequestBody String username){

        // Getting their ID
        Customer cust = cdao.getItem(username);
        int custID = cust.getCustID();

        // Getting a list of their Orders, given their custID
        List<store.dao.Order> order = odao.getCustOrders(custID);

        // Creating Orders and adding them to a List 
        List<Order> returnOrder = new ArrayList<Order>(order.size());
        for(store.dao.Order ord : order){

            int invID = ord.getInvID();
            String date = dateFormat.format(ord.getOrderDate()); 

            Inventory inv = idao.getItem(invID);
            
            Order returnOrd = new Order();
            returnOrd.setItemTitle(inv.getName());
        //  returnOrd.setItemCat(inv.get???());
        //  returnOrd.setItemSpecs(inv.get???());
            returnOrd.setPurchaseDate(date);
            returnOrd.setItemResult(ord.getStatus());
            returnOrd.setItemPrice(inv.getSalePrice());
            returnOrd.setQty(String.valueOf(ord.getQty()));

            returnOrder.add(returnOrd);
        }

        return returnOrder;
    }

    //Input obj = some object as the transaction obj
    //Return true or false on whether the transaction succeeded or not
    @PostMapping("/insert/order")
    public boolean insertTransaction(@RequestBody Transaction transaction){
        
        //Call the DAO to insert the transaction
        int invID = Integer.parseInt(transaction.getItemId());
        Inventory inv = idao.getItem(invID);
        double price = inv.getSalePrice();
        
        // Something here about connecting to other APIs to check things
        // So we can check turnaround time
        boolean status = Boolean.valueOf(transaction.getResult());
        int qty = transaction.getQty();
        int turnaround = 5;
        if(qty * price > 500 || turnaround >= 7){
            status = false;
        }

        Customer cust = cdao.getItem(transaction.getUser());
        int custID = cust.getCustID();
        
        // If we don't have it and have to order it,
        // And we'll get it in time from the factory,
        // status = true (accepted) && pending = true
        boolean pending = false; 
        if(turnaround > 5){
            pending = true;
        }
        
        // It inserts to the database either way because
        // I remember Mackey saying somewhere that we
        // need to keep track of all orders, accepted && rejected
        store.dao.Order order = new store.dao.Order(custID, invID, qty, status, pending, turnaround);
        odao.insert(order);

        return status;
    }

}
