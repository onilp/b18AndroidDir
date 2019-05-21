package com.calvert.retrofithomework.model;

import com.google.gson.annotations.SerializedName;

public class Album{

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

	public Album(int id, String title, int userId) {
		this.id = id;
		this.title = title;
		this.userId = userId;
	}

	@Override
 	public String toString(){
		return 
			"Album{" + 
			"id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}