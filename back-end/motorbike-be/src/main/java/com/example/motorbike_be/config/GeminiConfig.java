package com.example.motorbike_be.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeminiConfig {

    @Value("${Gemini.api.key}")
    private String apiKey;

    @Value("${Gemini.api.url}")
    private String apiUrl;



}
