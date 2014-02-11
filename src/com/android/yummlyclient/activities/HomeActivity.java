package com.android.yummlyclient.activities;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.yummlyclient.R;
import com.android.yummlyclient.R.layout;
import com.android.yummlyclient.R.menu;
import com.android.yummlyclient.adapters.RecipesAdapter;
import com.android.yummlyclient.helpers.yummlyclient;
import com.android.yummlyclient.models.Recipe;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SearchView;

public class HomeActivity extends FragmentActivity {
	private yummlyclient client;
	private GridView lvRecipes;
	private RecipesAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		lvRecipes = (GridView) findViewById(R.id.gvRecipes);
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		adapter = new RecipesAdapter(this, recipes);
		lvRecipes.setAdapter(adapter);
		getRecipes();
	}

	private void getRecipes() {
		client = new yummlyclient();
		client.getHomeRecipes(new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(int code, JSONObject body) {
				JSONArray recipes = null;
				try{
					recipes = body.getJSONArray("matches");
					ArrayList<Recipe> listRecipes = Recipe.fromJson(recipes);
					for (Recipe recipe : listRecipes){
						adapter.add(recipe);
					}
				}catch(JSONException e){
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		
		// Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.ic_search)
                .getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
 
        return super.onCreateOptionsMenu(menu);
		//return true;
		//return super.onCreateOptionsMenu(menu);
	}
	
	/*
	public void onClickSearch(MenuItem mi) { 
	    //Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
	    //startActivity(i);
	}*/
	
	public void onClickFavorites(MenuItem mi) { 
	    //Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
	    //startActivity(i);
	}

}
