package com.krushidj.tenantapp.controller;

import com.krushidj.tenantapp.entity.LoginEntity;
import com.krushidj.tenantapp.entity.Product;
import com.krushidj.tenantapp.entity.ProductTypeDesc;
import com.krushidj.tenantapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    // here method for user

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void create(@RequestBody LoginEntity entity) {
        adminService.create(entity);
    }

    @RequestMapping(value = "/findBPh", method = RequestMethod.GET)
    List<LoginEntity> findPhoneNumberByUser(@RequestParam("phoneQuery") String phoneQuery) {
        return adminService.findPhoneNumberByUser(phoneQuery);
    }

    // here crud methods for product which is usefull for specific type.
    // which is usefull for manuplate and crud operation on UI side.

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    void saveProduct(@RequestBody Product product) {
        adminService.saveProduct(product);
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    List<Product> findAllProduct() {
        return adminService.findAllProduct();
    }

    // here crud methods for product char id which is usefull for specific type.
    // which is usefull for manuplate and crud operation on UI side.

    @RequestMapping(value = "/productCharType", method = RequestMethod.POST)
    void saveproductCharType(@RequestBody ProductTypeDesc productTypeDesc) {
        adminService.saveProductType(productTypeDesc);
    }

    @RequestMapping(value = "/productCharType", method = RequestMethod.GET)
    boolean isAvailableproductCharType(@RequestParam("name") String name) {
        return adminService.isAvailable(name);
    }

    @RequestMapping(value = "/productCharType", method = RequestMethod.PUT)
    void updateproductCharType(@RequestBody ProductTypeDesc productTypeDesc) {
        adminService.updateProductType(productTypeDesc);
    }

    @RequestMapping(value = "/productCharTypeAll", method = RequestMethod.GET)
    List<ProductTypeDesc> getAllproductCharType() {
        return adminService.getAll();
    }
}

