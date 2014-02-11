package com.android.yummlyclient.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recipeName;
	private String recipeId;
	private ArrayList<String> ingredients;
	private ArrayList<String> flavors;
	//private ArrayList<String> imageUrls;
	private String[] imgUrls;
	
	public String getRecipeName(){
		return recipeName;
	}
	
	public String getRecipeId(){
		return recipeId;
	}
	
	public String getImageUrl(){
		return imgUrls[0];
	}
	
	/*public String getRecipeIngredients(){
		return recipeName;
	}
	
	public String getRecipeName(){
		return recipeName;
	}*/
	
	public static Recipe fromJson(JSONObject jsonObject) {
        Recipe recipe = new Recipe();
        try {
        	recipe.recipeId = jsonObject.getString("id");
        	recipe.recipeName = jsonObject.getString("recipeName");
        	Log.d("DEBUG", "recipeName -> "  + recipe.recipeName);
        	JSONArray imgUrlsArray = jsonObject.getJSONArray("smallImageUrls");
        	recipe.imgUrls = new String[imgUrlsArray.length()];
        	for(int i = 0; i < imgUrlsArray.length(); i++){
        		recipe.imgUrls[i] = (String) imgUrlsArray.get(i);
        		Log.d("DEBUG", "imgUrl -> "  + imgUrlsArray.get(i));
        	}
        	//recipe.imageUrls = jsonObject.get
            //recipe.getBody();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return recipe;
    }
	public static ArrayList<Recipe> fromJson(JSONArray jsonArray) {
        ArrayList<Recipe> recipes = new ArrayList<Recipe>(jsonArray.length());

        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject recipeJson = null;
            try {
            	recipeJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Recipe recipe = Recipe.fromJson(recipeJson);
            if (recipe != null) {
                recipes.add(recipe);
            }
        }
        return recipes;
    }
}
