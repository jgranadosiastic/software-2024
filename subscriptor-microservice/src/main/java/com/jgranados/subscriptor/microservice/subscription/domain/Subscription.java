/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscription.domain;

import com.jgranados.author.microservice.common.DomainEntity;
import com.jgranados.subscriptor.microservice.subscriptor.domain.Subscriptor;
import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author jose
 */
@Data
@DomainEntity
public class Subscription {
    private Subscriptor subscriptor;
    private String authorEmail;
    private LocalDate subscriptionDate;
    private boolean withNotifications;
}
