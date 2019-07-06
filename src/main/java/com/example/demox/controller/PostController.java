package com.example.demox.controller;

import com.example.demox.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

public class PostController {
    @Autowired
    private PostService postService;
}
