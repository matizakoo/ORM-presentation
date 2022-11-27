package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model){
        ArrayList<User> list = userService.listOfUsers();
        for(User e: list){
            logger.info(e.getName() + " " + e.getSurname());
        }
        model.addAttribute("users", userService.listOfUsers());
        model.addAttribute("categories", categoryService.listOfCategories());
        model.addAttribute("products", productService.listOfProductes());
        return "index";
    }

    @PostMapping("/register/user")
    public String registerUser(@Validated User user){
        userService.save(user);
        return "redirect:/";
    }

    @PostMapping("/register/product")
    public String registerProduct(@Validated Product product, @RequestParam("id") Integer id) {
        product.setCategory(categoryService.findCategory(id));
        productService.save(product);
        return "redirect:/";
    }

    @PostMapping("/register/category")
    public String registerCategory(@Validated Category category){
        categoryService.save(category);
        return "redirect:/";
    }

    @PostMapping("/edit/category")
    public String putProduct(@RequestParam("name") String name, @RequestParam("id") Integer id){
        categoryService.categoryEdit(categoryService.findCategory(id), name);
        return "redirect:/";
    }

    @PostMapping("/delete/product")
    public String deleteProduct(@RequestParam("id") Integer id){
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @PostMapping("/delete/category")
    public String deleteCategory(@RequestParam("id") Integer id){
        List<Product> list = productService.listOfProductes();
        for(Product e: list){
            if(Objects.equals(e.getCategory().getId(), id)){
                logger.info("jest");
                return "redirect:/";
            }
        }
        categoryService.deleteCategory(id);
        logger.info("nie ma");
        return "redirect:/";
    }
}
