/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.infrastructure.outputadapter.db;

import com.jgranados.author.microservice.article.domain.Article;
import com.jgranados.author.microservice.author.domain.Author;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "article")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDbEntity {
    @Id
    private String id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String authorEmail;
    @Column
    private String content;
    @Column
    private LocalDate publicationDate;
    @Column
    private boolean active;
    @Column
    private boolean visible;
    
    public static ArticleDbEntity from(Article article) {
        return new ArticleDbEntity(
                UUID.randomUUID().toString(),
                article.getTitle(),
                article.getDescription(),
                article.getAuthor().getEmail(),
                article.getContent(),
                article.getPublicationDate(),
                article.isActive(),
                article.isVisible()
        );
    }
    
    public Article convertToDomain(Author author) {
        return Article.builder()
                .id(UUID.fromString(id))
                .title(title)
                .description(description)
                .author(author)
                .content(content)
                .publicationDate(publicationDate)
                .active(active)
                .visible(visible)
                .build();
    }
}
