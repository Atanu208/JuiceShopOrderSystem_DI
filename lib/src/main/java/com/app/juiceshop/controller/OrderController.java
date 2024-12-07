package com.app.juiceshop.controller;

import com.app.juiceshop.dto.OrderDTO;
import com.app.juiceshop.service.OrderService;

public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    public void createOrder(OrderDTO dto) throws Exception {
        int result = orderService.placeOrder(dto);
        if (result > 0) {
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Order placement failed.");
        }
    }
    // New method to retrieve order details by orderId
    public void getOrderById(int orderId) throws Exception {
        OrderDTO orderDTO = orderService.getOrderById(orderId);
        System.out.println("Order Details: ");
        System.out.println("Order ID: " + orderDTO.getOrderId());
        System.out.println("Customer Name: " + orderDTO.getCustomerName());
        System.out.println("Juice Type: " + orderDTO.getJuiceType());
        System.out.println("Price: " + orderDTO.getPrice());
        System.out.println("Quantity: " + orderDTO.getQuantity());
    }
}
