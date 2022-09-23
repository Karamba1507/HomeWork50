package com.example.microgram.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Publication {
    private Integer id;
    private Integer userId;
    //private String photo;
    private String description;
//    private String postFrom;
//    private String postOn;
//    private LocalDateTime post;

    public Publication() {
        this.id = id;
        this.userId = userId;
        //this.photo = photo;
        this.description = description;
//        this.postFrom = postFrom;
//        this.postOn = postOn;
//        this.post = post;
    }
}
