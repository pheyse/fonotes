package de.bright_side.fonotes.android.base;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

import de.bright_side.fonotes.BuildConfig;
import de.bright_side.fonotes.android.service.WebServerService;
import de.bright_side.fonotes.android.view.WebServerActivity;
import de.bright_side.fonotes.common.base.FileUtil;
import de.bright_side.fonotes.common.base.Platform;

/**
 * Created by me on 08.12.2016.
 */

public class AndroidPlatform implements Platform {
	private Context context;
	private static final String LOG_TAG = "Fonotes";
	private boolean webServerRunning;

	public AndroidPlatform(Context context){
		this.context = context;
	}

	@Override
	public File getApplicationDataDir() throws Exception {
		File rootDir = Environment.getExternalStorageDirectory();
		if (!rootDir.exists()) throw new Exception("Root directory >>" + rootDir + "<< does not exist!");
		String flavorInfo = "";
		if (!BuildConfig.FLAVOR.isEmpty()){
			flavorInfo = "_" + BuildConfig.FLAVOR;
		}
		String typeInfo = "";
		if (!"release".equals(BuildConfig.BUILD_TYPE)){
			typeInfo = "_" + BuildConfig.BUILD_TYPE;
		}
		File dir = new File(rootDir, context.getPackageName() + flavorInfo + typeInfo);
		if (!dir.exists()) dir.mkdirs();
		if (!dir.exists()) throw new Exception("Directory >>" + dir + "<< does not exist and could not be created");
		return dir;
	}

	private static String singleExceptionToString(Throwable exception){
		if (exception == null) return null;
		StringBuilder sb = new StringBuilder();
		String message = exception.getLocalizedMessage();
		if ((message == null) || (message.length() == 0)){
			message = exception.getMessage();
		}
		message = "'" + exception + "':'" + message + "'";
		sb.append(message);
		for (StackTraceElement i: exception.getStackTrace()){
			sb.append("\n   at " + i.getFileName() + ":" + i.getMethodName() + ":" + i.getLineNumber());
		}
		return sb.toString();
	}

	private static String toStringAndroidBugfix(Throwable exception){
		try{
			if (exception == null) return "null";
			if (exception == null) return "null";
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			exception.printStackTrace(new PrintWriter(byteArrayOutputStream, true));
			String result = new String(byteArrayOutputStream.toByteArray());
			if (result.length() == 0){
				StringBuilder sb = new StringBuilder();
				Throwable i = exception;
				while (i != null){
					if (sb.length() > 0) sb.append("\nCaused by:\n");
					sb.append(singleExceptionToString(i));
					i = i.getCause();
				}
				result = sb.toString();
			}
			return result;
		} catch (Throwable e){
			return "" + e;
		}
	}

	@Override
	public void handleError(Exception e) {
		try{
			Log.e(LOG_TAG, "handleError: " + e, e);
			File errorLogFile = new File(getApplicationDataDir(), "errors.txt");
			String versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
			FileUtil.writeFile(errorLogFile, "Version " + versionName + ", " + new Date() + ": Error:\n" + toStringAndroidBugfix(e));
		} catch (Throwable internalException){
			Log.e(LOG_TAG, "" + internalException, internalException);
		}
	}

	@Override
	public void startWebServer() {
		log("startWebServer");

		Intent intent = new Intent(context, WebServerService.class);
		intent.putExtra(WebServerService.PARAM_ACTION, WebServerService.ACTION_START);
		context.startService(intent);

		context.startActivity(new Intent(context, WebServerActivity.class));
	}

	@Override
	public void log(String message){
		Log.d(LOG_TAG, message);
	}

}
