package com.android.yummlyclient.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.yummlyclient.R;
import com.android.yummlyclient.models.Recipe;
import com.loopj.android.image.SmartImageView;

public class RecipeDetailsAdapter extends ArrayAdapter<String> {
	Context context;
	int id;
	ArrayList<String> list;
	
	public RecipeDetailsAdapter(Context context, int id, ArrayList<String> list) {
		super(context, id, list);  
		this.context=context;
		this.id = id;
		this.list = list;
	}

	public RecipeDetailsAdapter(Context context, ArrayList<String> list) {
		super(context, 0, list);  
		this.context=context;
		this.list = list;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			//LayoutInflater inflater = LayoutInflater.from(getContext());
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = (RelativeLayout) inflater.inflate(R.layout.fragment_bottom, parent, false);
			
		} 
		//ListView lvIngredient = (ListView) convertView.findViewById(R.id.lvIngredients);
		//lvIngredient.setAdapter(adapter);
		//lvIngredient.getRecipeDetailsAdapter();
		return convertView;
	}

}
