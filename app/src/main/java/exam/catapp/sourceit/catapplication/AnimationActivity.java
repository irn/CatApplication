package exam.catapp.sourceit.catapplication;

import android.graphics.drawable.ClipDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import exam.catapp.sourceit.catapplication.model.Cat;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        final View view = findViewById(R.id.textViewClip);

        Cat cat = new Cat();
        cat.setDescription("fdhdhf");

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                ClipDrawable drawable = (ClipDrawable) view.getBackground();
                drawable.setLevel(drawable.getLevel() + 100);
                view.postDelayed(this, 500);
            }
        }, 3000);


    }
}
