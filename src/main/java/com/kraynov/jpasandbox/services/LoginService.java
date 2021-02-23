package com.kraynov.jpasandbox.services;

import com.kraynov.jpasandbox.domain.User;

public class LoginService {

    public User login(String login, String password) {
        if ("nick".equals(login) && "mike".equals(password)) {
            return new User("nick", "mike");
        }

        return null;
    }
}
