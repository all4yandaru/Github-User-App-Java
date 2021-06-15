package com.project.githubapp.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.project.githubapp.model.GithubUser;

import java.util.List;

@Dao
public interface GithubDao {
    @Query("SELECT * FROM user")
    List<GithubUser> getAllData();

    @Insert
    void insertData(GithubUser githubUser);

    @Update
    void updateData(GithubUser githubUser);

    @Delete
    void deleteData(GithubUser githubUser);

    @Query("SELECT EXISTS (SELECT * FROM user WHERE login = :login)")
    boolean dataExist(String login);
}
