package kr.megaptera.assignment.dtos;

import java.util.List;

public class ListProductDto {
    List<ProductDto> products;

    public ListProductDto(List<ProductDto> products) {
        this.products = products;
    }

    public List<ProductDto> getProducts() {
        return products;
    }
}
