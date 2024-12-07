package com.app.juiceshop.dao;

import com.app.juiceshop.entity.OrderBO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDaoImpl implements OrderDao {
    private DataSource dataSource;

    public OrderDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int saveOrder(OrderBO order) throws Exception {
        String query = "INSERT INTO orders (order_id, customer_name, juice_type, price, quantity) VALUES (?, ?, ?, ?, ?)";
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, order.getOrderId());
        pstmt.setString(2, order.getCustomerName());
        pstmt.setString(3, order.getJuiceType());
        pstmt.setDouble(4, order.getPrice());
        pstmt.setInt(5, order.getQuantity());
        return pstmt.executeUpdate();
    }

    @Override
    public OrderBO findOrderById(int orderId) throws Exception {
        String query = "SELECT order_id, customer_name, juice_type, price, quantity FROM orders WHERE order_id = ?";
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setInt(1, orderId);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // Populating the OrderBO object
            OrderBO order = new OrderBO();
            order.setOrderId(rs.getInt("order_id"));
            order.setCustomerName(rs.getString("customer_name"));
            order.setJuiceType(rs.getString("juice_type"));
            order.setPrice(rs.getDouble("price"));
            order.setQuantity(rs.getInt("quantity"));
            return order;
        } else {
            // If no order is found, return null or throw an exception
            throw new Exception("Order not found for ID: " + orderId);
        }
    }
}
