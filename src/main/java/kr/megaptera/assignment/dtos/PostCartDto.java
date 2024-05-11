package kr.megaptera.assignment.dtos;

public class PostCartDto {
    String productId;
    Long quantity;
    
    public PostCartDto() {
    }

    public String getProductId() {
        return productId;
    }

    public Long getQuantity() {
        return quantity;
    }
}
