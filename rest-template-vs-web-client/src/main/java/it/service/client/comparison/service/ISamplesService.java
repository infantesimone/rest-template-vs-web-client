package it.service.client.comparison.service;

import it.service.client.comparison.dto.Sample;
import reactor.core.publisher.Mono;

public interface ISamplesService {

    public Mono<Sample> findByIdWebClient(long id);
    public Sample findByIdRestClient(long id);
}
