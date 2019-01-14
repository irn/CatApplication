package exam.catapp.sourceit.catapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity {

    private int notId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notId = 1;

        Button btn = findViewById(R.id.buttonNot);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(v.getContext());
                builder.setContentTitle("context title");
                builder.setContentText("content text");
                builder.setSmallIcon(R.drawable.ic_launcher_background);

                NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
                inboxStyle.setBigContentTitle("big contents title");
                String[] strings = new String[4];
                for (int i=0; i<strings.length; i++){
                    strings[i] = "content #"+i;
                    inboxStyle.addLine(strings[i]);
                }
                inboxStyle.setSummaryText("summary text");
                builder.setStyle(inboxStyle);


                Intent resultIntent = new Intent(v.getContext(), CatDrawerActivity.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(v.getContext());
                stackBuilder.addParentStack(CatDrawerActivity.class);
                stackBuilder.addNextIntent(resultIntent);

                PendingIntent pendingIntent = stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

                builder.setContentIntent(pendingIntent);

                Notification notification = builder.build();

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(v.getContext());
                notificationManagerCompat.notify(notId++, notification);
            }
        });

    }
}
