package com.RizkiRamadhanJmartPK;

/**
 * Class ini berfungsi untuk memberikan return biaya diadjusted,
 * biaya admin, dan biaya yang sudah diberikan diskon
 */

public class Treasury {
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;

    public Treasury(double price)
    {
        this.price = price;
        this.discount = 0.0;
    }
    public Treasury(double price, double discount)
    {
        this.price = price;
        this.discount = discount;
    }

    public double getAdjustedPrice(double price, double discount)
    {
        return getDiscountedPrice(0.0, 0.0) + getAdminFee(0.0, 0.0);
    }

    public double getAdminFee(double price, double discount)
    {
        double discountedPrice = getDiscountedPrice(0.0, 0.0);
        if(discountedPrice < BOTTOM_PRICE)
            return BOTTOM_FEE;
        return discountedPrice * COMMISSION_MULTIPLIER;
    }

    private double getDiscountedPrice(double price, double discount)
    {
        if(discount > 100.0)
        {
            discount = 100.0;
            return 0.0;
        }
        else if(discount == 100.0)
        {
            return 0.0;
        }
        else
            return price - ((price*discount)/100.0);
    }
}
