package com.app.juiceshop.dao;
import com.app.juiceshop.entity.OrderBO;

public interface OrderDao {
    public int saveOrder(OrderBO order) throws Exception;
    OrderBO findOrderById(int orderId) throws Exception;
}
