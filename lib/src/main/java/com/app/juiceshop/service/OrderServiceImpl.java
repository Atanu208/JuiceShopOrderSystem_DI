package com.app.juiceshop.service;

import com.app.juiceshop.dao.OrderDao;
import com.app.juiceshop.dto.OrderDTO;
import com.app.juiceshop.entity.OrderBO;
import com.app.juiceshop.vo.OrderVO;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public int placeOrder(OrderDTO dto) throws Exception {
        OrderBO bo = new OrderBO();
        bo.setOrderId(dto.getOrderId());
        bo.setCustomerName(dto.getCustomerName());
        bo.setJuiceType(dto.getJuiceType());
        bo.setPrice(dto.getPrice());
        bo.setQuantity(dto.getQuantity());
        System.out.println("Total Price: " + bo.calculateTotalPrice());
        int retVal=orderDao.saveOrder(bo);
        return retVal;
    }

    @Override
    public OrderDTO getOrderById(int orderId) throws Exception {
        OrderBO orderBO = orderDao.findOrderById(orderId); // Retrieve OrderBO from DAO
        OrderDTO orderDTO = new OrderDTO();

        // Mapping OrderBO to OrderDTO
        orderDTO.setOrderId(orderBO.getOrderId());
        orderDTO.setCustomerName(orderBO.getCustomerName());
        orderDTO.setJuiceType(orderBO.getJuiceType());
        orderDTO.setPrice(orderBO.getPrice());
        orderDTO.setQuantity(orderBO.getQuantity());

        return orderDTO;
    }
}
