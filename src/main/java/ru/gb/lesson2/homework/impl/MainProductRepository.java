package ru.gb.lesson2.homework.impl;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.lesson2.homework.entity.Product;
import ru.gb.lesson2.homework.interfaces.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MainProductRepository implements ProductRepository {

    private List<Product> products;

    public MainProductRepository() {
        products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(new Product(i, "Product №" + i, i*1000));
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
