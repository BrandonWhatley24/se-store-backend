package store.dao;

public class Inventory {
    
	private int invID;
    private String name;
    private double salePrice;
    private double costForUs;
    private int qtyOnHand;
    private String factory;
    private int turnaround;
    
	public Inventory(int invID, String name, double salePrice, double costForUs, int qtyOnHand, String factory, int turnaround) {
		this.invID = invID;
		this.name = name;
		this.salePrice = salePrice;
		this.costForUs = costForUs;
		this.qtyOnHand = qtyOnHand;
		this.factory = factory;
		this.turnaround = turnaround;
	}
	
	public int getInvID() {
		return invID;
	}
	
	public void setInvID(int invID) {
		this.invID = invID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSalePrice() {
		return salePrice;
	}
	
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	public double getCostForUs() {
		return costForUs;
	}
	
	public void setCostForUs(double costForUs) {
		this.costForUs = costForUs;
	}
	
	public int getQtyOnHand() {
		return qtyOnHand;
	}
	
	public void setQtyOnHand(int qtyOnHand) {
		this.qtyOnHand = qtyOnHand;
	}
	
	public String getFactory() {
		return factory;
	}
	
	public void setFactory(String factory) {
		this.factory = factory;
	}
	
	public int getTurnaround() {
		return turnaround;
	}
	
	public void setTurnaround(int turnaround) {
		this.turnaround = turnaround;
	}
	
    @Override
	public String toString() {
		return "Inventory [invID=" + invID + ", name=" + name + ", salePrice=" + salePrice + ", costForUs=" + costForUs
				+ ", qtyOnHand=" + qtyOnHand + ", factory=" + factory + ", turnaround=" + turnaround + "]";
	}
    
}
