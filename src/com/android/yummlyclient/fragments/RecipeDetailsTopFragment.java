package com.android.yummlyclient.fragments;

import com.android.yummlyclient.R;
import com.android.yummlyclient.models.Recipe;
import com.loopj.android.image.SmartImageView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.TextView;
public class RecipeDetailsTopFragment extends Fragment {
	SmartImageView svImage;
	TextView tvRecipeName;
	

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        svImage = (SmartImageView) view.findViewById(R.id.svRecipe);
        tvRecipeName = (TextView) view.findViewById(R.id.tvRecipeName);
        return view;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	Recipe recipe = (Recipe) getActivity().getIntent().getSerializableExtra("result");
		svImage.setImageUrl(recipe.getImageUrl());
		tvRecipeName.setText(recipe.getRecipeName());
    	super.onActivityCreated(savedInstanceState);
    }
}
