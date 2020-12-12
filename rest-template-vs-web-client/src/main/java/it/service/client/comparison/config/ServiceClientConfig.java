package it.service.client.comparison.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ServiceClientConfig {

    @Value("${endpoint.externalservice}")
    private String externalServiceEndpoint;

    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder) {

        return webClientBuilder.baseUrl(externalServiceEndpoint).build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
