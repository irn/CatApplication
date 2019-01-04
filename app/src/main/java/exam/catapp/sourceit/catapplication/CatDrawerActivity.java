package exam.catapp.sourceit.catapplication;

import android.app.ActivityOptions;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import exam.catapp.sourceit.catapplication.adapter.CatRecycleAdapter;
import exam.catapp.sourceit.catapplication.adapter.OnCatClickListener;
import exam.catapp.sourceit.catapplication.database.CatDatabase;
import exam.catapp.sourceit.catapplication.database.DBinitialize;
import exam.catapp.sourceit.catapplication.databinding.ItemCatBinding;
import exam.catapp.sourceit.catapplication.model.Cat;
import exam.catapp.sourceit.catapplication.network.CatLoadingListener;
import exam.catapp.sourceit.catapplication.network.LoadAsyncTask;

public class CatDrawerActivity extends AppCompatActivity implements CatLoadingListener {

    private DrawerLayout drawerLayout;

    private RecyclerView recyclerView;

    private CatRecycleAdapter adapter;

    private CatDatabase catDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_drawer);

        drawerLayout = findViewById(R.id.drawer_layout);

        catDatabase = DBinitialize.initialize(this);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Toast.makeText(getBaseContext(), "Clicked menu item - "+menuItem.getTitle(), Toast.LENGTH_LONG).show();

                String gender="";
                if (menuItem.getItemId() == R.id.idFemale){
                    gender = "female";
                } else gender = "male";

                catDatabase.catDao().getCatsByGender(gender).observe(CatDrawerActivity.this, new Observer <List<Cat>>(){
                    @Override
                    public void onChanged(@Nullable List<Cat> cats) {
                        adapter.setData(cats);
                    }
                });

                drawerLayout.closeDrawers();
                return false;
            }
        });

        recyclerView = findViewById(R.id.recyclerViewDrawer);


        LoadAsyncTask loadAsyncTask = new LoadAsyncTask(this, this);
        loadAsyncTask.execute();

    }

    @Override
    public void startLoading() {

    }

    @Override
    public void finishLoading(List<Cat> cats) {
        adapter = new CatRecycleAdapter(cats, new OnCatClickListener() {
            @Override
            public void onCatClick(Cat cat, int position) {
                Intent intent = new Intent(getBaseContext(), DetailActivity.class);
                intent.putExtra("id", cat.getId());
                ItemCatBinding binding = DataBindingUtil.bind(recyclerView.findViewHolderForAdapterPosition(position).itemView);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(CatDrawerActivity.this, binding.imageView, "cat");
                ActivityCompat.startActivity(CatDrawerActivity.this, intent, options.toBundle());
            }
        });

        recyclerView.setAdapter(adapter);

    };
}
