package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void save(Product product){
        productRepository.save(product);
    }

    public ArrayList<Product> listOfProductes(){
        return (ArrayList<Product>) productRepository.findAll();
    }

    public Product getProduct(Integer id){
        return productRepository.getById(id);
    }
    @Transactional
    public void deleteProduct(Integer id){
        productRepository.delete(getProduct(id));
    }

}
