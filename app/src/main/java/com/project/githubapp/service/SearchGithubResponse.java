package com.project.githubapp.service;

import com.google.gson.annotations.SerializedName;
import com.project.githubapp.model.GithubUser;

import java.util.ArrayList;

public class SearchGithubResponse{

	@SerializedName("total_count")
	private int totalCount;

	@SerializedName("incomplete_results")
	private boolean incompleteResults;

	@SerializedName("items")
	private ArrayList<GithubUser> items;

	public int getTotalCount(){
		return totalCount;
	}

	public boolean isIncompleteResults(){
		return incompleteResults;
	}

	public ArrayList<GithubUser> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"SearchGithubResponse{" + 
			"total_count = '" + totalCount + '\'' + 
			",incomplete_results = '" + incompleteResults + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}