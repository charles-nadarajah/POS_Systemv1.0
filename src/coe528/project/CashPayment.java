/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author pasindu
 */
public class CashPayment extends Payment {
    private final double balance;
    private final double handingTotal;
    
    
    CashPayment(double totalNetPrice,double handingTotal,int couponNumber) {
        super(totalNetPrice,couponNumber);
        this.handingTotal=handingTotal;
        this.balance=handingTotal-super.getPaymentTotal();
    }

    public double getBalance() {
        return balance;
    }

    public double getHandingTotal() {
        return handingTotal;
    }

    @Override
    public String toString() {
        return super.toString()+"\tPayment Method: Cash"+"\tHanded Total: "+handingTotal+"\bBalance: "+balance;
    }
    
    public boolean repOk(){
        return super.repOk() && !(handingTotal<=0 || balance<0);
    }
    
    
}
