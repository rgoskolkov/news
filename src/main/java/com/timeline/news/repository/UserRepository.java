package com.timeline.news.repository;

import com.timeline.news.model.jpa.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> getByUsername(String userName);
}
