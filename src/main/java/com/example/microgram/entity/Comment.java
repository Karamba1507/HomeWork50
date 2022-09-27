package com.example.microgram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int comment_id;
    private User user_id;
    private Publication publication_id;
    private String text;
    private LocalDateTime commentDate;
}
