/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.application.subscribingtoauthorusecase;

import com.jgranados.author.microservice.common.UseCase;
import com.jgranados.subscriptor.microservice.common.application.exceptions.EntityAlreadyExistsException;
import com.jgranados.subscriptor.microservice.subscription.domain.Subscription;
import com.jgranados.subscriptor.microservice.subscriptor.domain.Subscriptor;
import com.jgranados.subscriptor.microservice.subscriptor.infrastructure.inputports.SubscribingToAuthorInputPort;
import com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputadapter.db.SubscriptorDbOutputAdapter;
import com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputadapter.restapi.AuthorRestApiOutputAdapter;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jose
 */
@UseCase
public class SubscribingToAuthorUseCase implements SubscribingToAuthorInputPort {

    private AuthorRestApiOutputAdapter authorRestApiOutputAdapter;
    private SubscriptorDbOutputAdapter subscriptorDbOutputAdapter;

    @Autowired
    public SubscribingToAuthorUseCase(AuthorRestApiOutputAdapter authorRestApiOutputAdapter,
            SubscriptorDbOutputAdapter subscriptorDbOutputAdapter) {
        this.authorRestApiOutputAdapter = authorRestApiOutputAdapter;
        this.subscriptorDbOutputAdapter = subscriptorDbOutputAdapter;
    }

    @Override
    public Subscription subscribeToAuthor(String email, SubscriptionRequest subscriptionRequest)
            throws EntityAlreadyExistsException, EntityNotFoundException {
        // Verify the author exists (using output port)
        String authorEmail = subscriptionRequest.getAuthorEmail();
        if (!authorRestApiOutputAdapter.existsByEmail(authorEmail)) {
            throw new EntityNotFoundException(
                    String.format("Author with email %s not found.", authorEmail));
        }
        // get and verify subscriptor
        Subscriptor subscriptor = subscriptorDbOutputAdapter.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Subscriptor with email " + email + " not found!"));

        // create subscription
        Subscription subscription = subscriptionRequest.convertToDomain(subscriptor);

        // Verify subscription already exitst
        if (subscriptorDbOutputAdapter.existsSubscription(subscription)) {
            throw new EntityAlreadyExistsException("Subscription already exists. Author: " + authorEmail);
        }

        subscription.setSubscriptionDate(LocalDate.now());
        subscription.setWithNotifications(true);

        return subscriptorDbOutputAdapter.subscribe(subscription);
    }

}
