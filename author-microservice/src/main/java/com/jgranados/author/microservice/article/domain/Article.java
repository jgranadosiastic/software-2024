/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.domain;

import com.jgranados.author.microservice.author.domain.Author;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jose
 */
@Getter
@Setter
@Builder
public class Article {
    private String title;
    private String description;
    private Author author;
    private String content;
    private LocalDate publicationDate;
    private boolean active;
    private boolean visible;
    
    
    public boolean isContentValid() {
        if (content == null) {
            throw new IllegalArgumentException("Content empty");
        }
        
        int words = content.trim().split(" ").length;
        
        return words >= 200 && words <= 500;
    }
    
    
}
