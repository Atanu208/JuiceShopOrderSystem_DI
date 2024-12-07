package com.app.juiceshop.service;
import com.app.juiceshop.dto.OrderDTO;
import com.app.juiceshop.vo.OrderVO;

public interface OrderService {
    int placeOrder(OrderDTO dto) throws Exception;
    OrderDTO getOrderById(int orderId) throws Exception; // New method for fetching order details
}
