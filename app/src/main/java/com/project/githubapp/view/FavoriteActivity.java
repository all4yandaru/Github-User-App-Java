package com.project.githubapp.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.githubapp.R;
import com.project.githubapp.adapter.GithubListAdapter;
import com.project.githubapp.database.GithubDao;
import com.project.githubapp.database.GithubDatabase;
import com.project.githubapp.model.GithubUser;

import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    GithubDao githubDao;
    ArrayList<GithubUser> listFavorite = new ArrayList<>();


    GithubListAdapter githubListAdapter;

    RecyclerView rvItem;

    GithubListAdapter.OnClickListener listener = new GithubListAdapter.OnClickListener() {
        @Override
        public void onClick(GithubUser data) {
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_DATA, data);
            startActivity(intent);
            loadData();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        githubListAdapter = new GithubListAdapter(this, listener);
        githubListAdapter.notifyDataSetChanged();

        githubDao = GithubDatabase.getInstance(this).githubDao();

        rvItem = findViewById(R.id.rv_item_fav);
        rvItem.setLayoutManager(new LinearLayoutManager(this));
        rvItem.setHasFixedSize(true);
        rvItem.setAdapter(githubListAdapter);
        loadData();
    }

    void loadData(){
        List<GithubUser> data = githubDao.getAllData();
        listFavorite.clear();
        listFavorite.addAll(data);
        githubListAdapter.setData(listFavorite);
    }
}