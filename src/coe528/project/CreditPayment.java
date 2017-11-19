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
public class CreditPayment extends Payment {
    private final String creditCardNumber;

    CreditPayment(double totalNetPrice,String creditCardNumber,int couponNumber) {
        super(totalNetPrice,couponNumber);
        this.creditCardNumber=creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @Override
    public String toString() {
        return super.toString()+"Payment Method: Credit"+"\b Credit Card #: "+creditCardNumber;
    }
    
    public boolean repOk(){
        return super.repOk() && !(creditCardNumber==null);
    }
    
    
}
