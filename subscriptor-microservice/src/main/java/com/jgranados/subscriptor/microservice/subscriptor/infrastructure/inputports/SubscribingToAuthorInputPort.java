/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.infrastructure.inputports;

import com.jgranados.subscriptor.microservice.common.application.exceptions.EntityAlreadyExistsException;
import com.jgranados.subscriptor.microservice.subscription.domain.Subscription;
import com.jgranados.subscriptor.microservice.subscriptor.application.subscribingtoauthorusecase.SubscriptionRequest;
import jakarta.persistence.EntityNotFoundException;

/**
 *
 * @author jose
 */
public interface SubscribingToAuthorInputPort {
    Subscription subscribeToAuthor(String email, SubscriptionRequest subscriptionRequest) throws EntityAlreadyExistsException, EntityNotFoundException;
}
