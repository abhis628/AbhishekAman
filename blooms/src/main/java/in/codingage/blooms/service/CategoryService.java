package in.codingage.blooms.service;

import in.codingage.blooms.dto.CategoryRequest;
import in.codingage.blooms.dto.CategoryResponse;
import in.codingage.blooms.models.Category;
import in.codingage.blooms.models.Status;
import in.codingage.blooms.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

   public CategoryResponse createCategory(CategoryRequest request){
   Category category=new Category();
   category.setName(request.getTitle());
   category.setDescription(request.getDesc());
   category.setImageUrl(request.getcUrl());
   category.setStatus(Status.PUBLISHED.getDisplayName());
   category.setId(String.valueOf(System.currentTimeMillis()));
   category.setCreatedBy("Admin");
   category.setActive(true);
   category.setCreatedDTTM(LocalDateTime.now());

   Category savedCategory=categoryRepository.save(category);
   return mapToResponse(savedCategory);
   }

   public CategoryResponse getCategoryById(String categoryId){
       return categoryRepository.findById(categoryId)
               .map(this::mapToResponse)
               .orElse(null);
   }
   public List<CategoryResponse> getAllCategories(){
       List<Category> categories=categoryRepository.findAll();
       List<CategoryResponse> responses=new ArrayList<>();
       for (Category c: categories){
           responses.add(mapToResponse(c));
       }
       return responses;
   }
   public boolean deleteCategory(String id){
       if (categoryRepository.existsById(id)){
           categoryRepository.deleteById(id);
           return true;
       }
       return false;
   }

   private CategoryResponse mapToResponse(Category category){
       return new CategoryResponse(
               category.getId(),
               category.getName(),
               category.getDescription(),
               category.getImageUrl()
       );
   }
}
