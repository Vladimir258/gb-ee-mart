package ru.gb.controller;

import ru.gb.model.Product;
import ru.gb.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "products_page";
    }

    @GetMapping("products/{id}")
    public String showProductPage(Model model, @PathVariable Integer id) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }


    @RequestMapping(params="products/add", method = RequestMethod.GET)
    public String getAddProductPage(Model model, Product product) {
        model.addAttribute("product", product);
        return "product_add_page";
    }

    @RequestMapping(params="products/add", method = RequestMethod.POST)
    public String createProduct(Product product) {
        productRepository.addProduct(product);
        return "products_page";
        //Cost: <input type="text" th:field="*{cost}"/>
    }

}
