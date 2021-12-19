package com.RizkiRamadhanJmartPK;

/**
 * Class ini berfungsi untuk top up nomor pengguna dan return
 * totalPay
 */

public class PhoneTopUp extends Invoice{

    public String phoneNumber;
    public Status status;

    public PhoneTopUp(int buyerId, int productId, String phoneNumber)
    {
        super(buyerId, productId);
        this.phoneNumber = phoneNumber;
    }

    public double getTotalPay(Product product)
    {
        return product.price * product.discount;
    }

}
