package com.example.spring.mongo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
public class User {
    @MongoId
    private Integer id;
    private String username;
    private String password;
}
