package com.expense.expanseTrackerApp.service;

import com.expense.expanseTrackerApp.model.Product;
import com.expense.expanseTrackerApp.model.User;
import com.expense.expanseTrackerApp.repository.IProductRepo;
import com.expense.expanseTrackerApp.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductRepo iProductRepo;
    @Autowired
    private ITokenRepo iTokenRepo;
    public void addProduct(Product product) {
        iProductRepo.save(product);
    }

    public void getAllProduct() {
    }

    public List<Product> getAllProducts(String token) {
        User user = iTokenRepo.findFirstByToken(token).getUser();
        List<Product> postList = iProductRepo.findByUser(user);
        return postList;
    }

    public void deleteProduct(Integer productId) {
        iProductRepo.deleteById(productId);
    }

    public void updateProduct(Product product, Integer productId) {
        Product existingProduct = iProductRepo.findById(productId).get();
        existingProduct.setProductId(product.getProductId());
        existingProduct.setProductName(product.getProductName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setDate(product.getDate());
        existingProduct.setPrice(product.getPrice());
        iProductRepo.save(existingProduct);
    }

    public Double getExpense(Integer month, Integer year, Integer productUserId) {
        return iProductRepo.findExpense(month,year,productUserId);
    }
}
