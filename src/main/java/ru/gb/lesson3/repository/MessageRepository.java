package ru.gb.lesson3.repository;

import org.springframework.stereotype.Component;
import ru.gb.lesson3.entity.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MessageRepository {
    List<Message> messages = new ArrayList<>();

    public Message save(Message message) {
        messages.add(message);
        message.setId(messages.size() - 1);
        return Message.builder()
                .id(message.getId())
                .body(message.getBody())
                .from(message.getFrom())
                .to(message.getTo())
                .build();
    }

    public Message edit(Message message) {
        return messages.set(message.getId(), message);
    }

    public Optional<Message> findById(int id) {
        if (id < messages.size()) {
            return Optional.ofNullable(messages.get(id));
        } else {
            return Optional.empty();
        }
    }

    public Iterable<Message> findAll() {
        return new ArrayList<>(messages);
    }

    public long count() {
        return messages.size();
    }

    public void deleteById(int id) {
        if (id < messages.size()) {
            messages.remove(id);
        }
    }
}
