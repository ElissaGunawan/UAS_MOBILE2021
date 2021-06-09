package umn.ac.id.uasproject;

public class HistoryModel {
    private String Transaction_id;
    private String Customer_id;
    private String Date;
    private int Payment;
    private String Status;

    private HistoryModel(){}

    private HistoryModel(String Transaction_id, String Customer_id, String Date, int Payment, String Status){
        this.Transaction_id = Transaction_id;
        this.Customer_id = Customer_id;
        this.Date = Date;
        this.Payment = Payment;
        this.Status = Status;
    }

    public String getTransaction_id() {
        return Transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        Transaction_id = transaction_id;
    }

    public String getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(String customer_id) {
        Customer_id = customer_id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getPayment() {
        return Payment;
    }

    public void setPayment(int payment) {
        Payment = payment;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}