/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.inputports;

import com.jgranados.author.microservice.author.application.exceptions.AuthorException;
import com.jgranados.author.microservice.author.application.publishingarticleusecase.PublishingArticleRequest;

/**
 *
 * @author jose
 */
public interface PublishingArticleInputPort {
    
    void publishArticle(String authorEmail, PublishingArticleRequest article) throws AuthorException;
    
}
