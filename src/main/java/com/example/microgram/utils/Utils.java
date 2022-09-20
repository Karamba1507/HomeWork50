/*
Вариант 2
 */

package com.example.microgram.utils;

import com.example.microgram.entity.UsersAdd;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static final Gson gson =  new Gson();

    public static List<UsersAdd> getUsers() {
        Type listType = new TypeToken<ArrayList<UsersAdd>>() {}.getType();
        try (Reader reader = new FileReader("users.json")) {
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public static void writeUsers(List<UsersAdd> books) throws IOException {
        try (Writer writer = new FileWriter("users.json")) {
            String json = gson.toJson(books);
            writer.write(json);
        }
    }
}
