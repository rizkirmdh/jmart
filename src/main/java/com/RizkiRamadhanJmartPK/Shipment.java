package com.RizkiRamadhanJmartPK;

import java.text.*;
import java.util.Date;
import java.util.Calendar;

/**
 * Class ini berfungsi menerima input fitur-fitur dari shipment
 * seperti alamat, biaya, resi, dan menentukan aproksimasi barang sampai ke tujuan
 */

public class Shipment
{
    public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    public static final Plan INSTANT  = new Plan((byte)(1<<0));
    public static final Plan SAME_DAY = new Plan((byte)(1<<1));
    public static final Plan NEXT_DAY = new Plan((byte)(1<<2));
    public static final Plan REGULER  = new Plan((byte)(1<<3));
    public static final Plan KARGO    = new Plan((byte)(1<<4));
    public String address;
    public int cost;
    public byte plan;
    public static String receipt;
    
    public Shipment(String address, int cost, byte plan, String receipt )
    {
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }

    public String getEstimatedArrival(Date reference) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(reference);
        if(INSTANT.bit == Plan.INSTANT.bit || SAME_DAY.bit == Plan.SAME_DAY.bit) {
            calendar.add(Calendar.DATE, 0);
            return ESTIMATION_FORMAT.format(calendar.getTime());
        }
        else if(NEXT_DAY.bit == Plan.NEXT_DAY.bit) {
            calendar.add(Calendar.DATE, 1);
            return ESTIMATION_FORMAT.format(calendar.getTime());
        }
        else if(REGULER.bit == Plan.REGULER.bit) {
            calendar.add(Calendar.DATE, 2);
            return ESTIMATION_FORMAT.format(calendar.getTime());
        }
        else if(KARGO.bit == Plan.KARGO.bit) {
            calendar.add(Calendar.DATE, 5);
            return ESTIMATION_FORMAT.format(calendar.getTime());
        }
        else
            return ESTIMATION_FORMAT.format(calendar.getTime());
    }

    public boolean isDuration(Plan reference)
    {
        if (reference.bit != 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean isDuration(byte object, Plan reference)
    {
        if ((reference.bit & object) != 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static class Plan{
        public static final Plan INSTANT  = new Plan((byte) (1<<0));
        public static final Plan SAME_DAY = new Plan((byte) (1<<1));
        public static final Plan NEXT_DAY = new Plan((byte) (1<<2));
        public static final Plan REGULER  = new Plan((byte) (1<<3));
        public static final Plan KARGO    = new Plan((byte) (1<<4));
        public final byte bit;

        private Plan(byte bit) {
            this.bit = bit;
        }
    }

    public class MultiDuration{
        public byte bit;

        public MultiDuration(Plan... args)
        {
            byte save = 0;
            for (Plan x: args){
                save = (byte) (save | x.bit);
            }
            bit = save;
        }
    }

    public boolean read(String content){
        return false;
    }

    public Object write(){
        return null;
    }

}


