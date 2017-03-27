package com.boaheninc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boaheninc.data.GifRepository;
import com.boaheninc.model.Gif;

@Controller
public class GifController {
	final Logger logger=LoggerFactory.getLogger(GifController.class.getName());
	
	@Autowired
	private GifRepository gifRepository;
	
	@RequestMapping("/")
  public String listGifs(ModelMap modelMap){
	  List<Gif> gifList=gifRepository.getAllGifs();
	  modelMap.put("gifList", gifList);
	  logger.info("Home page");
	  return "home";
  }
	
	@RequestMapping("/gif/{name}")
	  public String gifDetails(@PathVariable String name, ModelMap modelMap){
		Gif gif=gifRepository.findByName(name);
		modelMap.put("gif", gif);
		  return "gif-details";
	  }
	
	@RequestMapping("/favorites")
	  public String favorite(ModelMap modelMap){
		List<Gif> gifs=gifRepository.getAllFavorites();
		modelMap.put("gifs", gifs);
		  return "favorites";
	  }
	
}
