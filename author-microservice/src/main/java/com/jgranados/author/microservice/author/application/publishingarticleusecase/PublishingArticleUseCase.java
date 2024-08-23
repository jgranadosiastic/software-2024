/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.author.microservice.author.application.publishingarticleusecase;

import com.jgranados.author.microservice.author.application.exceptions.AuthorException;
import com.jgranados.author.microservice.author.infrastructure.inputports.PublishingArticleInputPort;

/**
 *
 * @author jose
 */
public class PublishingArticleUseCase implements PublishingArticleInputPort {

    @Override
    public void publishArticle(String authorEmail, PublishingArticleRequest article) throws AuthorException {
        // validar si existe autor
        // convertir a dominio
        // verificar validez articulo
        // almacenar registro de la publicacion
        
    }
    
}
