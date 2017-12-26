package com.xmair.oauth.controller;


import com.xmair.oauth.entity.User;
import com.xmair.oauth.mapper.test1.User1Mapper;
import com.xmair.oauth.mapper.test2.User2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
public class Test1Controller {

    @Autowired
    private User1Mapper user1Mapper;

    @Autowired
    private User2Mapper user2Mapper;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = user1Mapper.getAll();
        return users;
    }

    @ApiIgnore
    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user = user2Mapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        user2Mapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(User user) {
        user2Mapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }

}