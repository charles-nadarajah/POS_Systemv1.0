/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.util.ArrayList;

/**
 *
 * @author Deshan
 */
class Customer extends User{
    private static int membershipcount_id;
    private int membership_id;
    private ArrayList<Transaction> transaction_list;
    private ArrayList<MenuItem> basket;
    
    /**
     * Constructor: Assigns Username, Password, and Membership ID
     * @param username  Customer's Username.
     * @param password  Customer's Password.
     */
    public Customer(String username, String password){
        //Setting Customer's Username and Password
        super(username, password);
        //Assigning a Membership ID
        this.membership_id = ++membershipcount_id;
        
    }
    
    /**
     * Adds menu item to basket
     * @param item  Menu item to be added to basket. 
     */
    public void add_to_basket(MenuItem item){
        basket.add(item);
    }
    
    /**
     * Removes item from basket
     * @param item  Menu item to be removed from basket. 
     */
    public void remove_from_basket(MenuItem item){
        basket.remove(item);
    }
    
    /**
     * Prints all menu items in basket and their prices
     */
    public void viewBasket(){
        String temp = "";
        for (MenuItem t:basket) {
            temp += t.getName()+": $" + t.getPrice() + "\n";
        }
        System.out.println(temp);
    } 
    
    /**
     * Overrides getUserName() method of User class
     * @return username
     */
    @Override
    public String getUserName(){
        return super.getUserName();
    }
    
    /**
     * Overrides getPassword() method of User class
     * @return password
     */
    @Override
    protected String getPassword(){
        return super.getPassword();
    }
    
    /**
     * Returns Customer's Membership ID
     * @return membership_id
     */
    public int getMembershipId(){
        return membership_id;
    }
    
    /**
     * Returns Customer's all transactions
     * @return transaction_list
     */
    public ArrayList<Transaction> getTransactions(){
        return transaction_list;
    }
    
    //Implements Representation Invariant of class Customer
    public boolean repOk(){
        if(super.getUserName()==null) return false;
        if(super.getPassword()==null) return false;
        if(membership_id<=0) return false;
        if(transaction_list == null) return false;
        if(transaction_list.isEmpty()) return false;
        return true;
    }
    
    /**
     * Overrides toString() method of Object Class. Returns Customer's Username,
     * Membership ID, and all Transactions
     * @return username, membership_id, transaction_list 
     */
    @Override
    public String toString(){
        return getUserName() + "\nMembership ID: " + getMembershipId() + "\nTransactions:\n\t" + transaction_list.toString();
    }
}
