/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputadapter.db;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jose
 */
public interface SubscriptionDbEntityRepository extends JpaRepository<SubscriptionDbEntity, SubscriptionPK> {

}
