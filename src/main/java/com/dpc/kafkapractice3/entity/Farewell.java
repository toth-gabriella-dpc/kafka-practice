package com.dpc.kafkapractice3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Farewell {
    private String message;
    private Integer remainingMinutes;
}
