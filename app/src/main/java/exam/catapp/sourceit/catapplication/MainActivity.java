package exam.catapp.sourceit.catapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import exam.catapp.sourceit.catapplication.adapter.CatRecycleAdapter;
import exam.catapp.sourceit.catapplication.adapter.OnCatClickListener;
import exam.catapp.sourceit.catapplication.databinding.ItemCatBinding;
import exam.catapp.sourceit.catapplication.model.Cat;
import exam.catapp.sourceit.catapplication.network.CatLoadingListener;
import exam.catapp.sourceit.catapplication.network.LoadAsyncTask;

public class MainActivity extends AppCompatActivity implements CatLoadingListener {

    RecyclerView recyclerView;

    View emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        emptyView = findViewById(R.id.emptyView);

        LoadAsyncTask loadAsyncTask = new LoadAsyncTask(this, this);
        loadAsyncTask.execute();
    }

    @Override
    public void startLoading() {
        recyclerView.setVisibility(View.GONE);
        emptyView.setVisibility(View.VISIBLE);
    }

    @Override
    public void finishLoading(List<Cat> cats) {
        recyclerView.setVisibility(View.VISIBLE);
        emptyView.setVisibility(View.GONE);
        final CatRecycleAdapter adapter = new CatRecycleAdapter(cats, new OnCatClickListener() {
            @Override
            public void onCatClick(Cat cat, int position) {
                Intent intent = new Intent(getBaseContext(), DetailActivity.class);
                intent.putExtra("id", cat.getId());
                ItemCatBinding binding = DataBindingUtil.bind(recyclerView.findViewHolderForAdapterPosition(position).itemView);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, binding.imageView, "cat");
                ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
