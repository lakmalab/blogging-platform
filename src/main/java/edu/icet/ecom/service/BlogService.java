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
    public void add(BlogDto blogDto){
        BlogEntity blogEntity = new BlogEntity();

        blogEntity.setId(blogDto.getId());
        blogEntity.setTitle(blogDto.getTitle());
        blogEntity.setContent(blogDto.getContent());
        blogEntity.setTags(DeformatTags((blogDto.getTags())));
        blogEntity.setCategory(blogDto.getCategory());
        blogEntity.setComments_count(blogDto.getComments_count());
        blogEntity.setCreatedAt(blogDto.getCreatedAt());
        blogEntity.setUpdated_at(blogDto.getUpdated_at());
        blogEntity.setImage_url(blogDto.getImage_url());

        blogRepository.save(blogEntity);
    }
    private List<String> formatTags(String tags) {
        List<String> Tags = List.of(tags.split(","));
        return Tags;
    }
    private String DeformatTags(List<String> tags) {
        String Tags = "" ;
        for (int i = 0; i < tags.size(); i++) {
            if (i > 0) {
                Tags += ",";
            }
            Tags += tags.get(i);
        }
        return Tags;
    }

    public void update(BlogDto blogDto) {
        BlogEntity blogEntity = new BlogEntity();
        if (blogRepository.findById(blogDto.getId()).isPresent()) {
            blogEntity.setId(blogDto.getId());
            blogEntity.setTitle(blogDto.getTitle());
            blogEntity.setContent(blogDto.getContent());
            blogEntity.setTags(DeformatTags((blogDto.getTags())));
            blogEntity.setCategory(blogDto.getCategory());
            blogEntity.setComments_count(blogDto.getComments_count());
            blogEntity.setCreatedAt(blogDto.getCreatedAt());
            blogEntity.setUpdated_at(blogDto.getUpdated_at());
            blogEntity.setImage_url(blogDto.getImage_url());

            blogRepository.save(blogEntity);
        }
    }

    public void delete(int id) {
        blogRepository.deleteById(id);
    }
}
