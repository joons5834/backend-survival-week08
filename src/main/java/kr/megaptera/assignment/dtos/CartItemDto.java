package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.CartItem;

public class CartItemDto {
    String id;
    String productName;
    Long quantity;
    Long totalPrice;
    Long unitPrice;

    public CartItemDto() {
    }

    public CartItemDto(CartItem cartItem) {
        id = cartItem.productId().toString();
        productName = cartItem.product().name();
        quantity = cartItem.quantity();
        totalPrice = cartItem.totalPrice();
        unitPrice = cartItem.product().price();
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }
}
