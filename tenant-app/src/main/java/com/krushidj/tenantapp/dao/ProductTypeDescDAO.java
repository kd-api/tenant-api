package com.krushidj.tenantapp.dao;
import com.krushidj.tenantapp.entity.ProductTypeDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProductTypeDescDAO extends JpaRepository<ProductTypeDesc,Integer> {
    @Query(nativeQuery = true,value = "SELECT COUNT (*) FROM product_type WHERE name=:name")
    public int isAvailable(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "UPDATE product_type pt SET pt.name=:name,pt.description=:description WHERE pt.id=:id")
    public void updateProductType(@Param("id") int id,
                   @Param("name") String name,@Param("description") String description);
}
