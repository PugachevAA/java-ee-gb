package ru.gb.lesson2.homework.interfaces;

import ru.gb.lesson2.homework.entity.Product;

import java.util.Map;

public interface Cart {
    void addProduct(int id, int count);
    void deleteProduct(int id, int count);
    Map<Product, Integer> showCartList();
}

