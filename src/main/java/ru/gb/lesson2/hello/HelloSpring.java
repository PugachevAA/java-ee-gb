package ru.gb.lesson2.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class HelloSpring {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfiguration.class);
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        for (int i = 0; i < 5; i++) {
            MessageRender messageRender = context.getBean(MessageRender.class);
            messageRender.render();
        }
        context.close();
    }
}