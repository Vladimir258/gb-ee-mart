package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.entity.*;
import ru.gb.dao.*;

@Controller
public class ProductController {

    private Dao productManager;

    @Autowired
    public void setProductManager(Dao productManager) {
        this.productManager = productManager;
    }

    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productManager.findAll());
        return "products_page";
    }

    @GetMapping("products/{id}")
    public String showProductPage(Model model, @PathVariable Long id) {
        Product product = productManager.findById(id);
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
        productManager.insert(product);
        return "products_page";
        //Cost: <input type="text" th:field="*{cost}"/>
    }

}
