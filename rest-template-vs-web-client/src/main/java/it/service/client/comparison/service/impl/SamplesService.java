package it.service.client.comparison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import it.service.client.comparison.dto.Sample;
import it.service.client.comparison.service.ISamplesService;
import reactor.core.publisher.Mono;

@Service
public class SamplesService implements ISamplesService {

    @Autowired
    private WebClient webClient;

    @Value("${endpoint.externalservice}")
    private String externalService;

    @Autowired
    private RestTemplate restTemplate;

    public Mono<Sample> findByIdWebClient(long id) {

        return webClient.get().uri(uriBuilder -> uriBuilder.path("/samples/" + id).build()).retrieve()
                .bodyToMono(Sample.class);
    }

    public Sample findByIdRestClient(long id) {

        return restTemplate.getForEntity(externalService + "/samples/" + id, Sample.class).getBody();
    }
}
