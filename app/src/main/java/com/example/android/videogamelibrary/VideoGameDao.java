package com.example.android.videogamelibrary;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao                                                         //tells Room this is our Data Access Object
public interface VideoGameDao {

    //Allow us to get all videogames
    @Query("SELECT * FROM videogame")
    List<VideoGame> getVideoGames();

    //Allow us to add a single game to the list
    @Insert
    void addVideoGame(VideoGame videoGame);               // void makes it looks like method, but no { }

    //Allow us to update the values of an existing game
    @Update
    void updateVideoGame (VideoGame videoGame);

    //Allow us to delete a game from the library
    @Delete
    void deleteVideoGame (VideoGame videoGame);


}
