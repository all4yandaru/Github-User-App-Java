package com.project.githubapp.view.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.githubapp.model.GithubUser;
import com.project.githubapp.service.GithubApi;
import com.project.githubapp.service.GithubResponse;
import com.project.githubapp.service.SearchGithubResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubViewModel extends ViewModel {
    private GithubApi githubApi;
    private MutableLiveData<ArrayList<GithubUser>> listGithub = new MutableLiveData<>();
    private MutableLiveData<GithubResponse> detailResponse = new MutableLiveData<>();
    private MutableLiveData<ArrayList<GithubUser>> listGithubFollow = new MutableLiveData<>();

    // get all data ============
    public void setGithubApi() {
        if (this.githubApi == null){
            githubApi = new GithubApi();
        }
        githubApi.getGithubApi().getUsers(50).enqueue(new Callback<ArrayList<GithubUser>>() {
            @Override
            public void onResponse(Call<ArrayList<GithubUser>> call, Response<ArrayList<GithubUser>> response) {
                ArrayList<GithubUser> githubUsers = response.body();
                if (githubUsers != null){
                    listGithub.postValue(githubUsers);
                    Log.d("viewmodel", githubUsers.toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<GithubUser>> call, Throwable t) {
                Log.d("viewmodel", t.getMessage());
            }
        });
    }

    public LiveData<ArrayList<GithubUser>> getGithubUser(){
        return listGithub;
    }

    // get user follower or following data =======================
    public void setGithubApiFollow(String username, String followType) {
        if (this.githubApi == null){
            githubApi = new GithubApi();
        }
        githubApi.getGithubApi().getUserFollow(username, followType).enqueue(new Callback<ArrayList<GithubUser>>() {
            @Override
            public void onResponse(Call<ArrayList<GithubUser>> call, Response<ArrayList<GithubUser>> response) {
                ArrayList<GithubUser> githubUsers = response.body();
                if (githubUsers != null){
                    listGithubFollow.postValue(githubUsers);
                    Log.d("viewmodelFollow", githubUsers.toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<GithubUser>> call, Throwable t) {
                Log.d("viewmodelFollow", t.getMessage());
            }
        });
    }

    public LiveData<ArrayList<GithubUser>> getGithubUserFollow(){
        return listGithubFollow;
    }

    // get detail data ===================
    public void setGithubApiDetail(String username){
        if (this.githubApi == null){
            githubApi = new GithubApi();
        }
        githubApi.getGithubApi().getDetailUser(username).enqueue(new Callback<GithubResponse>() {
            @Override
            public void onResponse(Call<GithubResponse> call, Response<GithubResponse> response) {
                GithubResponse githubResponse = response.body();
                if (githubResponse != null){
                    detailResponse.postValue(githubResponse);
                    Log.d("viewmodel", githubResponse.toString());
                }
//                GithubUser user = new GithubUser(
//                        githubResponse.getLogin(),
//                        githubResponse.getAvatarUrl(),
//                        githubResponse.getName(),
//                        String.valueOf(githubResponse.getPublicRepos()),
//                        String.valueOf(githubResponse.getFollowers()),
//                        String.valueOf(githubResponse.getFollowers()),
//                        githubResponse.getCompany(),
//                        githubResponse.getLocation(),
//                        githubResponse.getBlog()
//                );
            }

            @Override
            public void onFailure(Call<GithubResponse> call, Throwable t) {
                Log.d("viewmodel", t.getMessage());
            }
        });
    }

    public LiveData<GithubResponse> getGithubDetail(){ return detailResponse; }


    // get search data ================
    public void setGithubApiSearch(String search) {
        if (this.githubApi == null){
            githubApi = new GithubApi();
        }
        Log.d("querySearch", search);
        githubApi.getGithubApi().getSearchUser(search).enqueue(new Callback<SearchGithubResponse>() {
            @Override
            public void onResponse(Call<SearchGithubResponse> call, Response<SearchGithubResponse> response) {
                SearchGithubResponse searchGithubResponse = response.body();
                if (searchGithubResponse != null){
                    ArrayList<GithubUser> searchItems = searchGithubResponse.getItems();
                    listGithub.postValue(searchItems);
                }
            }

            @Override
            public void onFailure(Call<SearchGithubResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<GithubUser>> getGithubUserSearch(){
        return listGithub;
    }
}
