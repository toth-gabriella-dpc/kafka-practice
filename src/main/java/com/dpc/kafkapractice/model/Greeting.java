package com.dpc.kafkapractice.model;

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
