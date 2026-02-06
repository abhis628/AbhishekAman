package in.codingage.blooms.service;

import in.codingage.blooms.dto.UserRequest;
import in.codingage.blooms.dto.UserResponse;
import in.codingage.blooms.models.*;
import in.codingage.blooms.repository.*;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
     private  final CategoryRepository categoryRepository;
     private final SubCategoryRepository subCategoryRepository;

    public AdminService(UserRepository userRepository, BlogRepository blogRepository,CategoryRepository categoryRepository,SubCategoryRepository subCategoryRepository) {
        this.userRepository = userRepository;
        this.blogRepository = blogRepository;
        this.categoryRepository=categoryRepository;
        this.subCategoryRepository=subCategoryRepository;
    }
    //get admin by id

 public UserResponse getAdminById(String userId){
        Optional<User> userOptional=userRepository.findById(userId);

        if (userOptional.isEmpty()){
            return null;
        }

        User user=userOptional.get();

        if (!user.isActive()){
            return null;
        }
        if (user.getRole() != Role.USER){
            return null;
        }

        UserResponse userResponse=new UserResponse();

        userResponse.setUserId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setProfileUrl(user.getProfileUrl());
        userResponse.setName(user.getName());
        userResponse.setUsername(user.getUsername());

        userResponse.setRole(user.getRole());
        return userResponse;
 }
    // getall admin

    public List<UserResponse> getAdmins(){
        List<User> userList=userRepository.findAll();
        List<UserResponse> userResponses=new ArrayList<>();

        for (User user: userList){
          if (user.isActive()&& user.getRole()==Role.ADMIN){

              UserResponse userResponse=new UserResponse();

              userResponse.setUserId(user.getId());
              userResponse.setEmail(user.getEmail());
              userResponse.setProfileUrl(user.getProfileUrl());
              userResponse.setName(user.getName());

              userResponse.setUsername(user.getUsername());
              userResponse.add(userResponse);

            }
        }
        return userResponses;
    }
//update admin
    public UserResponse updateAdmin(UserRequest userRequest) {
        UserResponse userResponse=new UserResponse();

        if (userRequest.getUserId()==null){
            System.out.println("this user is not exist so, you cannot update");
            return  userResponse;
        }
        Optional<User> optionalUser=userRepository.findById(userRequest.getUserId());

        User user=optionalUser.get();

        if (user.getRole()==Role.ADMIN){
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());
            user.setUsername(userRequest.getUsername());
            user.setProfileUrl(userRequest.getProfileUrl());
            user.setRole(userRequest.getRole());
            userRepository.save(user);
        }
        userResponse.setUsername(user.getUsername());
        userResponse.setUserId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }


    //===user===

    public  List<User> getAllUsers(){
        return  userRepository.findAll();
    }
    public  User getUserById(String userId){
        Optional<User> optionalUser=userRepository.findById(userId);

        if (optionalUser.isEmpty()){
            return null;
        }
        return optionalUser.get();
    }
    public  boolean  deleteUserById(String userId){
        Optional<User> optionalUser=userRepository.findById(userId);

        if (optionalUser.isEmpty()){
            return  false;
        }

        User user=optionalUser.get();

        user.setActive(false);
        userRepository.save(user);
        return true;
    }

    //===category===
    public List<Category> getAllCategories(){
        return  categoryRepository.findAll();
    }
    public  Category getCategoryById(String categoryId){

        Optional<Category> optionalCategory=categoryRepository.findById(categoryId);

        if (optionalCategory.isEmpty()){
            return null;
        }
        return (Category) Collections.singletonList(optionalCategory.get());

    }

    public  boolean deleteCategoryById(String categoryId){
        Optional<Category> optionalCategory=categoryRepository.findById(categoryId);
        if (optionalCategory.isEmpty()){
            return false;
        }
        categoryRepository.deleteById(categoryId);
        return true;
    }

    public  boolean updateCategoryStatus(String categoryId, Status status){
        Optional<Category> optionalCategory=categoryRepository.findById(categoryId);

        if (optionalCategory.isEmpty()){
            return false;
        }

        Category category=optionalCategory.get();
        category.setStatus(String.valueOf(status));
        categoryRepository.save(category);
        return true;
    }


    //===subcategory===

    public List<SubCategory> getAllSubCategories(){
        return  subCategoryRepository.findAll();
    }

    public  SubCategory getSubCategoryId(String subCategoryId){
        Optional<SubCategory> optionalSubCategory=subCategoryRepository.findById(subCategoryId);

        if (optionalSubCategory.isEmpty()){
            return null;
        }
        return optionalSubCategory.get();
    }

    public boolean deleteSubCategoryById(String subCategoryId){
        Optional<SubCategory> optionalSubCategory=subCategoryRepository.findById(subCategoryId);

        if (optionalSubCategory.isEmpty()){
            return false;
        }

        subCategoryRepository.deleteById(subCategoryId);
        return true;
    }

    public  boolean updateSubCategoryStatus(String subCategoryId,Status status){
        Optional<SubCategory> optionalSubCategory=subCategoryRepository.findById(subCategoryId);

        if (optionalSubCategory.isEmpty()){
            return false;
        }

        SubCategory subCategory=optionalSubCategory.get();
        subCategory.setStatus(String.valueOf(status));
        subCategoryRepository.save(subCategory);

        return true;
    }

    //====blog===
    public  List<Blog> getAllBlogs(){
        return  blogRepository.findAll();
    }

    public Blog getBlogById(String blogId){

        Optional<Blog> optionalBlog=blogRepository.findById(blogId);

        if (optionalBlog.isEmpty()){
            return null;
        }

        return optionalBlog.get();
    }
    public  boolean deleteBlogById(String blogId){
        Optional<Blog> optionalBlog=blogRepository.findById(blogId);

        if (optionalBlog.isEmpty()){
            return false;
        }

        blogRepository.deleteById(blogId);
        return true;
    }

    public boolean updateBlogStatus(String blogId,Status status){
        Optional<Blog> optionalBlog=blogRepository.findById(blogId);

        if (optionalBlog.isEmpty()){
            return false;
        }

        Blog blog=optionalBlog.get();
        blog.setStatus(String.valueOf(status));
        blogRepository.save(blog);

        return true;
    }


}
