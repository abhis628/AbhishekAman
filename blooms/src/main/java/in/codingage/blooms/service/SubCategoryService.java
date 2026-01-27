package in.codingage.blooms.service;

import in.codingage.blooms.dto.SubCategoryRequest;
import in.codingage.blooms.dto.SubCategoryResponse;
import in.codingage.blooms.models.SubCategory;
import in.codingage.blooms.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;
     //create

    public SubCategoryResponse createsubcategory(SubCategoryRequest request){
        SubCategory subCategory=new SubCategory();
        subCategory.setName(request.getName());
        subCategory.setCategoryId(request.getCategoryId());
//        subCategory.setId(request.getId());
        subCategory.setDescription(request.getDescription());

        SubCategory saved=subCategoryRepository.save(subCategory);
         return new SubCategoryResponse(
                 saved.getId(),
                 saved.getName(),
                 saved.getDescription(),
                 saved.getCategoryId()
         );
    }


    //get By category id
    public List<SubCategoryResponse> getSubCategoriesByCategory(String categoryId){
       List<SubCategory> list=subCategoryRepository.findByCategoryId(categoryId);
       List<SubCategoryResponse> responses=new ArrayList<>();
       for (SubCategory s : list){
           responses.add(new SubCategoryResponse(s.getId(),s.getName(),s.getDescription(),s.getCategoryId()));

       }
       return responses;
    }

    //delete
    public boolean deleteSubCategory(String id){
        if(subCategoryRepository.existsById(id)){
            subCategoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
    //getAll
    public List<SubCategory> getAll(){
        return subCategoryRepository.findAll();
    }
}
