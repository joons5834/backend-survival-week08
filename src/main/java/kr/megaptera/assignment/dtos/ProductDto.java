package kr.megaptera.assignment.dtos;

import kr.megaptera.assignment.models.Product;

public class ProductDto {
    String id;
    String name;
    Long price;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.id().toString();
        this.name = product.name();
        this.price = product.price();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}
