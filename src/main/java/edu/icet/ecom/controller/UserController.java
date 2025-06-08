package edu.icet.ecom.controller;

import edu.icet.ecom.model.dto.UserDto;
import edu.icet.ecom.model.entity.UserEntity;
import edu.icet.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody UserDto userDto) {
        userService.add(userDto);
    }

    @PutMapping
    public void update(@RequestBody UserDto userDto) {
        userService.update(userDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }

}
