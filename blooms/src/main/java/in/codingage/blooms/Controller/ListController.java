package in.codingage.blooms.Controller;

import in.codingage.blooms.dto.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

public class ListController {
    public static void main(String[] args) {
        //string data type ke element ko add kar sakte ho
        //jfc - java collection framework
        List<String> items=new ArrayList<>();


        //ordered collection of element
        items.add("Vishal");
        items.add("pintu");
        items.add("abhishek");
        items.add("abhishek k");
        items.add("saurbh");
        items.add("sunidhi");
        items.add("surbhi");

        for (String abc:items){
            System.out.println(abc);
        }

        //method overloading
        items.remove(0);

        //IOUB
        //Exception handling
        try{
            System.out.println(items.get(6));
        }catch (IndexOutOfBoundsException e){
            System.out.println("Index out of bounds exception cought : "+ e.getMessage());

        }

        for (String abc : items) {
            System.out.println(abc);
        }

        List<CategoryResponse> categoryResponses = new ArrayList<>();

        categoryResponses.add(new CategoryResponse("1", "Technology A", "All about technology", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyFSDvZA27CPTHnxlnq8vd-pfw0vcsNGFafA&s"));
        categoryResponses.add(new CategoryResponse("2", "Technology B", "All about technology", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyFSDvZA27CPTHnxlnq8vd-pfw0vcsNGFafA&s"));
        categoryResponses.add(new CategoryResponse("3", "Technology C", "All about technology", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyFSDvZA27CPTHnxlnq8vd-pfw0vcsNGFafA&s"));

        for (CategoryResponse cat : categoryResponses) {
            System.out.println("Category ID: " + cat.getId() + ", Name: " + cat.getTitle());
        }

        String idToFind = "20";

        for (CategoryResponse cat : categoryResponses) {
            if (cat.getId().equals(idToFind)) {
                System.out.println("Found Category with ID " + idToFind + ": " + cat.getTitle());
            }
        }

        String idToRemove = "2";

        for (CategoryResponse cat : categoryResponses) {
            if (cat.getId().equals(idToRemove)) {
                categoryResponses.remove(cat);
                break;
            }
        }

        for (CategoryResponse cat : categoryResponses) {
            System.out.println("Category ID: " + cat.getId() + ", Name: " + cat.getTitle());
        }

    }
}
