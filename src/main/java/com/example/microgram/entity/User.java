
package com.example.microgram.entity;

import lombok.Data;


@Data
public class User {
    private Integer id;
    private String name;
    private String profile;
    private String email;
//    private String password;
//    private User subscriptionOn;                  //На кого подписался
//    private Integer countInfo;
//    private LocalDateTime subWhen;                //Когда подписался

    public User() {
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.email = email;
    }
}
