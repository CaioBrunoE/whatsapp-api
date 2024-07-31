package com.api.whatsapp.repository;

import com.api.whatsapp.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
