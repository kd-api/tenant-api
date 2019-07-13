package com.krushidj.tenantapp.dao;

import com.krushidj.tenantapp.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface LoginDAO extends JpaRepository<LoginEntity, Long> {

    @Query(value = "SELECT u.user_id,u.first_name,u.last_name,u.email,u.password,u.phone,u.role,u.created_at,u.last_login,u.active" +
            " FROM user u WHERE phone=:phone AND password=:password AND active=1", nativeQuery = true)
    LoginEntity login(@Param("phone") String phone, @Param("password") String password);

}
