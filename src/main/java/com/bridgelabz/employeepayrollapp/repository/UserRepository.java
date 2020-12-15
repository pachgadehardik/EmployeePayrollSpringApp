package com.bridgelabz.employeepayrollapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employeepayrollapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * @param userName
     * @param userPassWord
     * @return
     */
    @Query(value = "Select * from userlogin where user_name = ?1 and user_password=?2 Limit 1", nativeQuery = true)
    Optional<User> findUserByUserNameandUserPassword(String userName, String userPassWord);
}
