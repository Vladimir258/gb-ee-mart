package ru.gb.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.model.Product;

import java.util.ArrayList;
import java.util.Objects;

@Component
@Scope("prototype")
public class Cart {
    private ProductRepository repository;
    private ArrayList<Product> listProduct = new ArrayList<>();

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    void showCart() {
        for (Product p: listProduct) {
            System.out.println(p.getInfoProduct());
        }
    }

    void addById(Integer id) {
        listProduct.add(repository.findById(id));
    }

    void deleteById(Integer id) {
        int index = -1;
        for (Product p: listProduct) {
            if(Objects.equals(id, p.getId())) {
                index = listProduct.indexOf(p);
            }
        }
        listProduct.remove(index);
    }
}
