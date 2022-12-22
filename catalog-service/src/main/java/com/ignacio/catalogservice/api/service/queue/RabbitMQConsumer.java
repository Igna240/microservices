package com.ignacio.catalogservice.api.service.queue;

import com.ignacio.catalogservice.api.service.CatalogService;
import com.ignacio.catalogservice.domain.model.dto.Catalog;
import com.ignacio.catalogservice.domain.model.dto.dto.CatalogWS;
import com.ignacio.catalogservice.domain.model.dto.dto.MovieWS;
import com.ignacio.catalogservice.domain.model.dto.dto.SerieWS;
import com.ignacio.catalogservice.domain.repository.CatalogRepository;
import com.netflix.discovery.converters.Auto;
import com.rabbitmq.client.DeliverCallback;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Slf4j
@Component
public class RabbitMQConsumer {

    @Autowired
    private CatalogService catalogService;

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }


    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receive(@Payload MovieWS movieWS){
       catalogService.saveMovie(movieWS);
    }

    @RabbitListener(queues = {"${queue.serie.name}"})
    public void receive(@Payload SerieWS seriesWS){
        catalogService.saveSerie(seriesWS);
    }


}
