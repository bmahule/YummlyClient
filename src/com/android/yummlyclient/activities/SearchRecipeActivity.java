package com.android.yummlyclient.activities;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

import com.android.yummlyclient.R;
import com.android.yummlyclient.R.layout;
import com.android.yummlyclient.R.menu;
import com.android.yummlyclient.R.id;

public class SearchRecipeActivity extends Activity {
	private TextView txtQuery;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_recipe);
		
		// get the action bar
        ActionBar actionBar = getActionBar();
        // Enabling Back navigation on Action Bar icon
        actionBar.setDisplayHomeAsUpEnabled(true);
        txtQuery = (TextView) findViewById(R.id.tv_search_items);
        handleIntent(getIntent());
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		setIntent(intent);
		handleIntent(intent);
	}

	private void handleIntent(Intent intent) {
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            /**
             * Use this query to display search results like 
             * 1. Getting the data from SQLite and showing in listview 
             * 2. Making webrequest and displaying the data 
             * For now we just display the query only
             */
            txtQuery.setText("Search Query: " + query);
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_recipe, menu);
		return true;
	}

}
