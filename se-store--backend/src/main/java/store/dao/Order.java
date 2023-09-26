package store.dao;

import java.sql.Date;

public class Order {

    private int orderID;
    private int custID;
    private int invID;
    private int qty;
    private boolean status;
    private boolean pending;
    private Date orderDate;
    private Date expectedDate;
    
	public Order(int orderID, int custID, int invID, int qty, boolean status, boolean pending, Date orderDate, Date expectedDate) {
		this.orderID = orderID;
		this.custID = custID;
		this.invID = invID;
		this.qty = qty;
		this.status = status;
		this.pending = pending;
		this.orderDate = orderDate;
		this.expectedDate = expectedDate;
	}
	
	// For creating a new order
	public Order(int custID, int invID, int qty, boolean status, boolean pending, Date expectedDate) {
		this.custID = custID;
		this.invID = invID;
		this.qty = qty;
		this.status = status;
		this.pending = pending;
		this.orderDate = new Date(System.currentTimeMillis());
		
		// FIGURE THIS OUT
		this.expectedDate = expectedDate;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public int getInvID() {
		return invID;
	}

	public void setInvID(int invID) {
		this.invID = invID;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(Date expectedDate) {
		this.expectedDate = expectedDate;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", custID=" + custID + ", invID=" + invID + ", qty=" + qty + ", status="
				+ status + ", pending=" + pending + ", orderDate=" + orderDate + ", expectedDate=" + expectedDate + "]";
	}
    
}
