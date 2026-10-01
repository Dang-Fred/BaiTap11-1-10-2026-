package vn.hcmute.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Orders_24110304 {
    @Id
    @Column(name = "OrderId", length = 50)
    private String orderId;

    @Column(name = "Username", length = 50)
    private String username;

    @Column(name = "OrderDate")
    private Date orderDate;

    @Column(name = "PaymentMethod", length = 20)
    private String paymentMethod; // VD: "COD"

    @Column(name = "Address", length = 255)
    private String address;

    @Column(name = "Status", length = 20)
    private String status; // VD: "Pending", "Delivered"

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}