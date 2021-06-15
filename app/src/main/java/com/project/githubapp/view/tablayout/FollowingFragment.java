package com.project.githubapp.view.tablayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.githubapp.R;
import com.project.githubapp.adapter.GithubListAdapter;
import com.project.githubapp.model.GithubUser;
import com.project.githubapp.view.DetailActivity;
import com.project.githubapp.view.viewmodel.GithubViewModel;

import java.util.ArrayList;

public class FollowingFragment extends Fragment {

    private String login;

    RecyclerView rvItem;
    GithubListAdapter githubListAdapter;
    GithubViewModel githubViewModel;

    GithubListAdapter.OnClickListener listener = new GithubListAdapter.OnClickListener() {
        @Override
        public void onClick(GithubUser data) {
            Intent intent = new Intent(getContext(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_DATA, data);
            startActivity(intent);
            getActivity().finish();
        }
    };

    public FollowingFragment(String login) {
        this.login = login;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_following, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        githubListAdapter = new GithubListAdapter(getContext(), listener);
        githubListAdapter.notifyDataSetChanged();

        githubViewModel = new ViewModelProvider(this).get(GithubViewModel.class);
        githubViewModel.setGithubApiFollow(this.login, "following");
        githubViewModel.getGithubUserFollow().observe((LifecycleOwner) getContext(), getUserFollow);

        rvItem = view.findViewById(R.id.rv_item);
        rvItem.setLayoutManager(new LinearLayoutManager(getContext()));
        rvItem.setHasFixedSize(true);
        rvItem.setAdapter(githubListAdapter);
    }

    private Observer<ArrayList<GithubUser>> getUserFollow = new Observer<ArrayList<GithubUser>>() {
        @Override
        public void onChanged(ArrayList<GithubUser> githubUsers) {
            if (githubUsers != null){
                githubListAdapter.setData(githubUsers);
            }
        }
    };
}