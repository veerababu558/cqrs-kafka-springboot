package com.example.query.model;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "orders")
public class OrderEvent {
    @Id
    private String id;
    private String product;
    private int quantity;
    private double price;
}
