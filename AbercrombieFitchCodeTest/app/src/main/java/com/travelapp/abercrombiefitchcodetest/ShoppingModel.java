package com.travelapp.abercrombiefitchcodetest;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ShoppingModel{

	@SerializedName("topDescription")
	private String topDescription;

	@SerializedName("bottomDescription")
	private String bottomDescription;

	@SerializedName("backgroundImage")
	private String backgroundImage;

	@SerializedName("promoMessage")
	private String promoMessage;

	@SerializedName("title")
	private String title;

	@SerializedName("content")
	private List<ContentItem> content;

	public void setTopDescription(String topDescription){
		this.topDescription = topDescription;
	}

	public String getTopDescription(){
		return topDescription;
	}

	public void setBottomDescription(String bottomDescription){
		this.bottomDescription = bottomDescription;
	}

	public String getBottomDescription(){
		return bottomDescription;
	}

	public void setBackgroundImage(String backgroundImage){
		this.backgroundImage = backgroundImage;
	}

	public String getBackgroundImage(){
		return backgroundImage;
	}

	public void setPromoMessage(String promoMessage){
		this.promoMessage = promoMessage;
	}

	public String getPromoMessage(){
		return promoMessage;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setContent(List<ContentItem> content){
		this.content = content;
	}

	public List<ContentItem> getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"ShoppingModel{" + 
			"topDescription = '" + topDescription + '\'' + 
			",bottomDescription = '" + bottomDescription + '\'' + 
			",backgroundImage = '" + backgroundImage + '\'' + 
			",promoMessage = '" + promoMessage + '\'' + 
			",title = '" + title + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}