package in.codingage.blooms.Controller;


import in.codingage.blooms.dto.UserRequest;
import in.codingage.blooms.dto.UserResponse;
import in.codingage.blooms.models.*;
import in.codingage.blooms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/admin Details")
    public UserResponse getAdminById(@RequestParam String UserId){
        return adminService.getAdminById(UserId);
    }
    @PutMapping("/update adminDetails")
    public  UserResponse updateAdmin(@RequestBody UserRequest adminRequest){
        return  adminService.updateAdmin(adminRequest);
    }


  //====user====

    @GetMapping("/users/all")
    public List<User> getAllUsers(){
        return  adminService.getAllUsers();
    }

    @GetMapping("/users/user_id")
    public  User getUserById(@RequestParam String userId){
        return  adminService.getUserById(userId);
    }

    @DeleteMapping("/userById")
    public  boolean deleteUser(@RequestParam String userId){
        return  adminService.deleteUserById(userId);
    }


    //===category====

    @GetMapping("/categories/all")
    public  List<Category> getAllCategories(){
        return adminService.getAllCategories();
    }

    @GetMapping("/categories/category_id")
    public  Category getCategoryById(@RequestParam String categoryId){
        return (Category) adminService.getCategoryById(categoryId);
    }

    @DeleteMapping("/categoriesById")
    public  boolean deleteCategory(@RequestParam String categoryId){
        return  adminService.deleteCategoryById(categoryId);
    }

    @PutMapping("/categories/UpdateStatus")
    public  boolean updateCategoryStatus(@RequestParam String categoryId, @RequestParam Status status){
        return  adminService.updateCategoryStatus(categoryId,status);
    }


    //====Sub category====

    @GetMapping("/subcategories/all")
    public  List<SubCategory> getAllSubCategories(){
        return  adminService.getAllSubCategories();
    }

    @GetMapping("/subcategories/subcategory_id")
    public SubCategory getSubCategoryById(@RequestParam String subCategoryId){
        return  adminService.getSubCategoryId(subCategoryId);
    }
    @DeleteMapping("/subcategoryById")
    public  boolean deleteSubCategory(@RequestParam String subCategoryId){
        return  adminService.deleteSubCategoryById(subCategoryId);
    }
    @PutMapping("/subcategories/updateStatus")
    public  boolean updateSubCategoryStatus(@RequestParam String subCategoryId,@RequestParam Status status){
        return adminService.updateSubCategoryStatus(subCategoryId,status);
    }

    //====blog======
    @GetMapping("/blogs/all")
    public  List<Blog> getAllBlogs(){
        return  adminService.getAllBlogs();
    }
    @GetMapping("/blogs/blog_id")
    public Blog getBlogById(@RequestParam String blogId){
        return adminService.getBlogById(blogId);
    }
    @DeleteMapping("/blogsById")
    public boolean deleteBlog(@RequestParam String blogId){
        return  adminService.deleteBlogById(blogId);
    }
    @PutMapping("/blogs/updateStatus")
    public  boolean updateBlogStatus(@RequestParam String blogId,@RequestParam Status status){
        return  adminService.updateBlogStatus(blogId,status);
    }

}
