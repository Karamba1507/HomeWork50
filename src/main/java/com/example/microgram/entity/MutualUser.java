package com.example.microgram.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class MutualUser {
    private String profile;
    private String subscriptionOn;                //На кого подписался
    private LocalDateTime subWhen;                //Когда подписался

    public MutualUser(String profile, String subscriptionOn) {
        this.profile = profile;
        this.subscriptionOn = subscriptionOn;
    }
}
