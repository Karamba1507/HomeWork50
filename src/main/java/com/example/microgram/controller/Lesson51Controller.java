package com.example.microgram.controller;

import com.example.microgram.entity.Publication;
import com.example.microgram.entity.User;
import com.example.microgram.homework51.DataBaseConnect;
import com.example.microgram.service.Lesson51Service;
import com.example.microgram.utils.CreateUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
@RequiredArgsConstructor
public class Lesson51Controller {
    private final DataBaseConnect dbService;
    private final Lesson51Service service;
    private final CreateUser createUser;

    @GetMapping(value = "/connect")
    public ResponseEntity<String> getConnection() {
        return new ResponseEntity<>(dbService.openConnection(), HttpStatus.OK);
    }

    @GetMapping(value = "/create")
    public ResponseEntity<String> createTable() {
        return new ResponseEntity<>(service.shouldCreateTable(), HttpStatus.OK);
    }

    @GetMapping(value = "/select")
    public ResponseEntity<String> select(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(service.shouldSelectData(name), HttpStatus.OK);
    }

    @GetMapping(value = "/insert")
    public ResponseEntity<String> insert() {
        service.shouldResultSet();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // HomeWork51
    @GetMapping(value = "/users")
    public ResponseEntity<String> profile(@RequestParam(required = false) String name,
                                          @RequestParam(required = false) String profile,
                                          @RequestParam(required = false) String email) {


        try {

            if (name != null) {

                final User user = service.findUserByProfile(name);
                String responseBody = new ObjectMapper().writeValueAsString(user);
                return new ResponseEntity<>(responseBody, HttpStatus.OK);

            } else if (profile != null) {

                final User user = service.findUserByProfile(profile);
                String responseBody = new ObjectMapper().writeValueAsString(user);
                return new ResponseEntity<>(responseBody, HttpStatus.OK);

            } else if (email != null) {

                final User user = service.findUserByProfile(email);
                String responseBody = new ObjectMapper().writeValueAsString(user);
                return new ResponseEntity<>(responseBody, HttpStatus.OK);

            } else {
                return new ResponseEntity<>("No one parameter found", HttpStatus.BAD_REQUEST);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/publication")
    public ResponseEntity<String> description(@RequestParam(required = false) String description) {

        try {
            if (description != null) {

                final Publication publication = service.choose(description);
                String responseBody = new ObjectMapper().writeValueAsString(publication);
                return new ResponseEntity<>(responseBody, HttpStatus.OK);

            } else {
                return new ResponseEntity<>("No one parameter found", HttpStatus.BAD_REQUEST);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }

//    @GetMapping(value = "/cr")
//    public ResponseEntity<String> index() {
//        User user = null;
//        createUser.saveUser(user);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
