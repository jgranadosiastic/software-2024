/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputadapter.db;

import com.jgranados.author.microservice.common.PersistenceAdapter;
import com.jgranados.subscriptor.microservice.subscription.domain.Subscription;
import com.jgranados.subscriptor.microservice.subscriptor.domain.Subscriptor;
import com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputport.db.ExistsSubscriptionOutputPort;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputport.db.FindSubscriptorByEmailOutputPort;
import com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputport.db.SubscribeOutputPort;

/**
 *
 * @author jose
 */
@PersistenceAdapter
public class SubscriptorDbOutputAdapter implements FindSubscriptorByEmailOutputPort,
        ExistsSubscriptionOutputPort,
        SubscribeOutputPort {

    private SubscriptorDbEntityRepository subscriptorDbRepository;
    private SubscriptionDbEntityRepository subscriptionDbRepository;

    @Autowired
    public SubscriptorDbOutputAdapter(SubscriptorDbEntityRepository subscriptorDbRepository,
            SubscriptionDbEntityRepository subscriptionDbEntityRepository) {
        this.subscriptorDbRepository = subscriptorDbRepository;
        this.subscriptionDbRepository = subscriptionDbEntityRepository;
    }

    @Override
    public Optional<Subscriptor> findByEmail(String email) {
        return subscriptorDbRepository.findById(email)
                .map(dbEntity -> dbEntity.convertToDomain());
    }

    @Override
    public boolean existsSubscription(Subscription subscription) {
        return subscriptionDbRepository.findById(SubscriptionPK.from(subscription))
                .isPresent();
    }

    @Override
    public Subscription subscribe(Subscription subscription) {
        SubscriptionDbEntity dbEntity = SubscriptionDbEntity.from(subscription);
        dbEntity = subscriptionDbRepository.save(dbEntity);
        
        return dbEntity.convertToDomain(subscription.getSubscriptor());
    }

}
