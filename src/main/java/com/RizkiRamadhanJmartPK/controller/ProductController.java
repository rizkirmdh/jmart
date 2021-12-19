package com.RizkiRamadhanJmartPK.controller;

import com.RizkiRamadhanJmartPK.Account;
import com.RizkiRamadhanJmartPK.Algorithm;
import com.RizkiRamadhanJmartPK.Product;
import com.RizkiRamadhanJmartPK.ProductCategory;
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
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>
{
    @JsonAutowired(value= Product.class, filepath = "D:/product.json")
    public static JSONTable<Product> productTable;

    @Override
    public JSONTable<Product> getJsonTable(){
        return productTable;
    }

    @RequestMapping(value="/{id}/store", method= RequestMethod.GET)
    List<Product> getProductByStore(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize){
        return Algorithm.<Product>paginate(productTable, page, pageSize, obj -> obj.accountId == id);
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    Product create
            (
                    @PathVariable int id,
                    @RequestParam String name,
                    @RequestParam int weight,
                    @RequestParam boolean conditionUsed,
                    @RequestParam double price,
                    @RequestParam double discount,
                    @RequestParam ProductCategory category,
                    @RequestParam byte shipmentPlans
            )
    {
        Product prod = Algorithm.<Product>find(productTable, obj -> obj.accountId == id);
        Account acc = Algorithm.<Account>find(AccountController.accountTable, obj -> obj.id == prod.accountId);
        if(prod != null && acc.store != null){
            productTable.add(prod);
            return prod;
        }
        else {
            return null;
        }
    }

    @RequestMapping(value="/getFiltered", method= RequestMethod.GET)
    List<Product> getProductFiltered
            (
                    @RequestParam int page,
                    @RequestParam int pageSize,
                    @PathVariable int accountId,
                    @RequestParam String search,
                    @RequestParam int minPrice,
                    @RequestParam int maxPrice,
                    @RequestParam ProductCategory category
            )
    {
        List<Product> prod = Algorithm.<Product>collect(productTable, obj -> obj.accountId == accountId && obj.name == search && obj.category == category);
        if (minPrice <= 0){
            return Algorithm.<Product>paginate(prod, page, pageSize, obj -> obj.price <= maxPrice);
        }
        else if (maxPrice <= 0){
            return Algorithm.<Product>paginate(prod, page, pageSize, obj -> obj.price >= minPrice);
        }
        else{
            return Algorithm.<Product>paginate(prod, page, pageSize, obj -> obj.price <= maxPrice && obj.price >= minPrice);
        }

    }
}
