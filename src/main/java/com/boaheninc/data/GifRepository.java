package com.boaheninc.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import com.boaheninc.model.Gif;

@Component
public class GifRepository {
  
	private static final List<Gif> ALL_GIFS = Arrays.asList(
			new Gif("android-explosion",1, LocalDate.of(2016, 12, 17), "Quabena Boahen", true),
			new Gif("ben-and-mike",3, LocalDate.of(2016, 12, 17), "Saani Mohammed", false),
			new Gif("book-dominos",2, LocalDate.of(2016, 12, 17), "Ben Mike", true),
			new Gif("cowboy-coder",1, LocalDate.of(2016, 12, 17), "John Doe", false)
			);
	
	public Gif findByName(String name){
		for(Gif gif: ALL_GIFS){ 
			if(gif.getName().equals(name)){
				return gif;
			}
		}
		return null;
	}
	
	public List<Gif> getAllGifs(){
		return ALL_GIFS;
	}
	
	public List<Gif> findByCategoryId(int id){
		List<Gif> gifs=new ArrayList<>();
		for(Gif gif: ALL_GIFS){
			if(gif.getCategoryId() == id){
				gifs.add(gif);
			}
		}
		return gifs;
	}
	
	public List<Gif> getAllFavorites(){
		List<Gif> gifs=new ArrayList<>();
		for(Gif gif: ALL_GIFS){
			if(gif.getFavorite()==true){
				gifs.add(gif);
			}
		}
		return gifs;
	}

}
