package edu.icet.ecom.controller;

import edu.icet.ecom.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

}
