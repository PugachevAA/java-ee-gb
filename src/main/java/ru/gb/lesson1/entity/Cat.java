package ru.gb.lesson1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Cat {
    private String name;
    private int age;
    private List<Cat> children;

}
