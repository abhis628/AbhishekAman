package in.codingage.blooms.Logic;

import in.codingage.blooms.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryLogic {
    private List<Category> categories=new ArrayList<>();

    public List<Category> getCategories() {
        createCategory();
        return categories;
    }

//    create catogry;


    public void  createCategory(){
        Category catogary=new Category();
        catogary.setName("Technology");
        catogary.setId("cat001");
        categories.add(catogary);


        Category categoryB=new Category();
        catogary.setName("Health");
        catogary.setId("cat002");
        categories.add(catogary);

        Category categoryC=new Category();
        catogary.setName("Politics");
        catogary.setId("cat003");
        categories.add(catogary);
    }


}
