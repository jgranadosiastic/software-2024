/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.application.subscribingtoauthorusecase;

import com.jgranados.subscriptor.microservice.subscription.domain.Subscription;
import com.jgranados.subscriptor.microservice.subscriptor.domain.Subscriptor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionRequest {
    private String authorEmail;
    
    public Subscription convertToDomain(Subscriptor subscriptor) {
        Subscription subscription = new Subscription();
        subscription.setAuthorEmail(authorEmail);
        subscription.setSubscriptor(subscriptor);
        
        return subscription;
    }
}
