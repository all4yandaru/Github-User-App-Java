package com.project.githubapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class GithubUser implements Parcelable {
    @PrimaryKey(autoGenerate = true) // auto increment
    @ColumnInfo(name = "id") // nama kolom
    private int id;

    @ColumnInfo(name = "login")
    private String login;

    @ColumnInfo(name = "avatar_url")
    private String avatar_url;

    private String name;
    private String public_repos;
    private String followers;
    private String following;
    private String company;
    private String location;
    private String blog;

    public GithubUser(String login, String avatar_url, String name, String public_repos, String followers, String following, String company, String location, String blog) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.name = name;
        this.public_repos = public_repos;
        this.followers = followers;
        this.following = following;
        this.company = company;
        this.location = location;
        this.blog = blog;
    }

    protected GithubUser(Parcel in) {
        id = in.readInt();
        login = in.readString();
        avatar_url = in.readString();
        name = in.readString();
        public_repos = in.readString();
        followers = in.readString();
        following = in.readString();
        company = in.readString();
        location = in.readString();
        blog = in.readString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getName() {
        return name;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public String getFollowers() {
        return followers;
    }

    public String getFollowing() {
        return following;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getBlog() {
        return blog;
    }

    public static final Creator<GithubUser> CREATOR = new Creator<GithubUser>() {
        @Override
        public GithubUser createFromParcel(Parcel in) {
            return new GithubUser(in);
        }

        @Override
        public GithubUser[] newArray(int size) {
            return new GithubUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(login);
        dest.writeString(avatar_url);
        dest.writeString(name);
        dest.writeString(public_repos);
        dest.writeString(followers);
        dest.writeString(following);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeString(blog);
    }
}
