package ru.gb.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    Integer id;
    String title;
    Float cost;

    public String getInfoProduct() {
        return id + ". " + title + ": " + cost + "$. ";
    }
}
