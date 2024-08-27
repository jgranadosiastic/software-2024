/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.author.microservice.article.infrastructure.outputport.db;

import com.jgranados.author.microservice.article.domain.Article;

/**
 *
 * @author jose
 */
public interface StoreArticleOutputPort {
    Article storeArticle(Article article);
}
