package com.example.bus.repository;


import com.example.bus.api.response.user.UserResponse;
import com.example.bus.entity.Bus;
import com.example.bus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {




    @Query(value = "SELECT * FROM user WHERE user_id = :userId",nativeQuery = true)
    public UserResponse getDataByUserId(@Param("userId") Long userId);

}
