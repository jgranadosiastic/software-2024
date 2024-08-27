/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.createauthorusecase;

import com.jgranados.author.microservice.author.application.exceptions.AuthorException;
import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.author.infrastructure.inputports.CreatingAuthorInputPort;
import com.jgranados.author.microservice.author.infrastructure.outputadapter.db.AuthorDbOutputAdapter;
import com.jgranados.author.microservice.common.UseCase;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose
 */
@UseCase
@Transactional
public class CreatingAuthorUseCase implements CreatingAuthorInputPort {

    private AuthorDbOutputAdapter authorOutputAdapter;
    
    @Override
    public Author createAuthor(CreateAuthorRequest createAuthorRequest) {
        if (authorOutputAdapter.findByEmail(createAuthorRequest.getEmail()).isPresent()) {
            throw new EntityAlreadyExists("author exists");
        }
        Author author = createAuthorRequest.convertToDomain();
        return authorOutputAdapter.createAuthor(author);
    }
    
}
