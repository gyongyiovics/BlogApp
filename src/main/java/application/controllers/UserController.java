package application.controllers;

import application.dtos.UserDTO;
import application.models.User;
import application.repositories.UserRepository;
import application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    UserService service;
    //UserRepository repository;

    @Autowired
    public UserController(UserService service/*, UserRepository repository*/) {
        this.service = service;
        //this.repository = repository;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String getHello() {
        return "HelloBello!";
    }

    //@PreAuthorize("hasAnyAuthority()")
    @PreAuthorize("hasAuthority('CAN_READ_NOTE')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id) {
        if(id != null) {
            return service.getUserbyId(id);
        }
        return null;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUserData() {
        return service.getLoggedInUser();
    }


    @PostMapping(value = "/register")
    public String register(@RequestBody UserDTO userDTO) {
        if(service.registerUser(userDTO)) {
            return "ok, registered";
        }
        return "not ok";
    }

    /*
    @GetMapping(value = "/register")
    public String register() {
        if(service.registerUser()) {
            return "ok, registered";
        }
        return "not ok";
    }
    */

    //https://medium.com/javarevisited/a-simple-user-authentication-api-made-with-spring-boot-4a7135ff1eca
    //https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial
    //https://andriperera.medium.com/create-a-rest-api-in-spring-boot-with-mysql-b250ff3aaa9b
}
