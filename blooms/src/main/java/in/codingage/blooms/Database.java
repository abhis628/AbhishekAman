package in.codingage.blooms;


import in.codingage.blooms.models.Category;
import in.codingage.blooms.models.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class Database {


    private  static  Database instance=null;

    private  Database(){

    }
 public static Database getInstance(){
        if (instance==null){
            instance=new Database();
        }
        return instance;
 }
//collection of category
 private  List<Category> categoryList=new ArrayList<>();

//collection of subcategory
 private List<SubCategory> subCategoryList=new ArrayList<>();

 public  List<Category> getCategoryList(){
     return  categoryList;
 }

 public  List<SubCategory> getSubCategoryList(){
     return  subCategoryList;
 }


}
