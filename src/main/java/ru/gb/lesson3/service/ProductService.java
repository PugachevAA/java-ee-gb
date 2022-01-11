package ru.gb.lesson3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import ru.gb.lesson3.MessageProvider;
import ru.gb.lesson3.entity.Product;
import ru.gb.lesson3.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository messageRepository;

    public Product save(Product product) {
        return messageRepository.save(product);
    }

    public Product edit(Product product) {
        return messageRepository.edit(product);
    }

    public Product findById(int id) {
        return messageRepository.findById(id).orElse(new Product());
    }

    public Iterable<Product> findAll() {
        return messageRepository.findAll();
    }

    public long count() {
        return messageRepository.count();
    }

    public void deleteById(int id) {
        messageRepository.deleteById(id);
    }

//    public Product getRandomMessage() {
//        return Product.builder()
//                .body(getMessageProvider().getMessage())
//                .from("Randomizer")
//                .to("browser")
//
//                .id(product.getId())
//                .title(product.getTitle())
//                .cost(product.getCost())
//                .build();
//                .build();
//    }
//
//    @Lookup
//    public MessageProvider getMessageProvider() {
//        return null;
//    }
}
