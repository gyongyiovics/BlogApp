package application.controllers;

import application.models.Blog;
import application.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String getHello() {
        return "HelloBello!";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Long id) {
        //TODO
        return null;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserData() {
        //TODO
        return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register() {
        //TODO
        return null;
    }

}
