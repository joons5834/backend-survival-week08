package kr.megaptera.assignment.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class CartItem {
    @Id
    ProductId productId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;

    Long quantity;
    Long totalPrice;

    public CartItem() {
    }

    public CartItem(Product product, Long quantity) {
        this.productId = product.id();
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = product.price() * quantity;
    }

    public ProductId productId() {
        return productId;
    }

    public Product product() {
        return product;
    }

    public Long quantity() {
        return quantity;
    }

    public Long totalPrice() {
        return totalPrice;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
        this.totalPrice = quantity * this.product.price();
    }
}
