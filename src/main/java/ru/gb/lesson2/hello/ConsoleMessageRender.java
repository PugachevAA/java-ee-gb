package ru.gb.lesson2.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Scope("prototype")
public class ConsoleMessageRender implements MessageRender{

//    private final MessageProvider messageProvider;

//    public ConsoleMessageRender(MessageProvider messageProvider) {
//        this.messageProvider = messageProvider;
//    }

    @Override
    public void render() {
        System.out.println(getMessageProvider().getMessage());
    }

    @Override
    @Lookup
    public MessageProvider getMessageProvider() {
        return null;
    }
}
