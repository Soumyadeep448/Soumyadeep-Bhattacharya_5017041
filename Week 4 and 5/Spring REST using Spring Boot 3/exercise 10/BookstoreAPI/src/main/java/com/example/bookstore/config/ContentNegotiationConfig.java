package com.example.bookstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ContentNegotiationConfig implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
            .favorPathExtension(true)
            .favorParameter(true)
            .parameterName("mediaType")
            .ignoreAcceptHeader(false)
            .defaultContentType(org.springframework.http.MediaType.APPLICATION_JSON)
            .mediaType("json", org.springframework.http.MediaType.APPLICATION_JSON)
            .mediaType("xml", org.springframework.http.MediaType.APPLICATION_XML);
    }
}