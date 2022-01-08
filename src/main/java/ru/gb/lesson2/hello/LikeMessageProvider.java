package ru.gb.lesson2.hello;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Profile("like")
@Scope("prototype")
public class LikeMessageProvider implements MessageProvider{

    @InjectFoodStuff
    String foodStuff;

    @Override
    public String getMessage() {
        return  "I like cookie " + foodStuff;
    }
}
