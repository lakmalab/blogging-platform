package edu.icet.ecom.service;

import edu.icet.ecom.model.dto.BlogDto;

import java.util.List;

public interface BlogService {

    List<BlogDto> getAll();
    void add(BlogDto blogDto);
    void update(BlogDto blogDto);
    void delete(int id);
    List<BlogDto> getbyID(int id);

}
