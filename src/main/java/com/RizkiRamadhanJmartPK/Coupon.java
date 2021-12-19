package com.RizkiRamadhanJmartPK;

import com.RizkiRamadhanJmartPK.dbjson.Serializable;

/**
 * Class ini berfungsi untuk menerima complaint pada tanggal
 * hari tersebut dan ditampilkan melalui string
 */

public class Coupon extends Serializable{

    enum Type{
        DISCOUNT,
        REBATE
    }

    // instance variables 
    public final String name;
    public final int code;
    public final double cut;
    public final Type type;
    public final double minimum;
    private boolean used;
    
    public Coupon(String name, int code, Type type, double cut, double minimum)
    {
        // initialise instance variables
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }
    
    public boolean isUsed()
    {
        return this.used;
    }
    
    public boolean canApply(double price, double discount)
    {
        double adminFee;
        double cut = price * discount / 100.0;
        double discountedPrice = price - cut;
        if (discountedPrice < Treasury.BOTTOM_FEE)
            adminFee = Treasury.BOTTOM_FEE;
        adminFee = discountedPrice * Treasury.COMMISSION_MULTIPLIER;

        double adjustedPrice = discountedPrice + adminFee;

        if ( used == false && adjustedPrice >= minimum ){
            return true;
        }
        else {
            return false;
        }
    }
    
    public double apply(Treasury priceTag)
    {
        this.used = true;
        if(type == Type.DISCOUNT)
        {
            return priceTag.getAdjustedPrice(0.0, 0.0)*(100-cut)/100;
        }
        else 
        {
            return priceTag.getAdjustedPrice(0.0, 0.0) - cut; // karena potongan harga setara dengan PriceTag.price
        }
    }
}












