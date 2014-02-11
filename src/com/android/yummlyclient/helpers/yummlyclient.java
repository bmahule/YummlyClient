package com.android.yummlyclient.helpers;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

public class yummlyclient {
	private final String BASE_URL = "https://api.yummly.com/v1/";
	private final String APP_ID = "3830e3d4";
	private final String APP_KEY = "da74a7e8a27f10e29bc89e1841b2af41";
	
	private AsyncHttpClient client;
	
	public yummlyclient(){
		this.client = new AsyncHttpClient();
	}

	private String getBaseUrl(){
		String url = BASE_URL + "?_app_id=" + APP_ID + "&_app_key=" + APP_KEY;
		return url;
	}
	
	public void getHomeRecipes(JsonHttpResponseHandler handler){
		String url = BASE_URL + "api/recipes";
		client.addHeader("X-Yummly-App-ID", "3830e3d4");
		client.addHeader("X-Yummly-App-Key", "da74a7e8a27f10e29bc89e1841b2af41");
		client.get(url, handler);
	}
}
