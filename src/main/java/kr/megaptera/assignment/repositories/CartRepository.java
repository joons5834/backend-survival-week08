package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.models.CartItem;
import kr.megaptera.assignment.models.ProductId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<CartItem, ProductId> {
    List<CartItem> findAll();
}
