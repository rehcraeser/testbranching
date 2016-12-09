package info.gumanist.controller;

import info.gumanist.domain.User;
import info.gumanist.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userManager.getAllUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") Long id) {
        userManager.deleteUser(id);
    }
}