package com.bright_side_it.fonotes.android.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.bright_side_it.fonotes.R;
import com.bright_side_it.fonotes.android.service.WebServerService;

public class WebServerActivity extends AppCompatActivity {
	private TextView webServerFragmentInfoLabel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getSupportActionBar().show();

		setContentView(R.layout.activity_web_server);
		webServerFragmentInfoLabel = (TextView) findViewById(R.id.webServerFragmentInfoLabel);
		Button webServerFragmentStopButton = (Button) findViewById(R.id.webServerFragmentStopButton);
		webServerFragmentStopButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(WebServerActivity.this, WebServerService.class);
				intent.putExtra(WebServerService.PARAM_ACTION, WebServerService.ACTION_STOP);
				startService(intent);
				startActivity(new Intent(WebServerActivity.this, MainActivity.class));
				finish();
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (!WebServerService.isWebServerRunning()){
			startActivity(new Intent(this, MainActivity.class));
			finish();
			return;
		}
		webServerFragmentInfoLabel.setText(WebServerService.getInfoString());
	}
}
