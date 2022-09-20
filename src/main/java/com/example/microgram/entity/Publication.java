package com.example.microgram.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Publication {
    private String photo;
    private String description;
    private String postFrom;
    private String postOn;
    private LocalDateTime post;

    public Publication(String photo, String description, String postFrom, String postOn, LocalDateTime post) {
        this.photo = photo;
        this.description = description;
        this.postFrom = postFrom;
        this.postOn = postOn;
        this.post = post;
    }
}
