package in.codingage.blooms.Controller;

import in.codingage.blooms.Database;
import in.codingage.blooms.dto.SubCategoryRequest;
import in.codingage.blooms.dto.SubCategoryResponse;
import in.codingage.blooms.models.SubCategory;
import in.codingage.blooms.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping
    public SubCategoryResponse createSubCategory(@RequestBody SubCategoryRequest request){
      return subCategoryService.createsubcategory(request);

    }

    @GetMapping("/{categoryId}")

    public List<SubCategoryResponse> getCategory(@PathVariable String categoryId){
        return subCategoryService.getSubCategoriesByCategory(categoryId);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        return subCategoryService.deleteSubCategory(id);
    }

//    public SubCategoryResponse getSubCategory(String subCategoryId){
//        List<SubCategory> list = Database.getInstance().getSubCategoryList();
//
//        for(SubCategory sub : list){
//            if(sub.getId().equals(subCategoryId) && sub.isActive()){
//                return mapToResponse(sub);
//            }
//        }
//        return null;
//    }
//
//    @PutMapping
//    public SubCategoryResponse updateSubCategory(SubCategoryRequest request){
//        if(request.getId() == null){
//            System.out.println("❌ Error: ID is required for update");
//            return null;
//        }
//        List<SubCategory> list = Database.getInstance().getSubCategoryList();
//        for(SubCategory sub : list){
//            if(sub.getId().equals(request.getId())){
//
//                // Hum sirf Name aur Desc update kar rahe hain
//                // (Parent Category change karna thoda complex hota hai, abhi avoid karte hain)
//                sub.setName(request.getName());
//                sub.setDescription(request.getDescription());
//
//                System.out.println("✅ SubCategory Updated: \" + sub.getName()");
//                return mapToResponse(sub);
//            }
//        }
//        System.out.println("❌ Error: SubCategory nahi mili update karne ke liye.");
//        return null;
//    }
//    // --- 5. DELETE (Soft Delete) ---
//    @DeleteMapping
//    public boolean deleteSubCategory(String subCategoryId) {
//        List<SubCategory> list = Database.getInstance().getSubCategoryList();
//
//        for (SubCategory sub : list) {
//            if (sub.getId().equals(subCategoryId)) {
//                sub.setActive(false); // Soft delete (Batti bujha di)
//                System.out.println("🗑️ SubCategory Deleted (Soft): " + sub.getName());
//                return true;
//            }
//        }
//        System.out.println("❌ Error: Delete karne ke liye ID nahi mili.");
//        return false;
//    }
//
//    // --- HELPER METHOD (Code duplication bachane ke liye) ---
//    // Ye method Model ko Response DTO me convert karta hai
//    private SubCategoryResponse mapToResponse(SubCategory sub) {
//        return new SubCategoryResponse(
//                sub.getId(),
//                sub.getCategoryId(),
//                sub.getName(),
//                sub.getDescription()
//        );
//    }
//
//
//    // Read All SubCategory
//    @GetMapping("/all")
//    public List<SubCategoryResponse> viewAll(){
//        List<SubCategory> subCategoryList = Database.getInstance().getSubCategoryList();
//        List<SubCategoryResponse> subCategories = new ArrayList<>();
//
//        for(SubCategory subCategory : subCategoryList){
//            SubCategoryResponse sub = new SubCategoryResponse();
//            sub.setDescription(subCategory.getDescription());
//            sub.setCategoryId(subCategory.getCategoryId());
//            sub.setId(subCategory.getId());
//            sub.setName(subCategory.getName());
//
//            subCategories.add(sub);
//        }
//        return subCategories;
//    }

}