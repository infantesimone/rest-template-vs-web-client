package it.service.client.comparison.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.service.client.comparison.dto.Sample;
import it.service.client.comparison.service.ISamplesService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@Slf4j
public class ComparisonController {

    @Autowired
    private ISamplesService samplesService;

    @GetMapping("/resttemplate/samples/{id}")
    public Sample findById(@PathVariable long id) {
        
        log.debug("resttemplate invocation");
        return samplesService.findByIdRestClient(id);
    }
    
    @GetMapping("/webclient/samples/{id}")
    public Mono<Sample> findByIdWebClient(@PathVariable long id) {

        log.debug("webclient invocation");
        return samplesService.findByIdWebClient(id);
    }
}