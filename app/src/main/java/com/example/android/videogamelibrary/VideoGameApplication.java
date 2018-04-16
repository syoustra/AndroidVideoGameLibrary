package com.example.android.videogamelibrary;

import android.app.Application;
import android.arch.persistence.room.Room;

public class VideoGameApplication extends Application {

    private VideoGameDatabase database;
    public static String DATABASE_NAME = "video_game_database";

    @Override
    public void onCreate() {
        super.onCreate();

        database = Room.databaseBuilder(getApplicationContext(), VideoGameDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()           //small enough app that queries don't need to be done elsewhere
                .build();

    }

    public VideoGameDatabase getDatabase() {
        return database;
    }
}
