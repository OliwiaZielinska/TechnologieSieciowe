package com.example.technologiesieciowelista1.repositories;

import com.example.technologiesieciowelista1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //User findByUserName(String userName);
    @Query(value = "SELECT u FROM User u WHERE u.name = :loginForm")
    User findByUserName(String loginForm);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.name = :name")
    boolean existsByName(String name);

    @Query("SELECT COUNT(u) > 0 FROM User u WHERE u.id = :userId")
    boolean existsById(@Param("userId") Integer userId);
}