package com.RizkiRamadhanJmartPK;

import com.RizkiRamadhanJmartPK.dbjson.Serializable;
import java.util.Date;
import java.util.Calendar;

/**
 *Class ini berfungsi untuk menerima buyerId, productId, complainId, tanggal
 * rating, dan total biaya yang harus dibayar
 */

public class Invoice extends Serializable
{
    public enum Rating
    {
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    public enum Status
    {
        CANCELLED,
        COMPLAINT,
        DELIVERED,
        FAILED,
        FINISHED,
        ON_PROGRESS,
        ON_DELIVERY,
        WAITING_CONFIRMATION
    }

    public int buyerId;
    public int complaintId = -1;
    public final Date date;
    public int productId;
    public Rating rating = Rating.NONE;
    public Status status = Status.WAITING_CONFIRMATION;
    
    public Invoice(int buyerId, int productId)
    {
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = Calendar.getInstance().getTime();
    }
    
    public double getTotalPay(Product product)
    {
        return product.price * product.discount;
    }
}