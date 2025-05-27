package edu.icet.ecom.model.entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "blog_posts")
public class BlogEntity {
    private int id;
    private String title ;
    private String content ;
    private List<String> tags;
    private String category ;
    private int comments_count;
    private LocalDateTime createdAt;
    private LocalDateTime updated_at ;
    private String image_url ;
}
