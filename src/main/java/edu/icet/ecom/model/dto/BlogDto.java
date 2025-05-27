package edu.icet.ecom.model.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BlogDto {
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
