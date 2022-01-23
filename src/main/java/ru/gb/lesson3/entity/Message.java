package ru.gb.lesson3.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer id;
    private String body;
    private String from;
    private String to;
}
