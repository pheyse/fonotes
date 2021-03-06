package com.bright_side_it.fonotes.android.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.bright_side_it.fonotes.R;
import com.bright_side_it.fonotes.android.base.AndroidPlatform;
import com.bright_side_it.fonotes.android.base.FonotesAndroidBase;
import com.bright_side_it.fonotes.android.view.MainActivity;

import static android.R.attr.action;

/**
 * Created by me on 15.11.2016.
 */
public class WebServerService extends Service {
	public static final String PARAM_ACTION = "action";
	public static final String ACTION_START = "start";
	public static final String ACTION_STOP = "stop";
	private static FonotesAndroidJettyServer jettyServer;
	private static String infoString;
	private int ONGOING_NOTIFICATION_ID = 1;
	private static final String NOTIFICATION_CHANNEL_ID = "1";
	private static final int PORT = 53001;
	private static final String LOG_TAG = "Fonotes Web Server";
	private static final int PASSWORD_LENGTH = 5;

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}


	/**
	 * see also: https://developer.android.com/guide/topics/ui/notifiers/notifications.html
	 * quote: "Attempting to create an existing notification channel with its original values performs no operation,
	 * so it's safe to perform the preceding sequence of steps when starting an app"
	 */
	private void createOrRecreateNotificationChannel(){
		if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.O) {
			return; //: this is only possible and only required for version Oreo and higher
		}
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		CharSequence name = "Fonotes Web Server"; //: The user-visible name of the channel.
		int importance = NotificationManager.IMPORTANCE_HIGH;
		NotificationChannel mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, name, importance);
		mChannel.setDescription("Notifications from the Fonotes Web Server");
		mChannel.enableLights(false);
		mNotificationManager.createNotificationChannel(mChannel);
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		log("onStartCommand: action = '" + action + "'");
		String action = intent.getStringExtra(PARAM_ACTION);
		if (ACTION_START.equals(action)){
			startWebServer();
			return START_STICKY;
		} else if (ACTION_STOP.equals(action)){
			stopWebServer();
		} else {
			Log.w("Fonotes Webserver", "Unknown action: " + action);
		}
		return START_NOT_STICKY;
	}

	private void startWebServer() {
		if (jettyServer != null){
			return;
		}
		String password = generatePassword();
		jettyServer = new FonotesAndroidJettyServer(this, PORT, FonotesAndroidBase.createScreenManager(this, new AndroidPlatform(this), password, false));
		log("startWebServer: server created");

		infoString = "Password = " + password + "\n" + jettyServer.getIPAddressInfoString(PORT);

		createOrRecreateNotificationChannel();
		NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
				.setSmallIcon(R.drawable.ic_tray)
				.setContentTitle("Fonotes Server")
				.setChannelId(NOTIFICATION_CHANNEL_ID)
				.setContentText(infoString);

		Intent notificationIntent = new Intent(this, MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.setContentIntent(pendingIntent);
		startForeground(ONGOING_NOTIFICATION_ID, notification.build());

		new Thread(){
			@Override
			public void run() {
				try{
					log("startWebServer: calling start server");
					jettyServer.startServer();
					log("startWebServer: server started");
					toast("Web Server started");
				} catch (Throwable t){
					t.printStackTrace();
					stopWebServer();
					toast("Error: " + t);
				}
			}
		}.start();
	}

	private static List<Character> createPasswordCharsList() {
		List<Character> result = new ArrayList<>();
		for (char i = 'a'; i <= 'z'; i++){
			result.add(i);
		}
		for (char i = '0'; i <= '9'; i++){
			result.add(i);
		}
		return result;
	}

	private String generatePassword() {
		List<Character> chars = createPasswordCharsList();
		String result = "";
		for (int i = 0; i < PASSWORD_LENGTH; i ++){
			result += chars.get((int)(Math.random() * chars.size()));
		}
		return result;
	}

	private void stopWebServer() {
		if (jettyServer != null){
			try {
				jettyServer.stopServer();
			} catch (Exception e) {
				toast("stop server failed");
			} finally{
				jettyServer = null;
				stopForeground(true);
				stopSelf();
			}
		}
	}

	public static String getInfoString(){
		return infoString;
	}

	private void toast(final String message) {
		new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(WebServerService.this, "Fonotes Web Server: " + message, Toast.LENGTH_SHORT).show();
			}
		}, 0);
	}

	public static boolean isWebServerRunning(){
		return jettyServer != null;
	}

	private void log(String message){
		Log.d(LOG_TAG, message);
	}
}
