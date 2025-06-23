package com.example.demo.repository;

import com.example.demo.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private final Map<String, String> users = new HashMap<>();
    private final Map<String, List<Authorities>> userAuthorities = new HashMap<>();

    public UserRepository() {
        users.put("admin", "123");
        users.put("user", "pass");

        userAuthorities.put("admin", Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE));
        userAuthorities.put("user", Arrays.asList(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (!users.containsKey(user) || !users.get(user).equals(password)) {
            return Collections.emptyList();
        }
        return userAuthorities.getOrDefault(user, Collections.emptyList());
    }
}