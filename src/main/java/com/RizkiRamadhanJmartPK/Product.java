package com.RizkiRamadhanJmartPK;

import com.RizkiRamadhanJmartPK.dbjson.Serializable;

/**
 * Class ini berfungsi untuk menerima inputan fotur-fitur dari product
 * dan return string product
 */

public class Product extends Serializable{
    public int accountId;
    public ProductCategory category;
    public boolean conditionUsed;
    public double discount;
    public String name;
    public double price;
    public byte shipmentPlans;
    public int weight;
    
    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans)
    {
        this.accountId = accountId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.category = category;
        this.shipmentPlans = shipmentPlans;
    }
    public boolean read(String content){
        return false;
    }

    public Object write(){
        return null;
    }

    public String toString()
    {
        String data = "Name: "+ this.name +
                      "\nstoreId : " + this.accountId +
                      "\nWeight : " + this.weight +
                      "\nconditionUsed: " + this.conditionUsed +
                      "\npriceTag : " + this.price +
                      "\ncategory : " + this.category +
                      "\nshipmentPlan : " +this.shipmentPlans;
        return data;
    }
}