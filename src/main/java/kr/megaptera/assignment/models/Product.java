package kr.megaptera.assignment.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Embeddable
@Table(name = "products")
public class Product {
    @EmbeddedId
    ProductId id;
    String name;
    Long price;


    public Product() {
    }

    public Product(ProductId productId, String name, long price) {
        this.id = productId;
        this.name = name;
        this.price = price;
    }

    public ProductId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Long price() {
        return price;
    }
}
