/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**

/**
 *
 * @author Charles
 */
import java.util.*;
        
public class Manager extends User{
    
    public Manager(String username, String password)
    {
        super(username,password);
    }
    
    public void viewInventory()
    {
        
    }
    
    /*
        This method will modify a menu items price
    */
 
    public void Modify_Pricing(MenuItem item1, double newPrice)
    {
        item1.setPrice(newPrice);
    }
    
    /*
        Increase / decrease quantity of a menu item
    */
    public void Add_Inventory(MenuItem item1, int newQuantity)
    {
        item1.setQuantity(newQuantity);
    }
    
    /*
        Setting the quantity to 0 will remove the menu item
    */
    
    public void RemoveInventory(MenuItem item1)
    {
        item1.setQuantity(0);
    }
    
    /*
        this method will print out the transactions for the entire store that day
    */
    
    public void ViewTransactions(ArrayList<Transaction> list)
    {
        for (Transaction t: list)
        {
            System.out.println(t.toString());
        }
    }
    
    /*
        add a new coupon to the coupon 2-D array
    */
    
    public int addCoupon(int coupon_number, double discountvalue)
    {
       
    }
      
    //Implements Representation Invariant of class Manager
    public boolean repOK(){
        if(this.username.equals("admin")== false)
            return false;
        
        if(this.password.equals("admin")== false) 
           return false;
    
        return true;
    }
     
}
