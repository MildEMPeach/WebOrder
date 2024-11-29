package org.mildempeach.service;

import org.mildempeach.entity.Instrument;
import org.mildempeach.entity.User;
import org.mildempeach.mapper.InstrumentMapper;
import org.mildempeach.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public User getUserByNameAndPassword(String username, String password) {
        return userMapper.getUserByNameAndPassword(username, password);
    }

    public void insertUser(String username, String password) {
        userMapper.insertUser(username, password);
    }

}
