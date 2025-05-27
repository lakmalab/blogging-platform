package edu.icet.ecom.controller;

import edu.icet.ecom.model.dto.BlogDto;
import edu.icet.ecom.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping
    public List<BlogDto> getAll(){
        return blogService.getAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody BlogDto blogDto) {
        blogService.add(blogDto);
    }

}
