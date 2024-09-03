/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputport.restapi;

import com.jgranados.subscriptor.microservice.subscription.domain.Subscription;

/**
 *
 * @author jose
 */
public interface ExistsAuthorByEmailOutputPort {

    boolean existsByEmail(Subscription subscription);
}
