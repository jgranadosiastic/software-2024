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
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class AuthorDbEntity {

    @Id
    private String email;
    @Column
    private String name;
    @Column
    private String profession;
    @Column
    private String about;

    public Author convertToDomain() {
        return Author.builder()
                .email(email)
                .name(name)
                .profession(profession)
                .about(about)
                .build();
    }

    public static AuthorDbEntity from(Author author) {
        return new AuthorDbEntity(author.getEmail(),
                author.getName(),
                author.getProfession(),
                author.getAbout()
        );
    }
}
