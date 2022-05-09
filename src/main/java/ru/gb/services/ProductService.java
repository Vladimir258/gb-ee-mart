package ru.gb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entity.Product;
import ru.gb.dao.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
    public void changeCost(Long productId, BigDecimal delta) {
        Product product = productRepository.findById(productId).orElseThrow(RuntimeException::new);
        product.setCost(product.getCost().add(delta));
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void insert(Product product) {
        productRepository.save(product);
    }
}
