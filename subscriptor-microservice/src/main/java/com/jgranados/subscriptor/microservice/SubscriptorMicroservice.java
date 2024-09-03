/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jgranados.subscriptor.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author jose
 */
@SpringBootApplication
@EnableTransactionManagement
public class SubscriptorMicroservice {

    public static void main(String[] args) {
		SpringApplication.run(SubscriptorMicroservice.class, args);
	}
}
