package com.api.whatsapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "messages")
public class Message {
    @Id
    private String id;
    private String content;
    private String sender;
    private Date timestamp;

    public Message() {
    }

    public Message(String content, String sender) {
        this.content = content;
        this.sender = sender;
        this.timestamp = new Date();
    }

}