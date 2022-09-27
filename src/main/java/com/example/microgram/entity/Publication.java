package com.example.microgram.entity;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publication {
    private int id;
    private int userId;
    private String link;
    private String description;
    private LocalDateTime post;
}
