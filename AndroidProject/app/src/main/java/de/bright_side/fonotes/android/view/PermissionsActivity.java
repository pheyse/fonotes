package de.bright_side.fonotes.android.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import de.bright_side.fonotes.R;


public class PermissionsActivity extends AppCompatActivity {
	private static final int MY_PERMISSIONS_REQUEST_WRITE_STORAGE = 1;
	private Button okButton;

	public static boolean arePermissionsGranted(Context context){
		return ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		log("onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_permissions);

		okButton = (Button) findViewById(R.id.permisson_ok_button);
		okButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onRequestPermissionsButtonActionPerformed();
			}
		});
	}

	private void onRequestPermissionsButtonActionPerformed() {
		log("onRequestPermissionsButtonActionPerformed");
		ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_STORAGE);
	}

	@Override
	protected void onResume() {
		super.onResume();
		log("onResume");
		if (arePermissionsGranted(this)){
			log("permissions are granted, start main activity");
			startActivity(new Intent(this, MainActivity.class));
			finish();
//		} else {
//			onRequestPermissionsButtonActionPerformed();
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
										   String permissions[], int[] grantResults) {
		log("onRequestPermissionsResult. requestCode = " + requestCode);
		switch (requestCode) {
			case MY_PERMISSIONS_REQUEST_WRITE_STORAGE: {
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					log("granted");

					log("check if granted");
					if (arePermissionsGranted(this)){
						log("granted check: ok, start main activity");
						startActivity(new Intent(this, MainActivity.class));
						finish();
					} else {
						log("permissions were granted but check returns that the are not granted");
					}
				} else {
					log("permissions not granted by user");
					Toast.makeText(this, "The app needs the permission to start", Toast.LENGTH_LONG);
				}
				return;
			}
		}
	}

	private void log(String message){
		Log.d("BugJockey-Permissions", message);
	}
}
