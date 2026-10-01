package vn.hcmute.models;

public class CartItem_24110304 {
    private Videos_24110304 video;
    private int quantity;

    public CartItem_24110304() {
    }

    public CartItem_24110304(Videos_24110304 video, int quantity) {
        this.video = video;
        this.quantity = quantity;
    }

    public Videos_24110304 getVideo() { 
        return video; 
    }
    
    public void setVideo(Videos_24110304 video) { 
        this.video = video; 
    }
    
    public int getQuantity() { 
        return quantity; 
    }
    
    public void setQuantity(int quantity) { 
        this.quantity = quantity; 
    }
}