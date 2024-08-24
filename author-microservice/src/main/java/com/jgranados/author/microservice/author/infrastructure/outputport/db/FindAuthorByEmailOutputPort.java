/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jgranados.author.microservice.author.infrastructure.outputport.db;

import com.jgranados.author.microservice.author.infrastructure.outputadapter.db.AuthorDbEntity;
import java.util.Optional;

/**
 *
 * @author jose
 */
public interface FindAuthorByEmailOutputPort {
    Optional<AuthorDbEntity> findByEmail(String email);
}
