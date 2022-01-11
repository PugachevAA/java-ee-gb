package ru.gb.lesson2.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private String title;
    private int cost;

    public String getInfo() {
        return id + ". " + title + ", " + cost + "руб.";
    }
}
