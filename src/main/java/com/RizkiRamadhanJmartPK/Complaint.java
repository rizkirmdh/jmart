package com.RizkiRamadhanJmartPK;

import com.RizkiRamadhanJmartPK.dbjson.Serializable;
import java.util.Date;
import java.util.Calendar;
import java.text.*;

/**
 * Class ini berfungsi untuk menerima complaint pada tanggal
 * hari tersebut dan ditampilkan melalui string
 */

public class Complaint extends Serializable
{
    Calendar calendar = Calendar.getInstance();
    public Date date = calendar.getTime();
    public String desc;
    
    public Complaint(String desc)
    {
        this.desc = desc;
    }

    @Override
    public String toString()
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	String tanggal = sdf.format(date);
        String complaint = "Complaint{date=" + tanggal + ", desc='"+ this.desc + "'}";
        return complaint;
    }
}



