package edu.icet.ecom.service;

import edu.icet.ecom.model.dto.BlogDto;
import edu.icet.ecom.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();
    void add(UserDto userDto);
    void update(UserDto userDto);
    void delete(int id);
}
