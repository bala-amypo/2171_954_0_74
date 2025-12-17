package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Studentity;
import com.example.demo.service.studservice;

@RestController
@RequestMapping("/student")
public class Studctl {

    @Autowired
    private Studservice ser;

    //POST
    @PostMapping("/a")
}