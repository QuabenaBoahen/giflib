package com.boaheninc.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.boaheninc.data.CategoryRepository;
import com.boaheninc.data.GifRepository;
import com.boaheninc.model.Category;
import com.boaheninc.model.Gif;

@Controller
public class CategoryController {
   @Autowired
   private CategoryRepository categoryRepository;
   
   @Autowired
   private GifRepository gifRepository;
	
	@RequestMapping("/categories")
	  public String categories(ModelMap modelMap){
		List<Category> categories=categoryRepository.getAllCategories();
		modelMap.put("categories", categories);
		  return "categories";
	  }
	
	@RequestMapping("/category/{id}")
	  public String category(@PathVariable int id, ModelMap modelMap){
		Category category=categoryRepository.findById(id);
		modelMap.put("category", category);
		
		List<Gif> gifs=gifRepository.findByCategoryId(id);
		modelMap.put("gifs", gifs);
		  return "category";
	  }
	
}
