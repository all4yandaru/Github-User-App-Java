package com.project.githubapp.view;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.githubapp.R;
import com.project.githubapp.adapter.GithubListAdapter;
import com.project.githubapp.model.GithubUser;
import com.project.githubapp.view.viewmodel.GithubViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvItem;
    GithubListAdapter githubListAdapter;
    GithubViewModel githubViewModel;
    Activity activity;

    GithubListAdapter.OnClickListener listener = new GithubListAdapter.OnClickListener() {
        @Override
        public void onClick(GithubUser data) {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_DATA, data);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        githubListAdapter = new GithubListAdapter(this, listener);
        githubListAdapter.notifyDataSetChanged();

        githubViewModel = new ViewModelProvider(this).get(GithubViewModel.class);
        githubViewModel.setGithubApi();
        githubViewModel.getGithubUser().observe(this, getUsers);

        rvItem = findViewById(R.id.rv_item);
        rvItem.setLayoutManager(new LinearLayoutManager(this));
        rvItem.setHasFixedSize(true);
        rvItem.setAdapter(githubListAdapter);
    }

    private Observer<ArrayList<GithubUser>> getUsers = new Observer<ArrayList<GithubUser>>() {
        @Override
        public void onChanged(ArrayList<GithubUser> githubUsers) {
            if (githubUsers != null){
                Log.d("getUser", githubUsers.toString());
                githubListAdapter.setData(githubUsers);
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search User");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != ""){
                    loadDataSearch(query);
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length() < 1){
                    showAllData();
                }
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.favorite:
                Intent intent = new Intent(this, FavoriteActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadDataSearch(String query){
        githubViewModel.setGithubApiSearch(query);
        githubViewModel.getGithubUserSearch().observe(this, getUsers);
    }

    private void showAllData(){
        githubViewModel.setGithubApi();
        githubViewModel.getGithubUser().observe(this, getUsers);
    }
}