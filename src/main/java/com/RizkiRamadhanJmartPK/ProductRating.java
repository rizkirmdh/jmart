package com.RizkiRamadhanJmartPK;

/**
 * Class ini berfungsi untuk mereturn productRating, rata-rata rating
 * dan total
 */

public class ProductRating
{
    
    private long total;
    private long count;    
    
    public ProductRating()
    {
        // initialise instance variables
        this.total = 0;
        this.count = 0;
    }

    public void insert(int rating)
    {
        this.total += rating;
        this.count++;
    }
    
    public double getAverage()
    {
        if(count == 0) return 0.0;
        return total/count;
    }
    
    public long getCount()
    {
        return count;
    }
    
    public long getTotal()
    {
        return total;
    }
}