package service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ChatGptService {
    private final String CHAT_GPT_URL = "https://api.openai.com/v1/chat/completions";
    private final String API_KEY = "sua-chave-de-api-aqui";

    public String getResponseFromChatGpt(String message) {
        RestTemplate restTemplate = new RestTemplate();

        // Configurar os cabeçalhos
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.set("Content-Type", "application/json");

        // Criar o corpo da requisição
        String requestBody = String.format(
                "{\"model\": \"gpt-3.5-turbo\", \"messages\": [{\"role\": \"user\", \"content\": \"%s\"}]}",
                message
        );

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Enviar a solicitação
        ResponseEntity<String> response = restTemplate.exchange(
                CHAT_GPT_URL,
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        return response.getBody();
    }
}

