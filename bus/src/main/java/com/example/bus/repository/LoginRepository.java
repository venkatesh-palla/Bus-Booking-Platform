package com.example.bus.repository;

import com.example.bus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM user WHERE email = :email AND phone_number = :phoneNumber", nativeQuery = true)
    User login(@Param("email") String email, @Param("phoneNumber") String phoneNumber);

}
