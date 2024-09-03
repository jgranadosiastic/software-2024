/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputport.db;

import com.jgranados.subscriptor.microservice.subscription.domain.Subscription;

/**
 *
 * @author jose
 */
public interface ExistsSubscriptionOutputPort {

    boolean existsSubscription(Subscription subscription);
}
