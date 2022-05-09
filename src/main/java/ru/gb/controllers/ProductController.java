package ru.gb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.gb.entity.Product;
import ru.gb.services.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> showProductsPage() {
        return productService.findAll();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam BigDecimal delta) {
        productService.changeCost(productId, delta);
    }

// TODO Добавление продукта

//    @RequestMapping(params="products/add", method = RequestMethod.GET)
//    public String getAddProductPage() {
//        return "product_add_page";
//    }
//
//    @RequestMapping(params="products/add", method = RequestMethod.POST)
//    public void createProduct(Product product) {
//        productService.insert(product);
//    }


    // TODO Сделать на странице shop
    @GetMapping("products/{id}")
    public Optional<Product> showProductPage(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return product;
    }
}
