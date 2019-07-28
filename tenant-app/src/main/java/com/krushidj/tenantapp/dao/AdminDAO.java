package com.krushidj.tenantapp.dao;

import com.krushidj.tenantapp.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

public interface AdminDAO extends CrudRepository<LoginEntity,Long> {

//    @Query(value = "INSERT INTO user(first_name,last_name,email,phone,role,active,password,created_at) " +
//            "VALUES(:firstName,:lastName,:email,:phone,:role,:active,:password,:createdAt)"
//            ,nativeQuery = true)
//
//   void create(@Param("firstName")String firstName,
//                @Param("lastName")String lastName,
//                @Param("email")String email,
//                @Param("phone")String phone,
//                @Param("role")int role,
//                @Param("active")boolean active,
//                @Param("password")String password,
//                @Param("createdAt")Timestamp createdAt);


//

    LoginEntity save(LoginEntity entity);

    @Query(value = "SELECT u.user_id,u.first_name,u.phone u.created_at from user u where u.phone like :phoneQury%"
           ,nativeQuery = true)
    List<LoginEntity> findPhoneNumberByUser(@Param("phoneQury")String phoneQury);

}
