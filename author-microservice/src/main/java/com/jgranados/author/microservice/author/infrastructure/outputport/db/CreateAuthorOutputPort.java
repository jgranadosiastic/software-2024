/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.outputport.db;

import com.jgranados.author.microservice.author.domain.Author;

/**
 *
 * @author jose
 */
public interface CreateAuthorOutputPort {
    Author createAuthor(Author author);
}
