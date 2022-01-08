package ru.gb.lesson2.hello;

public interface MessageRender {
    void render();
    //void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
