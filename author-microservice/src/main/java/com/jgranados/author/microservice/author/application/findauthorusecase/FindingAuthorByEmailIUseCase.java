/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.findauthorusecase;

import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.author.infrastructure.inputports.FindingAuthorByEmailInputPort;
import com.jgranados.author.microservice.author.infrastructure.outputadapter.db.AuthorDbOutputAdapter;
import com.jgranados.author.microservice.common.UseCase;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jose
 */
@UseCase
public class FindingAuthorByEmailIUseCase implements FindingAuthorByEmailInputPort {
    
    private AuthorDbOutputAdapter authorDbOutputAdapter;

    @Autowired
    public FindingAuthorByEmailIUseCase(AuthorDbOutputAdapter authorDbOutputAdapter) {
        this.authorDbOutputAdapter = authorDbOutputAdapter;
    }

    @Override
    public Optional<Author> findByEmail(String email) {
        return authorDbOutputAdapter.findByEmail(email);
    }
    
}
