package com.project.githubapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.project.githubapp.model.GithubUser;

@Database(entities = GithubUser.class, version = 1)
public abstract class GithubDatabase extends RoomDatabase {
    private static final String DB_NAME = "db_github";
    private static GithubDatabase instance;

    public abstract GithubDao githubDao();

    public static GithubDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), GithubDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
