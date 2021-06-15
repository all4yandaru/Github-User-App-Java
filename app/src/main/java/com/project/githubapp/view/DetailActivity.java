package com.project.githubapp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.project.githubapp.R;
import com.project.githubapp.database.GithubDao;
import com.project.githubapp.database.GithubDatabase;
import com.project.githubapp.model.GithubUser;
import com.project.githubapp.service.GithubResponse;
import com.project.githubapp.view.tablayout.SectionPagerAdapter;
import com.project.githubapp.view.viewmodel.GithubViewModel;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_DATA = "extra_data";
    private GithubUser githubUser;

    GithubViewModel githubViewModel;
    GithubDao githubDao;
    private boolean isFavorite = false;

    CircleImageView civProfile;
    TextView tvName, tvLogin, tvLocation, tvFollowers, tvFollowing;
    ImageButton ibtnFavorite;

    private final String[] TAB_TITLES = new String[]{
            "Followers",
            "Following"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        githubUser = getIntent().getParcelableExtra(EXTRA_DATA);

        ibtnFavorite = findViewById(R.id.ibtn_favorite);
        civProfile = findViewById(R.id.civ_profile);
        tvName = findViewById(R.id.tv_name);
        tvLogin = findViewById(R.id.tv_login);
        tvLocation = findViewById(R.id.tv_location);
        tvFollowers = findViewById(R.id.tv_followers);
        tvFollowing = findViewById(R.id.tv_following);

        githubViewModel = new ViewModelProvider(this).get(GithubViewModel.class);
        githubViewModel.setGithubApiDetail(githubUser.getLogin());
        githubViewModel.getGithubDetail().observe(this, getDetailUser);

        //ibtnFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.favorite_filled));
        githubDao = GithubDatabase.getInstance(this).githubDao();
        isFavorite = githubDao.dataExist(githubUser.getLogin());
        if (isFavorite){
            ibtnFavorite.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.favorite_filled));
        } else {
            ibtnFavorite.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.favorite));
        }

        ibtnFavorite.setOnClickListener(this);

        // Section Pager
        SectionPagerAdapter sectionsPagerAdapter = new SectionPagerAdapter(this, githubUser.getLogin());
        ViewPager2 viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        new TabLayoutMediator(tabs, viewPager,
                (tab, position) -> tab.setText(TAB_TITLES[position])
        ).attach();
        if(getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }

    private Observer<GithubResponse> getDetailUser = new Observer<GithubResponse>() {
        @Override
        public void onChanged(GithubResponse githubResponse) {
            if (githubResponse != null){
                Picasso.get()
                        .load(githubResponse.getAvatarUrl())
                        .into(civProfile);

                tvName.setText(githubResponse.getName());
                tvLogin.setText(githubResponse.getLogin());
                tvLocation.setText(githubResponse.getLocation());
                tvFollowers.setText(githubResponse.getFollowers() + "");
                tvFollowing.setText(githubResponse.getFollowing() + "");
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibtn_favorite:
                isFavorite = githubDao.dataExist(githubUser.getLogin());
                if (isFavorite){
                    githubDao.deleteData(githubUser);
                    ibtnFavorite.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.favorite));
                    Log.d("favorite", "dislike");
                } else {
                    githubDao.insertData(githubUser);
                    ibtnFavorite.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.favorite_filled));
                    Log.d("favorite", "like");
                }
                break;
        }
    }
}