package com.calvert.retrofitrxjavadagger2.model;

import com.google.gson.annotations.SerializedName;

public class AlbumResponse{

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("userId")
	private int userId;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	@Override
 	public String toString(){
		return 
			"AlbumResponse{" + 
			"id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}