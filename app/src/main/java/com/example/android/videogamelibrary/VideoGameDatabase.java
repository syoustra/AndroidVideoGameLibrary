package com.example.android.videogamelibrary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;


@Database(version = 1, entities = VideoGame.class)
@TypeConverters(DateConverter.class)
abstract class VideoGameDatabase extends RoomDatabase {

    public abstract VideoGameDao videoGameDao();

}


