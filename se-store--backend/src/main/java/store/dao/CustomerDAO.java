package store.dao;

import store.sec.Parms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class CustomerDAO implements DataAccess<Customer>{
   
	Connection con;
    PreparedStatement pstmt;
        
    String dbuser = Parms.dbuser;
    String dbpass = Parms.dbpass;
    String dburl = Parms.dburl;
    
    String driver = "org.postgresql.Driver";
	
    /*  
	public static void main(String[] args) {
	  
		CustomerDAO cdao = new CustomerDAO(); List<Customer> list = cdao.getAll();
		for(Customer cust : list) { System.out.println(cust); }
		  
		int id = 10001; 
		Customer cust = cdao.getItem(id); 
		System.out.println(cust);
		
		String username = "USERA";
		String password = "testpass1";
		System.out.println("Login = " + checkPassword(username, password));
		  
	}
	*/
    
    // Returns a List of ALL Customers
    public List<Customer> getAll(){
        
        List<Customer> list = new LinkedList<Customer>();
        
        try{
            Class.forName(driver);    
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
            
            String sql = "SELECT * FROM STOREDB.CUSTOMERS";

            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();             
            
            while(rs.next()){
                Customer cust = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(cust);
            }
            
            con.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return list;
    }
    
    // Returns a Customer object given a custID
    public Customer getItem(int key) {
        
        Customer cust = null;
        
        try{
            Class.forName(driver);            
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
            
            String sql = "SELECT * FROM STOREDB.CUSTOMERS WHERE CUSTOMER_ID = (?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, key);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
            	cust = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            
            con.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return cust;       
    }

    // Returns a Customer object given a custUsername
    public Customer getItem(String username) {
        
        Customer cust = null;
        
        try{
            Class.forName(driver);            
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
            
            String sql = "SELECT * FROM STOREDB.CUSTOMERS WHERE USERNAME = (?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
            	cust = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            
            con.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return cust;       
    }
    
    // Returns a Customer object given a username and password
    public Customer checkPassword(String username, String password) {
        
        Customer cust = new Customer(-1, "", "", "", "");
        
        try{
            Class.forName(driver);            
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
            
            String sql = "SELECT * FROM STOREDB.CUSTOMERS WHERE USERNAME = (?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
            	cust = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            
            con.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return cust;
        
    }  
    
    public void update(Customer item){
         
    }
    
    public void delete(Customer item){
        
    }
    
    public void insert(Customer item){
        
    }
    
}
