/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.infrastructure.inputadapters.restapi;

import com.jgranados.author.microservice.common.WebAdapter;
import com.jgranados.subscriptor.microservice.common.application.exceptions.EntityAlreadyExistsException;
import com.jgranados.subscriptor.microservice.subscriptor.application.subscribingtoauthorusecase.SubscriptionRequest;
import com.jgranados.subscriptor.microservice.subscriptor.infrastructure.inputports.SubscribingToAuthorInputPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose
 */
@RestController
@RequestMapping("/v1/subscribers")
@WebAdapter
public class SubscriptorControllerAdapter {

    private SubscribingToAuthorInputPort subscribingToAuthorInputPort;

    @Autowired
    public SubscriptorControllerAdapter(SubscribingToAuthorInputPort subscribingToAuthorInputPort) {
        this.subscribingToAuthorInputPort = subscribingToAuthorInputPort;
    }

    @PostMapping("/{email}/subscriptions")
    public ResponseEntity<Void> subscribeToAuthor(@PathVariable String email,
            @RequestBody SubscriptionRequest subscriptionRequest) throws EntityAlreadyExistsException,
            EntityNotFoundException {
        subscribingToAuthorInputPort.subscribeToAuthor(email, subscriptionRequest);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
