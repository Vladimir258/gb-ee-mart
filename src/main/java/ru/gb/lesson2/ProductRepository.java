package ru.gb.lesson2;

import org.springframework.stereotype.Component;
import ru.gb.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1,"Apple",5.0f),
                new Product(2,"Milk",7.0f),
                new Product(3, "Juice", 9.0f)
        ));
    }

    public Product findById(Integer id) {
        return products
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
