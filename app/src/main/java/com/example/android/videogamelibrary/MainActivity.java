package com.example.android.videogamelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements VideoGameAdapter.AdapterCallback, AddGameFragment.ActivityCallback {

    @BindView(R.id.games_recycler_view)
    protected RecyclerView recyclerView;

    private VideoGameDatabase videoGameDatabase;
    private VideoGameAdapter videoGameAdapter;
//    private List<VideoGame> videoGameList;
    private LinearLayoutManager linearLayoutManager;
    private AddGameFragment addGameFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        videoGameDatabase = ((VideoGameApplication) getApplicationContext()).getDatabase();

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        videoGameAdapter = new VideoGameAdapter(videoGameDatabase.videoGameDao().getVideoGames(), this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(videoGameAdapter);
        videoGameAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.add_game_button)
    protected void addGameButtonClicked() {

        AddGameFragment addGameFragment = AddGameFragment.newInstance();
        addGameFragment.attachParent(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, addGameFragment).commit();


    }


    @Override
    public void addClicked() {
        //TODO Remove Fragment from view, update adapter with new info from database

        getSupportFragmentManager().beginTransaction().remove(addGameFragment).commit();
        videoGameAdapter.updateList(videoGameDatabase.videoGameDao().getVideoGames());


    }
}
