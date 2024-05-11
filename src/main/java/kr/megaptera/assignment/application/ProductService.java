package kr.megaptera.assignment.application;

import kr.megaptera.assignment.dtos.ProductDto;
import kr.megaptera.assignment.models.Product;
import kr.megaptera.assignment.models.ProductId;
import kr.megaptera.assignment.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream().map(ProductDto::new)
                .toList();
    }

    public void createProduct(ProductDto productDto) {
        String newId = ProductId.generate();
        Product newProduct = new Product(ProductId.of(newId),
                productDto.getName(), productDto.getPrice());
        productRepository.save(newProduct);
    }
}
