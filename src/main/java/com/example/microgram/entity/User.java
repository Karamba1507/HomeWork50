/*
Вариант 1
 */

package com.example.microgram.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data

public class User {
    private UUID id;
    private String profile;
    private String email;
    private String password;
    private User subscriptionOn;                  //На кого подписался
    private Integer countInfo;
    private LocalDateTime subWhen;                //Когда подписался

    public User(UUID id, String profile, String email, String password, Integer countInfo) {
        this.id = id;
        this.profile = profile;
        this.email = email;
        this.password = password;
        this.countInfo = countInfo;
    }
}
