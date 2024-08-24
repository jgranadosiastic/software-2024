/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.outputadapter.db;

import com.jgranados.author.microservice.author.domain.Author;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
public class AuthorDbEntity {
    
    @Id
    private String email;
    @Column
    private String name;
    @Column
    private String profession;
    @Column
    private String about;
    
    public static Author convertToDomain(AuthorDbEntity dbEntity) {
        return Author.builder()
                .email(dbEntity.getEmail())
                .name(dbEntity.getName())
                .profession(dbEntity.getProfession())
                .about(dbEntity.getAbout())
                .build();
    }
}
