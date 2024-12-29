package ru.otus.bot.telegram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final WebClient webClient;


    public <T> T get(String uri, ParameterizedTypeReference<T> typeReference) {
        return webClient.get()
                        .uri(uri)
                        .retrieve()
                        .bodyToMono(typeReference)
                        .block();
    }

    public <T> void post(T body, String uri) {
        webClient.post()
                 .uri(uri)
                 .contentType(MediaType.APPLICATION_JSON)
                 .bodyValue(body)
                 .retrieve()
                 .bodyToMono(String.class)
                 .block();
    }
}
