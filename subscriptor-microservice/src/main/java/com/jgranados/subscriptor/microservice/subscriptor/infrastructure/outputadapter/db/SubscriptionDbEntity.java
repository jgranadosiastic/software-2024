/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputadapter.db;

import com.jgranados.subscriptor.microservice.subscription.domain.Subscription;
import com.jgranados.subscriptor.microservice.subscriptor.domain.Subscriptor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "subscription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SubscriptionPK.class)
public class SubscriptionDbEntity {

    @Id
    private String authorEmail;
    @Id
    private String subscriptorEmail;
    @Column
    private LocalDate subscriptionDate;
    @Column
    private Boolean withNotifications;

    public Subscription convertToDomain(Subscriptor subscriptor) {
        Subscription subscription = new Subscription();
        subscription.setAuthorEmail(authorEmail);
        subscription.setSubscriptor(subscriptor);
        subscription.setSubscriptionDate(subscriptionDate);
        subscription.setWithNotifications(withNotifications != null ? withNotifications : false);
        
        return subscription;
    }
    
    public static SubscriptionDbEntity from(Subscription subscription) {
        SubscriptionDbEntity dbEntity = new SubscriptionDbEntity();
        dbEntity.setAuthorEmail(subscription.getAuthorEmail());
        dbEntity.setSubscriptorEmail(subscription.getSubscriptor().getEmail());
        dbEntity.setSubscriptionDate(subscription.getSubscriptionDate());
        dbEntity.setWithNotifications(subscription.isWithNotifications());
        
        return dbEntity;
    }
}
