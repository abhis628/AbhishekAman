package in.codingage.blooms.service;

import in.codingage.blooms.dto.BlogRequest;
import in.codingage.blooms.dto.BlogResponse;
import in.codingage.blooms.models.Blog;
import in.codingage.blooms.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

  public BlogResponse createBlog(BlogRequest blogRequest){
      Blog blog =new Blog();
      blog.setId(blogRequest.getId());
      blog.setTitle(blogRequest.getTitle());
      blog.setContent(blogRequest.getDescription());
      blog.setAuthorId(blogRequest.getAuthorId());
      blog.setCategoryMappings(blogRequest.getCategoryMappings());
      blog.setCreatedAt(new Date());

      Blog savedBlog = blogRepository.save(blog);
      return mapToResponse(savedBlog);
  }
  public List<BlogResponse> getAllBlog(){
      return blogRepository.findAll()
              .stream()
              .map(this::mapToResponse)
              .toList();
  }
  public BlogResponse getBlogById(String id){
      return blogRepository.findById(id)
              .map(this::mapToResponse)
              .orElse(null);
  }



    public List<BlogResponse> getBlogByAuthor(String authorId){
      return blogRepository.findByAuthorId(authorId)
              .stream()
              .map(this::mapToResponse)
              .toList();
  }
  public  boolean deleteBlog(String id){
      if (blogRepository.existsById(id)) {
          blogRepository.deleteById(id);
          return  true;
      }
      return false;
  }
  private  BlogResponse mapToResponse(Blog blog){
      return new BlogResponse(
              blog.getId(),
              blog.getTitle(),
              blog.getDescription(),
              blog.getContent(),
              blog.getAuthorId(),
              blog.getCategoryMappings()
      );
  }
}
