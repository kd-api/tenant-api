package com.krushidj.tenantapp.service;

import com.krushidj.tenantapp.dao.AdminDAO;
import com.krushidj.tenantapp.dao.ProductDAO;
import com.krushidj.tenantapp.dao.ProductTypeDescDAO;
import com.krushidj.tenantapp.entity.LoginEntity;
import com.krushidj.tenantapp.entity.Product;
import com.krushidj.tenantapp.entity.ProductTypeDesc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductTypeDescDAO productTypeDescDAO;

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    @Transactional
    public void create(LoginEntity entity) {
        try {
            adminDAO.save(new LoginEntity(entity.getfName(),
                    entity.getlName(),
                    entity.getEmail(),
                    entity.getPhoneNumber(),
                    2,
                    entity.isActive(),
                    entity.getPassword(),
                    new Timestamp(System.currentTimeMillis()),
                    new Timestamp(System.currentTimeMillis())));
        } catch (Exception e) {
            log.error("An error occurred while saving  user . Please contact the Support Team.", e);
            throw e;
        }
    }

    public List<LoginEntity> findPhoneNumberByUser(String phoneQuery) {
        try {
            return adminDAO.findPhoneNumberByUser(phoneQuery);
        } catch (Exception e) {
            log.error("An error occurred while fetching user by phone . Please contact the Support Team.", e);
            throw e;
        }

    }

    @Transactional
    public void saveProduct(Product product) {
        try {
            productDAO.save(product);
        } catch (Exception e) {
            log.error("An error occurred while saving  product . Please contact the Support Team.", e);
            throw e;
        }
    }

    public List<Product> findAllProduct() {
        List<Product> products = null;
        try {
            products = productDAO.findAll();
        } catch (Exception e) {
            log.error("An error occurred while fetching all product . Please contact the Support Team.", e);

        }
        List<Product> products1 = new ArrayList<>();
        products.forEach(
                product -> {
                    if (product.isActive()) {
                        products1.add(product);
                    }
                }
        );
        return products1;
    }

    public void saveProductType(ProductTypeDesc productTypeDesc) {
        try {
            productTypeDescDAO.save(productTypeDesc);
        } catch (Exception e) {
            log.error("An error occurred while saving ProductCharType type . Please contact the Support Team.", e);
            throw e;
        }
    }

    public boolean isAvailable(String name) {
        try {
            return productTypeDescDAO.isAvailable(name) == 1 ? true : false;
        } catch (Exception e) {
            log.error("An error occurred while checking ProductCharType  availble type . Please contact the Support Team.", e);
            throw e;
        }
    }

    // we are still not implemainting this methos Bcoz we use product_type table for separate
    // to maintaining char type hence there we using relation ship
    // so not required to delete product chartype
    public boolean deleteProductType(String name) {
        try {
            return true;
        } catch (Exception e) {
            log.error("An error occurred while deleting ProductCharType  availble type . Please contact the Support Team.", e);
            throw e;
        }
    }

    public void updateProductType(ProductTypeDesc productTypeDesc) {
        try {
            productTypeDescDAO.updateProductType(productTypeDesc.getId(),
                    productTypeDesc.getName(), productTypeDesc.getDescription());

        } catch (Exception e) {
            log.error("An error occurred while updating ProductCharType  availble type . Please contact the Support Team.", e);
            throw e;
        }

    }

    public List<ProductTypeDesc> getAll() {
        try {
            return productTypeDescDAO.findAll();
        } catch (Exception e) {
            log.error("An error occurred while fetching ProductCharType  availble type . Please contact the Support Team.", e);
            throw e;
        }
    }

}