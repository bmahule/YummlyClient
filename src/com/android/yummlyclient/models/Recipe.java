package com.android.yummlyclient.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;
	private String recipeName;
	private ArrayList<String> ingredients;
	private static HashMap<String, Double> flavors;
	private String rating;
	private String[] imgUrls;
	private String time;

	public String getRecipeName() {
		return recipeName;
	}
	
	public String getImageUrl() {
		return imgUrls[0];
	}
	
	public String getRating() {
		return rating;
	}
	
	public String getPrepTime() {
		return time;
	}
	
	public ArrayList<String> getIngredients() {
		return ingredients;
	}

	public static Recipe fromJson(JSONObject jsonObject) {
		Recipe recipe = new Recipe();
		try {
			recipe.rating = jsonObject.getString("rating");
			Log.d("DEBUG", "rating -> " + recipe.rating);
			recipe.recipeName = jsonObject.getString("recipeName");
			Log.d("DEBUG", "recipeName -> " + recipe.recipeName);

			recipe.time = jsonObject.getString("totalTimeInSeconds");
			Log.d("DEBUG", "time -> " + recipe.time);
			recipe.time = jsonObject.getString("totalTimeInSeconds");
			Log.d("DEBUG", "time -> " + recipe.time);
			
			JSONArray imgUrlsArray = jsonObject.getJSONArray("smallImageUrls");
			recipe.imgUrls = new String[imgUrlsArray.length()];
			for (int i = 0; i < imgUrlsArray.length(); i++) {
				recipe.imgUrls[i] = imgUrlsArray.get(i).toString();
				Log.d("DEBUG", "imgUrl -> " + imgUrlsArray.get(i));
			}

			JSONArray ingredientsArray = jsonObject.getJSONArray("ingredients");
			recipe.ingredients = new ArrayList<String>(
					ingredientsArray.length());
			
			for (int i = 0; i < ingredientsArray.length(); i++) {
				recipe.ingredients.add(ingredientsArray.get(i).toString());
				Log.d("DEBUG", "ingredient -> "
						+ ingredientsArray.get(i).toString());
			}

			/*
			JSONObject flavorsObj = jsonObject.getJSONObject("flavors");
			flavors = new HashMap<String, Double>();
			try {
				Double saltyValue = null;
				saltyValue = flavorsObj.getDouble("salty");
				if (saltyValue != null) {
					flavors.put("salty", saltyValue);
				}
				Double sourValue = null;
				sourValue = flavorsObj.getDouble("sour");
				if (sourValue != null) {
					flavors.put("sour", sourValue);
				}
				Double sweetValue = null;
				sweetValue = flavorsObj.getDouble("sweet");
				if (sweetValue != null) {
					flavors.put("sweet", sweetValue);
				}
				Double bitterValue = null;
				bitterValue = flavorsObj.getDouble("bitter");
				if (bitterValue != null) {
					flavors.put("bitter", bitterValue);
				}
				Double meatyValue = null;
				meatyValue = flavorsObj.getDouble("meaty");
				if (meatyValue != null) {
					flavors.put("meaty", meatyValue);
				}
				Double piquantValue = null;
				piquantValue = flavorsObj.getDouble("piquant");
				if (piquantValue != null) {
					flavors.put("piquant", piquantValue);
				}
				for (Map.Entry<String, Double> e : flavors.entrySet()) {
					Log.d("DEBUG", e.getKey() + " -> " + e.getValue());
				}
			} catch (JSONException je) {
				je.printStackTrace();
			}
			*/

		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		return recipe;
	}

	public static ArrayList<Recipe> fromJson(JSONArray jsonArray) {
		ArrayList<Recipe> recipes = new ArrayList<Recipe>(jsonArray.length());

		for (int i = 0; i < jsonArray.length(); i++) {
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
