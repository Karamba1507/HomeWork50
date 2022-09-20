/*
Вариант 1
 */

package com.example.microgram.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UsersAdd {
    private List<User> users = new ArrayList<>();

    public UsersAdd() {
        this.users = users;
    }

    public void fillUserList() {
        UUID id = UUID.randomUUID();

        User user1 = new User(id, "name1", "14@.kg", "000a", 0);
        User user2 = new User(id, "name2", "16@.kg", "000b", 0);
        User user3 = new User(id, "name3", "18@.kg", "000c", 0);
        User user4 = new User(id, "name4", "20@.kg", "000d", 0);
        User user5 = new User(id, "name5", "22@.kg", "000e", 0);



        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

    }
}
