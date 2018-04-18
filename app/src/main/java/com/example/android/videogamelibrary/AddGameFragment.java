package com.example.android.videogamelibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddGameFragment extends Fragment {

    private ActivityCallback activityCallback;
    private VideoGameDatabase videoGameDatabase;

    
    @BindView(R.id.add_game_edittext)
    protected EditText gameTitle;
    @BindView(R.id.add_genre_edittext)
    protected EditText gameGenre;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_game, container, false);
        ButterKnife.bind(this, view);

        return view;
    }


    public static AddGameFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AddGameFragment fragment = new AddGameFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onStart() {
        super.onStart();
        videoGameDatabase = ((VideoGameApplication) getActivity().getApplicationContext()).getDatabase();
    }



    @OnClick(R.id.add_game_fab)
    protected void addButtonClicked() {
        //TODO Check that both fields have text ... Get title and grnre from edittexts, create new videogame object with this info, send to database to be saved and toast
        
        if(gameTitle.getText().toString().isEmpty() || gameGenre.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "All fields are required", Toast.LENGTH_LONG).show();
        } else {

//            String gameName = gameTitle.getText().toString();
//            String genre = gameGenre.getText().toString();
            VideoGame videoGame = new VideoGame(gameTitle.getText().toString(), gameGenre.getText().toString(), new Date());


            /// Could've done created object here
            //VideoGame videoGame = new VideoGame(gameName, genre, new Date());
            // OR.... not created gameName/genre variables, and just used getText.toString into other

//            addGameToDatabase(gameName, genre);
            addGameToDatabase(videoGame);


            Toast.makeText(getActivity(), "Game Added!!", Toast.LENGTH_LONG).show();

            //******************** FIX ABOVE FROM HER ADJUSTMENTS ************

        }
        

    }

//    private void addGameToDatabase(final String gameName, final String genre) {

    private void addGameToDatabase(final VideoGame videoGame) {

//        VideoGame videoGame = new VideoGame(gameName, genre, new Date());
        videoGameDatabase.videoGameDao().addVideoGame(videoGame);
        activityCallback.addClicked();

    }


    public void attachParent(ActivityCallback activityCallback) {
        this.activityCallback = activityCallback;
    }

    public interface ActivityCallback {

        void addClicked();
    }

}
