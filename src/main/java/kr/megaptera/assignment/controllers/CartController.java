package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.CartService;
import kr.megaptera.assignment.dtos.CartItemDto;
import kr.megaptera.assignment.dtos.ListCartDto;
import kr.megaptera.assignment.dtos.PostCartDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart-line-items")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ListCartDto list() {
        return cartService.getAllItems();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PostCartDto postCartDto) {
        cartService.createItem(postCartDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateQuantity(@PathVariable String id,
                               @RequestBody CartItemDto cartItemDto) {
        cartService.changeItemQuantity(id, cartItemDto.getQuantity());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        cartService.deleteAnItem(id);
    }

}
