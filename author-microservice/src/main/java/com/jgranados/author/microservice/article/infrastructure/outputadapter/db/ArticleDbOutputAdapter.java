/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.article.infrastructure.outputadapter.db;

import com.jgranados.author.microservice.article.domain.Article;
import com.jgranados.author.microservice.article.infrastructure.outputport.db.StoreArticleOutputPort;
import com.jgranados.author.microservice.common.PersistenceAdapter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jose
 */
@PersistenceAdapter
public class ArticleDbOutputAdapter implements StoreArticleOutputPort {

    private ArticleDbEntityRepository articleDbRepository;

    @Autowired
    public ArticleDbOutputAdapter(ArticleDbEntityRepository articleDbRepository) {
        this.articleDbRepository = articleDbRepository;
    }

    @Override
    public Article storeArticle(Article article) {
        ArticleDbEntity dbEntity = ArticleDbEntity.from(article);
        articleDbRepository.save(dbEntity);
        return dbEntity.convertToDomain(article.getAuthor());
    }

}
