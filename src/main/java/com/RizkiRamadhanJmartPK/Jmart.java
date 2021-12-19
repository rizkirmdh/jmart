package com.RizkiRamadhanJmartPK;

import  com.RizkiRamadhanJmartPK.dbjson.JSONDBEngine;
import  org.springframework.boot.SpringApplication;
import  org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jmart
{
    public static void main(String[] args) {
        JSONDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JSONDBEngine.join()));
    }
}