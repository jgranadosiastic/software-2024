/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.publishingarticleusecase;

import com.jgranados.author.microservice.article.domain.Article;
import lombok.Value;

/**
 *
 * @author jose
 */
@Value
public class PublishingArticleRequest {
    private String title;
    private String description;
    private String content;
    
    public static Article convertToDomain(PublishingArticleRequest article) {
        return Article.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .description(article.getDescription())
                .build();
    }
}
