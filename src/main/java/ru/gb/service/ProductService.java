package ru.gb.service;

import ru.gb.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> createProducts() {
        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            products.add(new Product(i, "product" + i, i*1000));
        }
        return products;
    }
}
