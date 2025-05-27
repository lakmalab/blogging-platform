package edu.icet.ecom.model.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Entity
public class BlogEntity {
    @Id
    private int id;
    private String title ;
    private String content ;
    private String tags;
    private String category ;
    private int comments_count;
    private LocalDateTime createdAt;
    private LocalDateTime updated_at ;
    private String image_url ;
}
