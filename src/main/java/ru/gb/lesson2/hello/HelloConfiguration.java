package ru.gb.lesson2.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@ComponentScan
@PropertySource("application.properties")
public class HelloConfiguration {
    @Value("${listOfFoodStuff}")
    String[] food;

    @PostConstruct
    public void init() {
        System.out.println("Array of food: " + Arrays.asList(food));
    }
//    @Bean
//    public MessageProvider provider() {
//        return new WantMessageProvider();
//    }
//
//    @Bean
//    public MessageRender render() {
//        MessageRender messageRender = new ConsoleMessageRender();
//        messageRender.setMessageProvider(provider());
//        return messageRender;
//    }
}
