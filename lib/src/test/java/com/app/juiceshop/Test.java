package com.app.juiceshop;

import com.app.juiceshop.controller.OrderController;
import com.app.juiceshop.dto.OrderDTO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        OrderController controller = (OrderController) context.getBean("orderController");

        // Create a new order
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(11);
        orderDTO.setCustomerName("Tithi Das");
        orderDTO.setJuiceType("CranBarry  Juice");
        orderDTO.setPrice(285);
        orderDTO.setQuantity(3);

        try {
            // Place the order
            controller.createOrder(orderDTO);

            // Retrieve the order by ID
            controller.getOrderById(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
