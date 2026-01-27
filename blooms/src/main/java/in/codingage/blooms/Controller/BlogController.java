package in.codingage.blooms.Controller;


import in.codingage.blooms.dto.BlogRequest;
import in.codingage.blooms.dto.BlogResponse;
import in.codingage.blooms.models.Blog;
import in.codingage.blooms.service.BlogService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;
@PostMapping
 public  BlogResponse createBlog(@RequestBody BlogRequest blogRequest){
    return blogService.createBlog(blogRequest);
}
@GetMapping
public List<BlogResponse> getAllBlogs(){
    return blogService.getAllBlog();
}
@GetMapping("/{id}")
public  BlogResponse getBlogById(@PathVariable String id){
    return blogService.getBlogById(id);
}
@GetMapping("/author/{authorId}")
public List<BlogResponse> getBlogByAuthor(@PathVariable String authorId){
    return blogService.getBlogByAuthor(authorId);
}

public boolean deleteBlog(@PathVariable String id){
    return blogService.deleteBlog(id);
}

}
