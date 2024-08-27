/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.outputadapter.db;

import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.author.infrastructure.outputport.db.CreateAuthorOutputPort;
import com.jgranados.author.microservice.author.infrastructure.outputport.db.FindAuthorByEmailOutputPort;
import com.jgranados.author.microservice.common.PersistenceAdapter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jose
 */
@PersistenceAdapter
public class AuthorDbOutputAdapter implements FindAuthorByEmailOutputPort,
        CreateAuthorOutputPort {

    private AuthorDbEntityRepository authorDbRepository;

    @Autowired
    public AuthorDbOutputAdapter(AuthorDbEntityRepository authorDbRepository) {
        this.authorDbRepository = authorDbRepository;
    }

    @Override
    public Optional<Author> findByEmail(String email) {
        return authorDbRepository.findById(email)
                .map(dbEntity -> dbEntity.convertToDomain());
    }

    @Override
    public Author createAuthor(Author author) {
        AuthorDbEntity dbEntity = AuthorDbEntity.from(author);
        authorDbRepository.save(dbEntity);
        return dbEntity.convertToDomain();
    }

}
