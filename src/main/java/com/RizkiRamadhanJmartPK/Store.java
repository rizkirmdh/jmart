package com.RizkiRamadhanJmartPK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class ini berfungsi menerima input data store seperti nama, alamat,
 * nomor hp, balance dan validasi nama dan nomor hp
 */

public class Store
{
    public final String REGEX_PHONE = "[0-9]{9,12}";
    public final String REGEX_NAME = "(?!.*[ ]{2})[A-Z][A-Za-z0-9 ]{3,18}[A-Za-z0-9]$";
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;

    public Store(String name, String address, String phoneNumber, double balance)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    public boolean read(String objek)
    {
        return false;
    }
    
    public String toString()
    {
        String data = "name: "+ this.name +
                      "\naddress: " + this.address +
                      "\nphoneNumber: " + this.phoneNumber;
        return data;
    }
    public boolean validate() {
		Pattern pattern = Pattern.compile(REGEX_NAME);
		Matcher matcher = pattern.matcher(name);
		boolean foundName = matcher.find();
		
		Pattern pattern2 = Pattern.compile(REGEX_PHONE);
		Matcher matcher2 = pattern2.matcher(phoneNumber);
		boolean foundPhone = matcher2.find();

        if (foundName == true && foundPhone == true) {
            return true;
        }
        else {
            return false;
        }
	}
}