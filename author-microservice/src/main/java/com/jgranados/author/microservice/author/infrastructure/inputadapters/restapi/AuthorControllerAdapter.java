/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.inputadapters.restapi;

import com.jgranados.author.microservice.author.application.publishingarticleusecase.PublishingArticleRequest;
import com.jgranados.author.microservice.author.infrastructure.inputports.PublishingArticleInputPort;
import com.jgranados.author.microservice.common.WebAdapter;
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
    
    @PostMapping("/{email}/articles")
    public ResponseEntity<Void> publishArticle(@PathVariable String email,
            @RequestBody PublishingArticleRequest article) {
        publishingArticle.publishArticle(email, article);
    }
    
}
