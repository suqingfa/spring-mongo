package com.example.spring.mongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public record User(
        @MongoId
        String id,
        String username,
        String password
) {
}
