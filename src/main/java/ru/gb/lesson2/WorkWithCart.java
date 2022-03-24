package ru.gb.lesson2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class WorkWithCart {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext("ru");

        Cart cart1 = context.getBean(Cart.class);
        System.out.println("--------------");
        cart1.showCart();
        System.out.println("--------------");
        cart1.addById(3);
        cart1.addById(1);
        cart1.showCart();
        System.out.println("--------------");
        cart1.deleteById(1);
        cart1.showCart();
        System.out.println("--------------");

        context.close();
    }
}
