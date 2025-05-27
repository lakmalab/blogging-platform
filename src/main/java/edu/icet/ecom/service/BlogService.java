package edu.icet.ecom.service;

import edu.icet.ecom.model.dto.BlogDto;
import edu.icet.ecom.model.entity.BlogEntity;
import edu.icet.ecom.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public List<BlogDto> getAll(){
        List<BlogEntity> blogEntities = blogRepository.findAll();
        List<BlogDto> BlogDtoS = new ArrayList<>();

        for(BlogEntity BlogEntity: blogEntities){
            BlogDto BlogDto = new BlogDto();
            BlogDto.setId(BlogEntity.getId());
            BlogDto.setTitle(BlogEntity.getTitle());
            BlogDto.setContent(BlogEntity.getContent());
            BlogDto.setTags(formatTags((BlogEntity.getTags())));
            BlogDto.setCategory(BlogEntity.getCategory());
            BlogDto.setComments_count(BlogEntity.getComments_count());
            BlogDto.setCreatedAt(BlogEntity.getCreatedAt());
            BlogDto.setUpdated_at(BlogEntity.getUpdated_at());
            BlogDto.setImage_url(BlogEntity.getImage_url());
            BlogDtoS.add(BlogDto);
        }


        return BlogDtoS;
    }
    private List<String> formatTags(String tags) {
        List<String> Tags = List.of(tags.split(","));
        return Tags;
    }

}
