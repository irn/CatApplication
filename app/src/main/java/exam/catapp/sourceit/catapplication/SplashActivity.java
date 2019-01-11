package exam.catapp.sourceit.catapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isFinishing()) {
                    boolean isHelpShown = preferences.getBoolean("isHelpShown", false);
                    Intent intent;
                    if (isHelpShown) {
                        intent = new Intent(getBaseContext(), CatDrawerActivity.class);
                    } else {
                        SharedPreferences.Editor edit = preferences.edit();
                        edit.putBoolean("isHelpShown", true);
                        edit.apply();
                        intent = new Intent(getBaseContext(), HelpActivity.class);
                    }
                    startActivity(intent);
                }
            }
        }, 3000);
    }


}
