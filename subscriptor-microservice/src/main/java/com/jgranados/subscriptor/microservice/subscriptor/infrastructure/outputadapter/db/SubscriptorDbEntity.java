/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputadapter.db;

import com.jgranados.subscriptor.microservice.subscriptor.domain.Subscriptor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "subscriptor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptorDbEntity {
    @Id
    private String email;
    @Column
    private String name;
    
    public Subscriptor convertToDomain() {
        return new Subscriptor(email, name);
    }
}
