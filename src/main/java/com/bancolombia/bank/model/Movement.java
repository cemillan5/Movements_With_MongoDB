package com.bancolombia.bank.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "movements")
public class Movement {

    private String id;
    private String cardId;
    private LocalDateTime date;
    private Double amount;
    private String description;

}
