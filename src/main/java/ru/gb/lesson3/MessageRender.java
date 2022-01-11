package ru.gb.lesson3;

public interface MessageRender {
    void render();
    //void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
