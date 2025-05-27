package edu.icet.ecom.model.entity;

import java.time.LocalDateTime;
import java.util.List;

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
