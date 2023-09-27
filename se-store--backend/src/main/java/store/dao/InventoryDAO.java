package store.dao;

import store.sec.Parms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class InventoryDAO implements DataAccess<Inventory> {
    
	Connection con;
    PreparedStatement pstmt;
    
    String dbuser = Parms.dbuser;
    String dbpass = Parms.dbpass;
    String dburl = Parms.dburl;
    
    String driver = "org.postgresql.Driver";
    
/*    
	public static void main(String[] args) {
		  
		InventoryDAO idao = new InventoryDAO(); 
		List<Inventory> list = idao.getAll();
		
		for(Inventory inv : list) { 
			System.out.println(inv); 
		}
		  
		int id = 30001; 
		Inventory inv = idao.getItem(id);
		System.out.println(inv);
		
		idao.updateQtyOnHand(id, 5);
		inv = idao.getItem(id);
		System.out.println(inv);
		
		idao.updateQtyOnHand(id, -5);
		inv = idao.getItem(id);
		System.out.println(inv);
	}
*/
	
    // Returns a List of ALL Inventory
    public List<Inventory> getAll(){
        
        List<Inventory> list = new LinkedList<Inventory>();
        
        try{
            Class.forName(driver);        
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
        
            String sql = "SELECT * FROM STOREDB.INVENTORY";

            pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                Inventory inv = new Inventory(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
                list.add(inv);
            }
            
            con.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return list;
    }
    
    // Returns an Inventory object given its INV_ID
    public Inventory getItem(int key){
        
        Inventory inv = null;
        
        try{
            Class.forName(driver);    
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
            
            String sql = "SELECT * FROM STOREDB.INVENTORY WHERE INV_ID = (?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, key);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                inv = new Inventory(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
            }
                           
            con.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return inv;       
    }
    
    public void update(Inventory item){
         
    }
    
    // Used to change an item's "qty_on_hand" (ONLY if this item's "status" is true)
    // ADDS by default (when factory shipment comes in)
    // Pass a negative value to represent a quantity sold
    public void updateQtyOnHand(int invID, int qty){
        
    	try{
            Class.forName(driver);                
            con = DriverManager.getConnection(dburl, dbuser, dbpass);
            
            String sql = "UPDATE STOREDB.INVENTORY SET QTY_ON_HAND = QTY_ON_HAND + (?) WHERE INV_ID = (?)";
        	
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, qty);
            pstmt.setInt(2, invID);
            pstmt.execute();
            
            con.close();
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    	
    }
    
    public void delete(Inventory item){

    }
    
    public void insert(Inventory item){
    	
    }
}
