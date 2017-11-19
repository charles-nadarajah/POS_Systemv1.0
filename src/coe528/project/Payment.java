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
public abstract class Payment {
    private final double paymentTotal;
    private final int couponNumber;

    public Payment(double totalNetPrice, int couponNumber) {
        this.paymentTotal = applyDiscount(totalNetPrice, couponNumber);
        this.couponNumber=couponNumber;
    }

    private double applyDiscount(double totalNetPrice, int couponNumber) {
        int[][] coupons=POS_System.getCoupons();
        for (int i = 0; i < coupons[0].length; i++) {
            if(couponNumber==coupons[0][i]){
                return totalNetPrice*(100.0-(double)coupons[1][i])/100.0;
            }
        }
        return totalNetPrice;
    }

    public double getPaymentTotal() {
        return paymentTotal;
    }

    public int getCouponNumber() {
        return couponNumber;
    }

    @Override
    public String toString() {
        String temp="";
        if(couponNumber!=0) temp="Coupon Number: "+couponNumber;
        return temp+"\tPayment Total: "+paymentTotal;
    }
    
    public boolean repOk(){
        return !(couponNumber<0 || paymentTotal<=0);
    }
    
    
    
}
