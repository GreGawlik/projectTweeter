package com.example.demox.service;

import com.example.demox.entity.Post;
import com.example.demox.model.PostDto;
import com.example.demox.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PostService {
    private PostRepository postRepository;
    private ModelMapper modelMapper;

@Autowired
    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    public void savePost(PostDto postDto) throws ParseException{

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDateFormat=sdf.format(new Date());
        Post postToSave=modelMapper.map(postDto, Post.class);
        postRepository.save(postToSave);

    }
}
