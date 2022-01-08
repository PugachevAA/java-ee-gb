package ru.gb.lesson2.homework.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.lesson2.homework.entity.Product;
import ru.gb.lesson2.homework.interfaces.Cart;
import ru.gb.lesson2.homework.interfaces.ProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MainCart implements Cart {
    List<Product> cartList;

    @Autowired
    ProductRepository pr;

    public MainCart() {
        this.cartList = new ArrayList<>();
    }

    @Override
    public void addProduct(int id, int count) {
        Product product = pr.getProduct(id);

        if (product != null) {
            for (int i = 0; i < count; i++) {
                cartList.add(pr.getProduct(id));
            }
        }
    }

    @Override
    public List<Product> showCartList() {
        return Collections.unmodifiableList(cartList);
    }

    @Override
    public void deleteProduct(int id) {
        cartList.removeIf(product -> product.getId() == id);
    }
}
