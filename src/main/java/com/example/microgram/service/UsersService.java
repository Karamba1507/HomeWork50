/*
Вариант 1
 */

package com.example.microgram.service;

import com.example.microgram.entity.User;
import com.example.microgram.entity.UsersAdd;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Data
public class UsersService {
    private List<User> users;

    @PostConstruct
    public void fillUsers() {

        UsersAdd usersAdd = new UsersAdd();

        this.users = usersAdd.getUsers();

    }
}
