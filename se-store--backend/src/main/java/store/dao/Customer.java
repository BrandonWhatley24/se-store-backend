package store.dao;

public class Customer {    
    
    private int custID;
    private String custUsername;
    private String custPass;
    private String custFName;
    private String custLName;
	private String custBalance;
    
    public Customer(int custID, String custUsername, String custPass, String custFName, String custLName, String custBalance) {
        this.custID = custID;
        this.custUsername = custUsername;
        this.custPass = custPass;
        this.custFName = custFName;
        this.custLName = custLName;
		this.custBalance = custBalance;
    }

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getCustUsername() {
		return custUsername;
	}

	public void setCustUsername(String custUsername) {
		this.custUsername = custUsername;
	}

	public String getCustFName() {
		return custFName;
	}

	public void setCustFName(String custFName) {
		this.custFName = custFName;
	}

	public String getCustLName() {
		return custLName;
	}

	public void setCustLName(String custLName) {
		this.custLName = custLName;
	}

	public String getCustPass() {
		return custPass;
	}

	public void setCustPass(String custPass) {
		this.custPass = custPass;
	}

	public String getCustBalance() {
		return custBalance;
	}

	public void setCustBalance(String custBalance) {
		this.custBalance = custBalance;
	}

	@Override
	public String toString() {
		return "Customer [custID=" + custID + ", custUsername=" + custUsername + ", custPass=" + custPass
				+ ", custFName=" + custFName + ", custLName=" + custLName + "]";
	}

}
