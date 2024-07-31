package com.api.whatsapp.controller;

import com.api.whatsapp.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.MessageService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public void sendMessage(@RequestBody Message message) {
        messageService.saveMessage(message);
        // Aqui você pode adicionar a lógica para enviar a mensagem para o ChatGPT e WhatsApp
    }
}
