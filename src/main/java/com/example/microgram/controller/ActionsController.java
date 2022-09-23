//package com.example.microgram.controller;
//
//import com.example.microgram.entity.User;
////import com.example.microgram.service.UsersService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//
//public class ActionsController {
//
//    @Autowired
//    //UsersService usersService;
//
//    @RequestMapping(method = RequestMethod.GET, value = "/")
//    public String start() {
//        return "start";
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/hello")
//    public String helloMicrogram(@RequestParam(name = "name", required = false, defaultValue = "wrong") String name, Model model) {
//        model.addAttribute("name", name);
//        return "hello";
//    }
//
//    @RequestMapping(method = RequestMethod.GET, value = "/test")
//    public String test(@RequestParam(name = "name", required = false, defaultValue = "wrong") String name, Model model) {
//        model.addAttribute("name", name);
//        return "test";
//    }
//}
