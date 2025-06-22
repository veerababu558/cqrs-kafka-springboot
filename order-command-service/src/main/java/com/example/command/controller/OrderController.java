package com.example.command.controller;
import com.example.command.model.Orders;
import com.example.command.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService service;

    @PostMapping
    public Orders create(@RequestBody Orders order) {
        return service.createOrder(order);
    }
}
