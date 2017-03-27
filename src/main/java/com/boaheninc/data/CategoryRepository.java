package com.boaheninc.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.boaheninc.model.Category;

@Component
public class CategoryRepository {
	
	private static final List<Category> ALL_CATEGORY=Arrays.asList(
			new Category(1, "Technology"),
			new Category(2, "People"),
			new Category(3, "Destruction")
			);
	
	public List<Category> getAllCategories(){
		return ALL_CATEGORY;
	}
	
	public Category findById(int id){
		for(Category category: ALL_CATEGORY){
			if(category.getId()==id){
				return category;
			}
		}
		return null;
	} 

}
