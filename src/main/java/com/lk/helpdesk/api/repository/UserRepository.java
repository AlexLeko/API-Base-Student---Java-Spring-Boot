package com.lk.helpdesk.api.repository;

import com.lk.helpdesk.api.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}
