package kr.megaptera.assignment.controllers;

import kr.megaptera.assignment.application.ProductService;
import kr.megaptera.assignment.dtos.ListProductDto;
import kr.megaptera.assignment.dtos.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ListProductDto list() {
        List<ProductDto> allProducts = productService.getAllProducts();
        return new ListProductDto(allProducts);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
    }
}
