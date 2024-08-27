/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.publishingarticleusecase;

import com.jgranados.author.microservice.article.domain.Article;
import com.jgranados.author.microservice.article.infrastructure.outputadapter.db.ArticleDbOutputAdapter;
import com.jgranados.author.microservice.author.application.exceptions.AuthorException;
import com.jgranados.author.microservice.author.domain.Author;
import com.jgranados.author.microservice.author.infrastructure.inputports.PublishingArticleInputPort;
import com.jgranados.author.microservice.author.infrastructure.outputadapter.db.AuthorDbEntity;
import com.jgranados.author.microservice.author.infrastructure.outputadapter.db.AuthorDbOutputAdapter;
import com.jgranados.author.microservice.common.UseCase;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jose
 */
@UseCase
@Transactional
public class PublishingArticleUseCase implements PublishingArticleInputPort {

    private AuthorDbOutputAdapter authorDbOutputAdapter;
    private ArticleDbOutputAdapter articleDbOutputAdapter;

    @Autowired
    public PublishingArticleUseCase(AuthorDbOutputAdapter authorDbOutputAdapter,
            ArticleDbOutputAdapter ArticleDbOutputAdapter) {
        this.authorDbOutputAdapter = authorDbOutputAdapter;
        this.articleDbOutputAdapter = ArticleDbOutputAdapter;
    }

    @Override
    public void publishArticle(String authorEmail, PublishingArticleRequest articleRequest) 
            throws AuthorException, EntityNotFoundException {
        // validar si existe autor
        Author autor = authorDbOutputAdapter
                .findByEmail(authorEmail)
                .orElseThrow(() -> new EntityNotFoundException("Author with email " + authorEmail + " not found!"));

        // convertir a dominio
        Article article = articleRequest.convertToDomain();
        // verificar validez articulo
        if (!article.isContentValid()) {
            throw new AuthorException("Article with content invalid!");
        }
        
        article.setAuthor(autor);
        article.setPublicationDate(LocalDate.now());
        article.setActive(true);
        article.setVisible(true);
        
        // almacenar registro de la publicacion
        articleDbOutputAdapter.storeArticle(article);
    }

}
