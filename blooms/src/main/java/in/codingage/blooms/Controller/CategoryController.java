package in.codingage.blooms.Controller;

import in.codingage.blooms.Database;
import in.codingage.blooms.dto.CategoryRequest;
import in.codingage.blooms.dto.CategoryResponse;
import in.codingage.blooms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    //CRUD -create,read,update,delete

    // Supplier<Integer> capacitySupplier=()->(int) (Math.random()*10)+1;
    @Autowired
    public CategoryService categoryService;

    @PostMapping
   public CategoryResponse createCategory(@RequestBody CategoryRequest request ){

        return categoryService.createCategory(request);
    }



    @GetMapping("/byid")
    public CategoryResponse getCategory(String categoryId){

        return categoryService.getCategoryById(categoryId);
    }

    @GetMapping("/all")
    public  List<CategoryResponse> getCategories(){
       return categoryService.getAllCategories();
    }
    @DeleteMapping("/{id}")
    public  boolean deleteCategory(@PathVariable String id){
       return categoryService.deleteCategory(id);
    }

//    public  CategoryResponse updateCategory(CategoryRequest categoryRequest){
//        //fetch category by id and update its name, desc and curl using category request
//        //validation to return from here only if id is not present
//        CategoryResponse categoryResponse=new CategoryResponse();
//        if (categoryRequest.getId()==null){
//            //we will send error to ui later
//            return categoryResponse;
//        }
//        List<Category> categoryResponses =Database.getInstance().getCategoryList();
//
//        for (Category category:categoryResponses){
//            if (category.getId().equals(categoryRequest.getId())){
//            category.setName(categoryRequest.getTitle());
//            category.setDescription(categoryRequest.getDesc());
//            category.setImageUrl(categoryRequest.getcUrl());
//            //create a category response object
//                categoryResponse.setDesc(category.getDescription());
//                categoryResponse.setId(category.getId());
//                categoryResponse.setcUrl(category.getImageUrl());
//                categoryResponse.setTitle(category.getName());
//                return categoryResponse;
//            }
//        }
//        return categoryResponse;
//    }
}
