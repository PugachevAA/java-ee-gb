package ru.gb.service;

import ru.gb.entity.Cat;

import java.util.Arrays;
import java.util.List;

public class CatService {
    public Cat createNewCat() {
        List<Cat> cats = Arrays.asList(
                new Cat("Murzik", 1, null),
                new Cat("Finik", 1, null)

        );
        return new Cat("Barsik", 3, cats);
    }
}
