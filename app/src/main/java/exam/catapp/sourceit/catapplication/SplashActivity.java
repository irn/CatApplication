package exam.catapp.sourceit.catapplication;

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

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (!isFinishing()) {

                    Intent intent;
                    if (sharedPreferences.getBoolean("HelpShowed", false) == false) {
                        intent = new Intent(getBaseContext(), HelpActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        sharedPreferences.edit().putBoolean("HelpShowed", true).apply();
                    } else {
                        intent = new Intent(getBaseContext(), CatDrawerActivity.class);
                    }
                    startActivity(intent);

                }

            }
        }, 3000);    }
}
