package com.example.motorbike_be.config;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeminiConfig {

    @Value("${Gemini.api.key}")
    private String apiKey;

    @Value("${Gemini.api.url}")
    private String apiUrl;
}
