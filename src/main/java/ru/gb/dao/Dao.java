package ru.gb.dao;

import ru.gb.entity.Product;

import java.util.List;

public interface Dao {
    List<Product> findAll();
    public String findNameById(Long id);
    Product findById(Long id);
    void insert(Product product);
    void update(Product product);
    Product save(Product product);
    void deleteById(Long id);
}
