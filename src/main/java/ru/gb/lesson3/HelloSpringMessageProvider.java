package ru.gb.lesson3;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("hello")
public class HelloSpringMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello Spring";
    }
}
