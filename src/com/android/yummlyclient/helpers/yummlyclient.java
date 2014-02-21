package com.android.yummlyclient.helpers;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class yummlyclient {
	private final String BASE_URL = "https://api.yummly.com/v1/";
	private final String APP_ID = "3830e3d4";
	private final String APP_KEY = "da74a7e8a27f10e29bc89e1841b2af41";
	private String baseUrl;
	
	private AsyncHttpClient client;
	
	public yummlyclient(){
		
		baseUrl = BASE_URL + "api/recipes";
		this.client = new AsyncHttpClient();
		client.addHeader("X-Yummly-App-ID", "3830e3d4");
		client.addHeader("X-Yummly-App-Key", "da74a7e8a27f10e29bc89e1841b2af41");
	}

	private String getBaseUrl(){
		String url = BASE_URL + "?_app_id=" + APP_ID + "&_app_key=" + APP_KEY;
		return url;
	}
	
	public void getHomeRecipes(JsonHttpResponseHandler handler){
		client.get(baseUrl, handler);
	}
	
	public void getSearchedRecipes(String query, JsonHttpResponseHandler handler){
		String searchQuery = query.replaceAll("(\\W|_)+", "+");
		String searchUrl = baseUrl + "?q=" + searchQuery;
		client.get(searchUrl, handler);
	}
}
