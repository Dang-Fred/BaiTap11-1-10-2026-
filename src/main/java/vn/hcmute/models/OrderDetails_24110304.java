package vn.hcmute.models;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails_24110304 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DetailId")
    private int detailId;

    @Column(name = "OrderId", length = 50)
    private String orderId;

    @Column(name = "VideoId", length = 50)
    private String videoId;

    @Column(name = "Quantity")
    private int quantity;

    // Getters and Setters
    public int getDetailId() { return detailId; }
    public void setDetailId(int detailId) { this.detailId = detailId; }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getVideoId() { return videoId; }
    public void setVideoId(String videoId) { this.videoId = videoId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}