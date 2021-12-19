package com.RizkiRamadhanJmartPK.controller;

import com.RizkiRamadhanJmartPK.Algorithm;
import com.RizkiRamadhanJmartPK.Coupon;
import com.RizkiRamadhanJmartPK.dbjson.JSONTable;
import com.RizkiRamadhanJmartPK.dbjson.JsonAutowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class ini sebagai API penguhubung Front-End
 * dan Back-End
 */

@RestController
@RequestMapping("/coupon")
public class CouponController implements BasicGetController<Coupon>{
    @JsonAutowired(value= Coupon.class, filepath = "D:/coupon.json")
    public static JSONTable<Coupon> couponTable;

    @Override
    public JSONTable<Coupon> getJsonTable(){
        return couponTable;
    }

    @RequestMapping(value="/{id}/isUsed", method= RequestMethod.GET)
    boolean isUsed(@PathVariable int id){
        Coupon coupon = Algorithm.<Coupon>find(couponTable, obj -> obj.id == id);
        return coupon.isUsed();
    }

    @RequestMapping(value="/{id}/canApply", method= RequestMethod.GET)
    boolean canApply(@PathVariable int id, @RequestParam double price, @RequestParam double discount){
        Coupon coupon = Algorithm.<Coupon>find(couponTable, obj -> obj.id == id);
        return coupon.canApply(price, discount);
    }

    @RequestMapping(value="/getAvailable", method= RequestMethod.GET)
    List<Coupon> getAvaliable (@RequestParam int page, @RequestParam int pageSize){
        return Algorithm.<Coupon>paginate(couponTable, page, pageSize, obj -> obj.isUsed() == false);
    }


}
