package com.project.githubapp.service;

import com.project.githubapp.model.GithubUser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GithubRepository {
    @GET("users?") // users? itu diambil dari https://api.github.com/users?since=30
    Call<ArrayList<GithubUser>> getUsers(@Query("since") int random);

    @GET("users/{username}")
    Call<GithubResponse> getDetailUser(@Path("username") String username);

    @GET("users/{username}/{follow}")
    Call<ArrayList<GithubUser>> getUserFollow(@Path("username") String username, @Path("follow") String follow);

    @GET("search/users?")
    Call<SearchGithubResponse> getSearchUser(@Query("q") String search);

}
