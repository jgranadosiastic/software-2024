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
    
    public Article convertToDomain() {
        return Article.builder()
                .title(title)
                .content(content)
                .description(description)
                .build();
    }
}
