/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.outputadapter.db;

import com.jgranados.author.microservice.author.infrastructure.outputport.db.FindAuthorByEmailOutputPort;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jose
 */
@Component
public class AuthorDbOutputAdapter implements FindAuthorByEmailOutputPort {
    
    private AuthorDbEntityRepository authorDbRepository;

    @Autowired
    public AuthorDbOutputAdapter(AuthorDbEntityRepository authorDbRepository) {
        this.authorDbRepository = authorDbRepository;
    }

    @Override
    public Optional<AuthorDbEntity> findByEmail(String email) {
        return authorDbRepository.findById(email);
    }
    
}
