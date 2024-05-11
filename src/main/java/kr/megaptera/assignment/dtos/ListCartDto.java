package kr.megaptera.assignment.dtos;

import java.util.List;

public class ListCartDto {
    List<CartItemDto> lineItems;

    public ListCartDto() {
    }

    public ListCartDto(List<CartItemDto> lineItems) {
        this.lineItems = lineItems;
    }

    public List<CartItemDto> getLineItems() {
        return lineItems;
    }
}
