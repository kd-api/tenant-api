package com.krushidj.tenantapp.dao;

import com.krushidj.tenantapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductDAO extends JpaRepository<Product,Integer> {

    //public Product findAllProduct(boolean active);
}
