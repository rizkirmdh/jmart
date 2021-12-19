package com.RizkiRamadhanJmartPK.controller;

import com.RizkiRamadhanJmartPK.*;
import com.RizkiRamadhanJmartPK.dbjson.JSONTable;
import com.RizkiRamadhanJmartPK.dbjson.JsonAutowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class ini sebagai API penguhubung Front-End
 * dan Back-End
 */

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{
    public static final long DELIVERED_LIMIT_MS = 1;
    public static final long ON_DELIVERY_LIMIT_MS = 2;
    public static final long ON_PROGRESS_LIMIT_MS = 3;
    public static final long WAITING_CONF_LIMIT_MS = 4;

    @JsonAutowired(value= Payment.class, filepath = "D:/payment.json")
    public static JSONTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread;

    @Override
    public JSONTable<Payment> getJsonTable(){
        return paymentTable;
    }

    @RequestMapping(value="/{id}/accept", method= RequestMethod.POST)
    boolean accept(@PathVariable int id){

        Payment payment = Algorithm.<Payment>find(paymentTable, obj -> obj.buyerId == id);
        int lastElement = payment.history.size();
        if(payment != null && payment.history.get(lastElement).status == Invoice.Status.WAITING_CONFIRMATION){
            payment.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, "Sedang diproses..."));
            return true;
        }
        else {
            return false;
        }
    }

    @RequestMapping(value="/{id}/cancel", method= RequestMethod.POST)
    boolean cancel(@PathVariable int id){

        Payment payment = Algorithm.<Payment>find(paymentTable, obj -> obj.buyerId == id);
        int lastElement = payment.history.size();
        if(payment != null && payment.history.get(lastElement).status == Invoice.Status.WAITING_CONFIRMATION){
            payment.history.add(new Payment.Record(Invoice.Status.CANCELLED, "Dibatalkan..."));
            return true;
        }
        else {
            return false;
        }
    }

    @RequestMapping(value="/create", method= RequestMethod.POST)
    Payment create(@PathVariable int buyerId, @PathVariable int productId, @RequestParam int productCount, @RequestParam String shipmentAddress, @RequestParam byte shipmentPlan){
        Payment payment = Algorithm.<Payment>find(paymentTable, obj -> obj.buyerId == buyerId && obj.productId == productId);
        Account acc = Algorithm.<Account>find(AccountController.accountTable, obj -> obj.id == payment.buyerId);
        Product prod = Algorithm.<Product>find(ProductController.productTable, obj -> obj.id == payment.productId);

        double price = payment.getTotalPay(prod);

        payment.shipment.cost = 0;
        payment.shipment.receipt = null;

        if (acc.balance >= price){
            acc.balance = acc.balance - price;
            payment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "Menunggu Konfirmasi..."));
            paymentTable.add(payment);
            return payment;
        }
        else {
            return null;
        }
    }

    @RequestMapping(value="/{id}/submit", method= RequestMethod.POST)
    boolean submit(@PathVariable int id, @RequestParam String receipt){

        Payment payment = Algorithm.<Payment>find(paymentTable, obj -> obj.buyerId == id);
        int lastElement = payment.history.size();
        if(payment != null && payment.history.get(lastElement).status == Invoice.Status.ON_PROGRESS && !receipt.isBlank()){
            payment.shipment.receipt = payment.shipment.receipt + receipt;
            payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "Sedang diperjalanan..."));
            return true;
        }
        else {
            return false;
        }
    }
}
