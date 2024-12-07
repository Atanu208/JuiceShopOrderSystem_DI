package com.app.juiceshop.vo;

/**
 * OrderVO (Value Object) represents a read-only view of the Order details.
 * This class is immutable and used to send processed data to the client or UI.
 */
public final class OrderVO {
    private final int orderId;
    private final String customerName;
    private final String juiceType;
    private final double totalPrice;
    private final int quantity;

    // Constructor
    public OrderVO(int orderId, String customerName, String juiceType, double totalPrice, int quantity) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.juiceType = juiceType;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    // Getters (No setters to maintain immutability)
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getJuiceType() {
        return juiceType;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", juiceType='" + juiceType + '\'' +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                '}';
    }
}
