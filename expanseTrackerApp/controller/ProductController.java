package com.expense.expanseTrackerApp.controller;

import com.expense.expanseTrackerApp.model.Product;
import com.expense.expanseTrackerApp.model.User;
import com.expense.expanseTrackerApp.repository.IProductRepo;
import com.expense.expanseTrackerApp.repository.ITokenRepo;
import com.expense.expanseTrackerApp.service.ProductService;
import com.expense.expanseTrackerApp.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private IProductRepo iProductRepo;

    @Autowired
    private TokenService authService;
    @Autowired
    private ITokenRepo iTokenRepo;

    //add product
    @PostMapping("/product/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product, @RequestParam String email, @RequestParam String token){
        HttpStatus status;
        String msg = "";
        if(authService.authenticate(email,token))
        {
            User user =  authService.findUserByToken(token);
            product.setUser(user);
            productService.addProduct(product);
            msg = " Product added successfully";
            status = HttpStatus.OK;
        }
        else
        {
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }

    //get all products
    @GetMapping("/product/getAll")
    public ResponseEntity<List<Product>> getAllProduct(@RequestParam String email, @RequestParam String token){
        HttpStatus status;
        List<Product> productList = null;
        if(authService.authenticate(email,token))
        {
            productList = productService.getAllProducts(token);
            status = HttpStatus.OK;
        }
        else
        {
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<List<Product>>(productList , status);
    }

    //delete product
    @DeleteMapping("/product/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam Integer productId, @RequestParam String token){
        Integer productUserId = iProductRepo.findUserIdByProductId(productId);
        Integer tokenUserId = iTokenRepo.findUserIdByToken(token);
        HttpStatus status;
        String msg = "";
        if(productUserId == tokenUserId){
            productService.deleteProduct(productId);
            msg = "Product deleted";
            status = HttpStatus.OK;
        }else{
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>(msg , status);
    }

    //update product
    @PutMapping("/product/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product product, @RequestParam Integer productId, @RequestParam String token){
        Integer productUserId = iProductRepo.findUserIdByProductId(productId);
        Integer tokenUserId = iTokenRepo.findUserIdByToken(token);
        HttpStatus status;
        String msg = "";
        if(productUserId == tokenUserId){
            productService.updateProduct(product,productId);
            msg = "Product updated";
            status = HttpStatus.OK;
        }else{
            msg = "Invalid user";
            status = HttpStatus.FORBIDDEN;
        }
        return new ResponseEntity<String>(msg , status);
    }

    //get total expense
    @GetMapping("/product/total-expense-month")
    public Double getTotalExpense(@RequestParam Integer month, @RequestParam Integer year, @RequestParam Integer userId){
        return iProductRepo.findExpense(month,year,userId);
    }
}
