package com.dpc.kafkapractice3.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Greeting {
    private String message;
    private String name;
}
