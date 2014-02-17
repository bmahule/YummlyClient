package com.android.yummlyclient.fragments;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.yummlyclient.R;
import com.android.yummlyclient.adapters.RecipeDetailsAdapter;
import com.android.yummlyclient.adapters.RecipesAdapter;
import com.android.yummlyclient.models.Recipe;

public class RecipeDetailsBottomFragment extends Fragment {
	ListView lvIngredients;
	RecipeDetailsAdapter adapter;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_bottom, container,false);
        lvIngredients = (ListView) view.findViewById(R.id.lvIngredients);
             
        Recipe recipe = (Recipe) getActivity().getIntent().getSerializableExtra("result");
		ArrayList<String> ingredients = recipe.getIngredients();
		adapter = new RecipeDetailsAdapter(getActivity(), R.id.fragmentBottom, ingredients);
		 for (int i = 0; i < ingredients.size(); i++) {
				Log.d("DEBUG", "-------ingredient -> "+ ingredients.get(i).toString());
			}
		 
		 adapter.addAll(ingredients);
		 lvIngredients.setAdapter(adapter);

        Log.d("DEBUG", "onCreateView IS CALLED");
        return view;
    }
    
    @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
    	Log.d("DEBUG", "onActivityCreated IS CALLED");
		Recipe recipe = (Recipe) getActivity().getIntent().getSerializableExtra("result");
		ArrayList<String> ingredients = recipe.getIngredients();
		adapter = new RecipeDetailsAdapter(getActivity(), ingredients);
		 for (int i = 0; i < ingredients.size(); i++) {
				Log.d("DEBUG", ">>>>>>>ingredient -> "+ ingredients.get(i).toString());
			}

		adapter.addAll(ingredients);		
		lvIngredients.setAdapter(adapter);
		super.onActivityCreated(savedInstanceState);
    }
    
    public RecipeDetailsAdapter getRecipeDetailsAdapter(){
    	return adapter;
    }

}
