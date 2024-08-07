package com.example.cloudproviders.repositories;

import com.example.cloudproviders.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepoImpl implements UserRepository{
    private Map<Long, User> userMap;

    public UserRepoImpl() {
        this.userMap = new HashMap<>();
    }

    @Override
    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(userMap.size() + 1);
        }
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findUserById(long userId) {
        return Optional.ofNullable(userMap.get(userId));
    }
}
