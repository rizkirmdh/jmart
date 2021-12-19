package com.RizkiRamadhanJmartPK;

import java.util.*;
import java.util.Date;
import java.util.Calendar;

/**
 * Class ini berfungsi untuk menerima fitur fitur dari payment
 * seperti buyerId, productId, metode shipment, dan memberikan
 * total pay
 */

public class Payment extends Invoice{
     public ArrayList<Record> history = new ArrayList<Record>();
     public int productCount;
     public Shipment shipment;
     
    public Payment (int buyerId, int productId, int productCount, Shipment shipment)
    {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }
    
    public double getTotalPay(Product product)
    {
        return product.price * product.discount;
    }

/**
 * Class ini berfungsi untuk menerima input tanggal, pesan, dan
 * status
 */

    public static class Record
    {
        public final Date date;
        public String message;
        public Status status;

        public Record(Status status, String message) {
            this.message = message;
            this.status = status;
            this.date = Calendar.getInstance().getTime();
        }
    }
}