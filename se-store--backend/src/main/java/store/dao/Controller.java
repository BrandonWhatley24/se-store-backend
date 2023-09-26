package store.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
 @Autowired
 private CustomerDAO cdao;
 private InventoryDAO idao;
 private OrderDAO odao;
 

 // Returns a List of all Customers
 @GetMapping("/customer/getAll")
 public List<Customer> getAllCustomers() {
    return cdao.getAll();
 }
 
 // Returns a Customer item, given a CustomerID
 @GetMapping("/customer/getItem")
 public Customer getCustomer(int key) {
	return cdao.getItem(key);
 }
 
 // Returns a List of all Inventory
 @GetMapping("/inventory/getAll")
 public List<Inventory> getAllInventory() {
    return idao.getAll();
 }
 
 // Returns an Inventory item, given an InvID
 @GetMapping("/inventory/getItem")
 public Inventory get(int key) {
    return idao.getItem(key);
 }
 
 // Updates the qty, given an InvID
 @GetMapping("/inventory/updateQty")
 public void updateQtyOnHand(int invID, int qty){
    idao.updateQtyOnHand(invID, qty);
 } 

 // Returns a List of all Orders
 @GetMapping("/order/getAll")
 public List<Order> getAllOrders() {
    return odao.getAll();
 }
 
 // Returns a List of all Orders belonging to a specific Customer, given an CustomerID
 @GetMapping("/order/getCustOrders")
 public List<Order> getCustOrders(int key){
    return odao.getCustOrders(key);
 }
 
 // Returns an Order item, given an OrderID
 @GetMapping("/order/getItem")
 public Order getOrder(int key) {
	return odao.getItem(key);
 }
 
 // Inserts an Order, given an Order item
 @GetMapping("/order/insert")
 public void insert(Order item){
     odao.insert(item);
 }
}
