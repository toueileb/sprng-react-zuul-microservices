package org.sid.service;

import org.sid.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findByUsername(String username);

    List<String> findUsers(List<Long> idList);
}