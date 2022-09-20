package com.example.microgram.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private String text;
    private LocalDateTime commentDate;

    public Comment(String text, LocalDateTime commentDate) {
        this.text = text;
        this.commentDate = commentDate;
    }
}
