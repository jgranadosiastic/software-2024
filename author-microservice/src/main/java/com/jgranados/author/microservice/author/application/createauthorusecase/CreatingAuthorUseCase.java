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
import com.jgranados.author.microservice.common.application.exceptions.EntityAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose
 */
@UseCase
@Transactional
public class CreatingAuthorUseCase implements CreatingAuthorInputPort {

    private AuthorDbOutputAdapter authorOutputAdapter;
    
    @Autowired
    public CreatingAuthorUseCase(AuthorDbOutputAdapter authorOutputAdapter) {
        this.authorOutputAdapter = authorOutputAdapter;
    }
    
    @Override
    public Author createAuthor(CreateAuthorRequest createAuthorRequest) throws EntityAlreadyExistsException {
        if (authorOutputAdapter.findByEmail(createAuthorRequest.getEmail()).isPresent()) {
            throw new EntityAlreadyExistsException("author exists");
        }
        Author author = createAuthorRequest.convertToDomain();
        return authorOutputAdapter.createAuthor(author);
    }    
}
