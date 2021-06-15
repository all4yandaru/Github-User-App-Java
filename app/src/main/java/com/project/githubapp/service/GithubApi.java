package com.project.githubapp.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubApi {
    private Retrofit retrofit;

    private static final String URL_BASE = "https://api.github.com/";

    public GithubRepository getGithubApi() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GithubRepository.class);
    }
}
