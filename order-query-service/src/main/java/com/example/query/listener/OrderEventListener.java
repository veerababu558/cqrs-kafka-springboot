package com.example.query.listener;
import com.example.query.model.OrderEvent;
import com.example.query.repository.OrderEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventListener {
    private final OrderEventRepository repository;

    @KafkaListener(topics = "order-topic", groupId = "query-group")
    public void listen(OrderEvent event) {
        repository.save(event);
    }
}
