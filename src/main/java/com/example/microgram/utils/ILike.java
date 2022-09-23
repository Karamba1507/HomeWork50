package com.example.microgram.utils;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ILike {
    private String fromWhom;
    private String forWhat;
    private LocalDateTime time;

    public ILike(String fromWhom, String forWhat, LocalDateTime time) {
        this.fromWhom = fromWhom;
        this.forWhat = forWhat;
        this.time = time;
    }
}
