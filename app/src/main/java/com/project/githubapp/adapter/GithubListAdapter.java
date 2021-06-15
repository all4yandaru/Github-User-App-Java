package com.project.githubapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.githubapp.R;
import com.project.githubapp.model.GithubUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GithubListAdapter extends RecyclerView.Adapter<GithubListAdapter.ViewHolder> {

    ArrayList<GithubUser> githubUsers = new ArrayList<>();
    Context context;

    OnClickListener mCallback;

    public GithubListAdapter(Context context, OnClickListener mCallback) {
        this.context = context;
        this.mCallback = mCallback;
    }

    public void setData(ArrayList<GithubUser> items){
        githubUsers.clear();
        githubUsers.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(githubUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return githubUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAvatar;
        TextView tvUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvUser = itemView.findViewById(R.id.tv_user);
        }

        public void bind(final GithubUser data){
            tvUser.setText(data.getLogin());
            Picasso.get()
                    .load(data.getAvatar_url())
                    .into(ivAvatar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCallback.onClick(data);
                }
            });
        }
    }

    public interface OnClickListener {
        void onClick(GithubUser data);
    }
}
