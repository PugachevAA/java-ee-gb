package ru.gb.lesson3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private Integer id;
    private String title;
    private int cost;

    public String getInfo() {
        return id + ". " + title + ", " + cost + "руб.";
    }
}
