package com.example.command.service;
import com.example.command.model.Orders;
import com.example.command.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrdersRepository repository;
    private final KafkaTemplate<String, Orders> kafkaTemplate;

    public Orders createOrder(Orders order) {
        Orders saved = repository.save(order);
        kafkaTemplate.send("order-topic", saved);
        return saved;
    }
}
