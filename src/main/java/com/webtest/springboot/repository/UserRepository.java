package com.webtest.springboot.repository;

import com.webtest.springboot.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
    List<User> findByLastName(String lastName);
}
