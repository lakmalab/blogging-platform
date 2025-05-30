package edu.icet.ecom.controller;

import edu.icet.ecom.model.dto.BlogDto;
import edu.icet.ecom.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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

    @PutMapping
    public void update(@RequestBody BlogDto blogDto) {
        blogService.update(blogDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        blogService.delete(id);
    }

}
