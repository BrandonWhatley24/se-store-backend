package store.dao;

public class Customer {    
    
    private int custID;
    private String custFName;
    private String custLName;
    private String custPass;
    
    public Customer(int custID, String custFName, String custLName, String custPass) {
        this.custID = custID;
        this.custFName = custFName;
        this.custLName = custLName;
        this.custPass = custPass;
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
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

    @Override
    public String toString() {
        return "Customer [custID=" + custID + ", custFName=" + custFName + ", custLName=" + custLName + ", custPass="
                + custPass + "]";
    }

}
