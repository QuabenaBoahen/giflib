package com.boaheninc.model;

import java.time.LocalDate;

public class Gif {
	private String name;
	private int categoryId;
	private LocalDate dateUploaded;
	private String username;
	private Boolean favorite;
	
	public Gif(String name,int categoryId, LocalDate dateUploaded, String username, Boolean favorite) {
		this.name = name;
		this.categoryId=categoryId;
		this.dateUploaded = dateUploaded;
		this.username = username;
		this.favorite = favorite;
	}
		
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateUploaded() {
		return dateUploaded;
	}
	public void setDateUploaded(LocalDate dateUploaded) {
		this.dateUploaded = dateUploaded;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Boolean getFavorite() {
		return favorite;
	}
	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}

}
