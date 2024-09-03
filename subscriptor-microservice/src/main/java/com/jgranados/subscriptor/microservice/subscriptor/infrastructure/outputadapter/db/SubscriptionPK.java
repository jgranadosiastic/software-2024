/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputadapter.db;

import com.jgranados.subscriptor.microservice.subscription.domain.Subscription;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Getter
@Setter
public class SubscriptionPK implements Serializable {
    private String authorEmail;
    private String subscriptorEmail;
    
    public static SubscriptionPK from(Subscription subscription) {
        SubscriptionPK pk = new SubscriptionPK();
        pk.setAuthorEmail(subscription.getAuthorEmail());
        pk.setSubscriptorEmail(subscription.getSubscriptor().getEmail());
        
        return pk;
    }
}
