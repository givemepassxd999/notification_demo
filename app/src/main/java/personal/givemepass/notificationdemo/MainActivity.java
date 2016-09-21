package personal.givemepass.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
	private Intent intent;
	private Button button;
	private static final int NOTIFICATION_ID = 0;
	private NotificationManager notificationManger;
	private Notification notification;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button) findViewById(R.id.send_notify_btn);
		notificationManger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		intent = new Intent();
		intent.setClass(MainActivity.this, HandleNotification.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_CLEAR_TASK);
		PendingIntent pendingIntent =
				PendingIntent.getActivity(this, NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);

		notification = new Notification.Builder(this)
				.setSmallIcon(android.R.drawable.sym_def_app_icon)
				.setContentTitle("Hi")
				.setContentText("Nice to meet you.")
				.setContentIntent(pendingIntent)
				.build(); // available from API level 11 and onwards
		notification.flags = Notification.FLAG_AUTO_CANCEL;
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				notificationManger.notify(0, notification);
			}
		});

	}
}
