package exam.catapp.sourceit.catapplication;

import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import exam.catapp.sourceit.catapplication.adapter.CatFragmentAdapter;
import exam.catapp.sourceit.catapplication.database.CatDatabase;
import exam.catapp.sourceit.catapplication.model.Cat;

public class DetailTabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ViewPager viewPager = findViewById(R.id.viewPager);

        CatDatabase catDatabase = Room.databaseBuilder(this, CatDatabase.class, "cats.db").build();

        catDatabase.catDao().getLiveDataAll().observe(this, new Observer<List<Cat>>() {
            @Override
            public void onChanged(@Nullable List<Cat> cats) {
                CatFragmentAdapter catFragmentAdapter = new CatFragmentAdapter(getSupportFragmentManager(), cats);
                viewPager.setAdapter(catFragmentAdapter);
            }
        });


    }

}
