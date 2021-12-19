package com.RizkiRamadhanJmartPK;

import com.RizkiRamadhanJmartPK.dbjson.Serializable;
import java.util.regex.*;

/**
 * Class ini berfungsi untuk menerima inputan data akun
 * dan mengecek regex email dan pasword
 */

public class Account extends Serializable{

    public static final String REGEX_EMAIL    = "(?!.\\.{2,})(?!\\.)[0-9A-z.&~*]+@\\w+([.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{7,}$";
    public String name;
    public String email;
    public String password;
    public Store store;
    public int accountId;
    public double balance;

    public Account(String name, String email, String password, double balance)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    public String toString(){
        return "name: " + this.name + "\nemail: " + this.email + "\npassword: " + this.password;
    }

    public boolean validate() {
		Pattern pattern = Pattern.compile(REGEX_EMAIL);
		Matcher matcher = pattern.matcher(email);
		boolean foundEmail = matcher.find();
		
		Pattern pattern2 = Pattern.compile(REGEX_PASSWORD);
		Matcher matcher2 = pattern2.matcher(password);
		boolean foundPassword = matcher2.find();

        if (foundEmail == true && foundPassword == true) {
            return true;
        }
        else {
            return false;
        }
	}
}