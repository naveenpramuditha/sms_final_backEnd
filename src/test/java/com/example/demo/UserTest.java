package com.example.student_managemnet_system;


import com.example.demo.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testGetRegistrationnumber() {
        User user = new User();
        user.setRegno("D/BSE/21/0003");
        assertEquals("D/BSE/21/0003", user.getRegno());

    }

    @Test
    public void testGetFirstname() {
        User user = new User();
        user.setUsername("Gayashani");
        assertEquals("Gayashani", user.getUsername());
    }

    @Test
    public void testUserName() {
        User user = new User();
        user.setName("Divynjalee");
        assertEquals("Divynjalee", user.getName());
    }

    @Test
    public void testGetEmail() {
        User user = new User();
        user.setEmail("gayaherath9468@gmail.com");
        assertEquals("gayaherath9468@gmail.com", user.getEmail());
    }





}