package com.example.query.kafka;

import com.example.query.model.Orders;
import com.example.query.repository.OrdersRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

    private final OrdersRepository ordersRepository;

    public OrderEventConsumer(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @KafkaListener(topics = "order-events", groupId = "query-group")
    public void consume(Orders order) {
        System.out.println("Consumed order: " + order.getOrderId());
        ordersRepository.save(order);
    }
}
