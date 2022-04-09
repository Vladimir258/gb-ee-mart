package ru.gb.repository;

import org.springframework.stereotype.Component;
import ru.gb.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1, "Monitor", 300f),
                new Product(2, "Keyboard", 5f),
                new Product(3, "Mouse", 4f),
                new Product(4, "Processor", 700f),
                new Product(5, "Memory", 200f)
        ));
    }

    public Product findById(Integer id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}
