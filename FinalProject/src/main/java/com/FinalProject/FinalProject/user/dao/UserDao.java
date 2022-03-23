package com.FinalProject.FinalProject.user.dao;

import com.FinalProject.FinalProject.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    List<User> findAllByName(String name);
    User findByUserName(String name);

}
