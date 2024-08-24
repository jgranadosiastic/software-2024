/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.publishingarticleusecase;

import com.jgranados.author.microservice.article.domain.Article;
import com.jgranados.author.microservice.author.application.exceptions.AuthorException;
import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.author.infrastructure.inputports.PublishingArticleInputPort;
import com.jgranados.author.microservice.author.infrastructure.outputadapter.db.AuthorDbEntity;
import com.jgranados.author.microservice.author.infrastructure.outputadapter.db.AuthorDbOutputAdapter;
import com.jgranados.author.microservice.common.UseCase;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jose
 */
@UseCase
public class PublishingArticleUseCase implements PublishingArticleInputPort {

    private AuthorDbOutputAdapter authorDbOutputAdapter;

    @Autowired
    public PublishingArticleUseCase(AuthorDbOutputAdapter authorDbOutputAdapter) {
        this.authorDbOutputAdapter = authorDbOutputAdapter;
    }

    @Override
    public void publishArticle(String authorEmail, PublishingArticleRequest article) 
            throws AuthorException, EntityNotFoundException {
        // validar si existe autor
        authorDbOutputAdapter
                .findByEmail(authorEmail)
                .orElseThrow(() -> new EntityNotFoundException("Author with email " + authorEmail + " not found!"));

        // convertir a dominio
        Article articleDomain = PublishingArticleRequest.convertToDomain(article);
        // verificar validez articulo
        if (!articleDomain.isContentValid()) {
            throw new AuthorException("Articule with content invalid!");
        }
        
        articleDomain.setPublicationDate(LocalDate.now());
        articleDomain.setActive(true);
        articleDomain.setVisible(true);
        
        // almacenar registro de la publicacion
        
    }

}
