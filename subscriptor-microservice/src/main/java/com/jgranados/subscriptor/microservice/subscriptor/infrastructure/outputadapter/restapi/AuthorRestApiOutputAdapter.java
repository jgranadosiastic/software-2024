/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputadapter.restapi;

import com.jgranados.subscriptor.microservice.subscription.domain.Subscription;
import com.jgranados.subscriptor.microservice.subscriptor.infrastructure.outputport.restapi.ExistsAuthorByEmailOutputPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

/**
 *
 * @author jose
 */
//@RestApiAdapter
@Component
public class AuthorRestApiOutputAdapter implements ExistsAuthorByEmailOutputPort {

    @Override
    public boolean existsByEmail(Subscription subscription) {
        return existsByEmail(subscription.getAuthorEmail());
    }
    
    public boolean existsByEmail(String email) {
        RestClient restClient = RestClient.create();
        try {
            restClient.head()
                .uri("http://localhost:8080/v1/authors/" + email)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toBodilessEntity();
            
            return true;
        } catch (RestClientResponseException e) {
            if (e.getStatusCode().isSameCodeAs(HttpStatus.NOT_FOUND)) {
                return false;
            } else {
                // propagate with throws
                e.printStackTrace();
            }
        }
        
        return false;
    }
    
}
