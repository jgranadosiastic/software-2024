/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.inputadapters.restapi;

import com.jgranados.author.microservice.author.application.createauthorusecase.CreateAuthorRequest;
import com.jgranados.author.microservice.author.application.exceptions.AuthorException;
import com.jgranados.author.microservice.author.application.publishingarticleusecase.PublishingArticleRequest;
import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.author.infrastructure.inputports.CreatingAuthorInputPort;
import com.jgranados.author.microservice.author.infrastructure.inputports.PublishingArticleInputPort;
import com.jgranados.author.microservice.common.WebAdapter;
import com.jgranados.author.microservice.common.application.exceptions.EntityAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose
 */
@RestController
@RequestMapping("/v1/authors")
@WebAdapter
public class AuthorControllerAdapter {
    
    private PublishingArticleInputPort publishingArticle;
    private CreatingAuthorInputPort creatingAuthorInputPort;

    @Autowired
    public AuthorControllerAdapter(PublishingArticleInputPort publishingArticle, CreatingAuthorInputPort creatingAuthorInputPort) {
        this.publishingArticle = publishingArticle;
        this.creatingAuthorInputPort = creatingAuthorInputPort;
    }
    
    
    
    @PostMapping("/{email}/articles")
    public ResponseEntity<Void> publishArticle(@PathVariable String email,
            @RequestBody PublishingArticleRequest article) throws AuthorException {
        publishingArticle.publishArticle(email, article);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody CreateAuthorRequest createAuthorRequest)
            throws EntityAlreadyExistsException{
        Author created = creatingAuthorInputPort.createAuthor(createAuthorRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AuthorResponse.from(created));
                
    }
}
