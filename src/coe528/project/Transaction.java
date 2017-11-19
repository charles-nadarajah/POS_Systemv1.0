/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.ArrayList;

/**
 *
 * @author pasindu
 */
public class Transaction {
    private static int transactionCounter=0;
    
    private final int transactionId;
    private final Customer customer;
    private final ArrayList<MenuItem> menuItemsBought;
    private final double totalNetPrice;
    private Payment payment;

    private Transaction(Customer customer, ArrayList<MenuItem> menuItemsBought) {
        //Setting TransactionId
        this.transactionId=++transactionCounter;
        //Setting Customer
        this.customer = customer;
        //Setting the selected menuitems
        this.menuItemsBought=menuItemsBought;
        
        //Calculating Total Price without discount
        double temp=0;
        for (MenuItem m:this.menuItemsBought) {
            temp+=m.getPrice()*(double)m.getQuantity();
        }
        this.totalNetPrice=temp;
    }
    
    public Transaction(Customer customer, ArrayList<MenuItem> menuItemsBought, String creditCardNumber, int couponNumber) {
        this(customer,menuItemsBought);
        
        //Setting the payment
        this.payment=new CreditPayment(this.totalNetPrice,creditCardNumber,couponNumber);
        
    }
    
    public Transaction(Customer customer, ArrayList<MenuItem> menuItemsBought, double handingTotal,int couponNumber) {
        this(customer,menuItemsBought);
        
        //Setting the payment
        this.payment=new CashPayment(this.totalNetPrice,handingTotal,couponNumber);
        
    }

    public static int getTransactionCounter() {
        return transactionCounter;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<MenuItem> getMenuItemsBought() {
        return menuItemsBought;
    }

    public double getTotalNetPrice() {
        return totalNetPrice;
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        
        String listMenuItemsBought="{";
        for (MenuItem m:this.menuItemsBought) {
            listMenuItemsBought+=m.getName()+", ";
        }
        listMenuItemsBought+="\b\b}";
        
        return "Transaction ID: "+transactionId+"\tCustomer Username: "+customer.getUserName()+"\tItems Bought: "+listMenuItemsBought+
                "\tTotal Net Price"+totalNetPrice+"\t"+payment.toString();
    }
    
    
    public boolean repOK(){
        if(transactionCounter<=0) return false;
        if(transactionId<=0) return false;
        if(customer==null) return false;
        if(menuItemsBought==null) return false;
        if(menuItemsBought.isEmpty()) return false;
        if(totalNetPrice<=0.0) return false;        
        if(payment==null) return false;
                
        return true;
    }
  

  
    

    
    
}
