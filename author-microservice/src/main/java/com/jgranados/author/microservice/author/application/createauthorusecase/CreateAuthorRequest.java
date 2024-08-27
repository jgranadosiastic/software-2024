/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.createauthorusecase;

import com.jgranados.author.microservice.author.domain.Author;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class CreateAuthorRequest {
    private final String email;
    private final String name;
    private final String profession;
    private final String about;
    
    public Author convertToDomain() {
        return Author.builder()
                .email(email)
                .name(name)
                .about(about)
                .profession(profession)
                .build();
    }
}
