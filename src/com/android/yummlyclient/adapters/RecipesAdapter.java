package com.android.yummlyclient.adapters;

import java.util.ArrayList;




//import android.R;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.yummlyclient.R;
import com.android.yummlyclient.models.Recipe;
import com.loopj.android.image.SmartImageView;

public class RecipesAdapter extends ArrayAdapter<Recipe> {

	public RecipesAdapter(Context context, ArrayList<Recipe> recipes) {
		super(context, 0, recipes);
	}

	/*
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Recipe recipe = getItem(position);
		
		if (convertView == null){
			LayoutInflater inflater = LayoutInflater.from(getContext());
			convertView = inflater.inflate(R.layout.item_recipe, null);
		}
		
		ImageView ivRecipe = (ImageView) convertView.findViewById(R.id.ivRecipe);
		TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
		
		tvName.setText(recipe.getRecipeName());
		return convertView;
	}*/
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Recipe imageInfo = this.getItem(position);
		SmartImageView svImage;
		//View rowView;
		if(convertView ==null){
			//Log.d("DEBUG", "GOT NULL");
			LayoutInflater inflater = LayoutInflater.from(getContext());
			svImage = (SmartImageView) inflater.inflate(R.layout.item_recipe, parent, false);
		} else {
			svImage = (SmartImageView) convertView;
			svImage.setImageResource(android.R.color.transparent);
		}
		if(svImage == null){
			Log.d("DEBUG", "GOT NULL");
		}
		//String[] imgUrls = imageInfo.getImageUrls();
		
		svImage.setImageUrl(imageInfo.getImageUrl());
		
		return svImage;
	}
}
