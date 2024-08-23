/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.domain;

import com.jgranados.author.microservice.common.DomainEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Getter
@Setter
@DomainEntity
public class Author {
    
    private String email;
    private String name;
    private String profession;
    private String about;
    
    
    
}
