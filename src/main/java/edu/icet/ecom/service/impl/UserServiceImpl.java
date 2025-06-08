package edu.icet.ecom.service.impl;

import edu.icet.ecom.model.dto.UserDto;
import edu.icet.ecom.model.entity.UserEntity;
import edu.icet.ecom.repository.UserRepository;
import edu.icet.ecom.repository.UserRepository;
import edu.icet.ecom.service.BlogService;
import edu.icet.ecom.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public List<UserDto> getAll(){
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> UserDtoS = new ArrayList<>();
        for(UserEntity userEntity : userEntities ){
            UserDtoS.add(mapper.map(userEntity, UserDto.class));
        }
        return UserDtoS;

    }
    @Override
    public void add(UserDto userDto){
        userRepository.save(mapper.map(userDto, UserEntity.class));

    }


    @Override
    public void update(UserDto userDto) {
        if (userRepository.findById(userDto.getId()).isPresent()) {
            userRepository.save(mapper.map(userDto, UserEntity.class));
        }
    }
    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

}
