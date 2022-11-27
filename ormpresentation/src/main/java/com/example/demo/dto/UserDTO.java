package com.example.demo.dto;

public class UserDTO {
    private String name;
    private String surname;
    private Integer age;

    public UserDTO(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public UserDTO() {
    }
}
