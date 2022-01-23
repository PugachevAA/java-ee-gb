package ru.gb.lesson2.homework.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.gb.lesson2.homework.entity.Product;
import ru.gb.lesson2.homework.interfaces.Cart;
import ru.gb.lesson2.homework.interfaces.ProductRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MainCart implements Cart {
    Map<Product, Integer> cartList;

    @Autowired
    ProductRepository pr;

    public MainCart() {
        this.cartList = new HashMap<Product, Integer>() {
        };
    }

    @Override
    public void addProduct(int id, int count) {
        Product product = pr.getProduct(id);

        if (product != null) {
            cartList.put(pr.getProduct(id), count);
        }
    }

    @Override
    public Map<Product, Integer> showCartList() {
        return Collections.unmodifiableMap(cartList);
    }

    @Override
    public void deleteProduct(int id, int count) {
        if (cartList.get(pr.getProduct(id)) != null) {
            int countInCart = cartList.get(pr.getProduct(id));
            if (count < countInCart) {
                cartList.replace(pr.getProduct(id), countInCart, countInCart-count);
            } else {
                cartList.remove(pr.getProduct(id));
            }
        }
    }
}
