package com.app.breadapp.repositories;

import com.app.breadapp.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
}
