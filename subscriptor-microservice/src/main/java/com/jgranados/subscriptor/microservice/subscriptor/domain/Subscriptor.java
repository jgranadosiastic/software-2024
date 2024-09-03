/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.domain;

import com.jgranados.author.microservice.common.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author jose
 */
@Data
@DomainEntity
public class Subscriptor {
    private final String email;
    private final String name;
}
