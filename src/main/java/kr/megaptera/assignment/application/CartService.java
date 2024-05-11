package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.CartItemDto;
import kr.megaptera.assignment.dtos.ListCartDto;
import kr.megaptera.assignment.dtos.PostCartDto;
import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.CartRepository;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public ListCartDto getAllItems() {
        List<CartItemDto> allCartItemDtos = cartRepository.findAll().stream()
                .map(CartItemDto::new)
                .toList();
        return new ListCartDto(allCartItemDtos);
    }

    public void createItem(PostCartDto postCartDto) {
        String productIdStr = postCartDto.getProductId();
        ProductId productId = ProductId.of(productIdStr);
        Product productToAdd = productRepository.findById(productId)
                .orElseThrow();
        Optional<CartItem> itemToChangeQuantity =
                cartRepository.findById(productId);
        if (itemToChangeQuantity.isPresent()) {
            changeItemQuantity(productIdStr,
                    itemToChangeQuantity.get().quantity() +
                            postCartDto.getQuantity());
        } else {
            CartItem itemToAdd = new CartItem(productToAdd,
                    postCartDto.getQuantity());
            cartRepository.save(itemToAdd);
        }
    }

    public void changeItemQuantity(String productId, Long quantity) {
        if(quantity == 0){
            deleteAnItem(productId);
        }else {
            CartItem itemToChangeQuantity =
                    cartRepository.findById(ProductId.of(productId))
                            .orElseThrow();
            itemToChangeQuantity.setQuantity(quantity);
        }
    }

    public void deleteAnItem(String id) {
        cartRepository.deleteById(ProductId.of(id));
    }
}
