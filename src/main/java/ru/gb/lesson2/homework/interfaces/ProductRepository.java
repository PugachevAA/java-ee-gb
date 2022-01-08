package ru.gb.lesson2.homework.interfaces;

import ru.gb.lesson2.homework.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();
    Product getProduct(int id);
}
