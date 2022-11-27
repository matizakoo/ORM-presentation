package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import com.example.demo.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void save(Category category){
        categoryRepository.save(category);
    }

    public ArrayList<Category> listOfCategories(){
        return (ArrayList<Category>) categoryRepository.findAll();
    }

    public Category getCategory(Integer id){
        return categoryRepository.findById(id).get();
    }

    public Category findCategory(Integer id){
        return categoryRepository.findById(id).get();
    }

    public void categoryEdit(Category category, String name){
        category.setName(name);
        save(category);
    }

    @Transactional
    public void deleteCategory(Integer id){
        categoryRepository.delete(getCategory(id));
    }
}
