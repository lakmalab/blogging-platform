package edu.icet.ecom.service.impl;

import edu.icet.ecom.model.dto.BlogDto;
import edu.icet.ecom.model.entity.BlogEntity;
import edu.icet.ecom.repository.BlogRepository;
import edu.icet.ecom.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
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
    @Override
    public void add(BlogDto blogDto){
        BlogEntity blogEntity = new BlogEntity();

        blogEntity.setTitle(blogDto.getTitle());
        blogEntity.setContent(blogDto.getContent());
        blogEntity.setTags(DeformatTags((blogDto.getTags())));
        blogEntity.setCategory(blogDto.getCategory());
        blogEntity.setComments_count(blogDto.getComments_count());
        blogEntity.setCreatedAt(LocalDateTime.now());
        blogEntity.setUpdated_at(LocalDateTime.now());
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
    @Override
    public void update(BlogDto blogDto) {
        BlogEntity blogEntity = new BlogEntity();
        if (blogRepository.findById(blogDto.getId()).isPresent()) {
            blogEntity.setId(blogDto.getId());
            blogEntity.setTitle(blogDto.getTitle());
            blogEntity.setContent(blogDto.getContent());
            blogEntity.setTags(DeformatTags((blogDto.getTags())));
            blogEntity.setCategory(blogDto.getCategory());
            blogEntity.setComments_count(blogDto.getComments_count());

            blogEntity.setUpdated_at(LocalDateTime.now());
            blogEntity.setImage_url(blogDto.getImage_url());

            blogRepository.save(blogEntity);
        }
    }
    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }
    @Override
    public List<BlogDto> getbyID(int id) {

        List<BlogEntity> blogEntities = blogRepository.findAll();
        List<BlogDto> BlogDtoS = new ArrayList<>();

        for(BlogEntity BlogEntity: blogEntities){
            if (BlogEntity.getId() == id) {
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
        }

        return BlogDtoS;

    }
}
