
package com.example.microgram.entity;

import lombok.Data;


@Data
public class User {
    private int id;
    private String name;
    private String profile;
    private String email;
    private String password;
//    private User subscriptionOn;                  //На кого подписался
//    private Integer countInfo;
//    private LocalDateTime subWhen;                //Когда подписался


    public User() {
    }

    public User(int id, String name, String profile, String email, String password) {
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.email = email;
        this.password = password;
    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", profile='" + profile + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
}
