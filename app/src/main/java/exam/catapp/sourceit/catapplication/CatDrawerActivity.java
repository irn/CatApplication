package exam.catapp.sourceit.catapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import exam.catapp.sourceit.catapplication.adapter.CatRecycleAdapter;
import exam.catapp.sourceit.catapplication.model.Cat;
import exam.catapp.sourceit.catapplication.network.CatLoadingListener;
import exam.catapp.sourceit.catapplication.network.LoadAsyncTask;

public class CatDrawerActivity extends AppCompatActivity implements CatLoadingListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_drawer);

        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Toast.makeText(getBaseContext(), String.format("Click on item %s", menuItem.getTitle()), Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawers();
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        LoadAsyncTask asyncTask = new LoadAsyncTask(this, this);
        asyncTask.execute();
    }

    @Override
    public void startLoading() {
        Toast.makeText(this, "Start loading", Toast.LENGTH_LONG).show();
    }

    @Override
    public void finishLoading(List<Cat> cats) {
        CatRecycleAdapter adapter = new CatRecycleAdapter(cats, null);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
    }
}
