/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.inputadapters.restapi;

import com.jgranados.author.microservice.author.domain.Author;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class AuthorResponse {

    private final String email;
    private final String name;
    private final String profession;
    private final String about;

    public static AuthorResponse from(Author author) {
        return new AuthorResponse(author.getEmail(),
                author.getName(),
                author.getProfession(),
                author.getAbout());
    }
}
