package net.yoojia.android.autoupdate.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.yoojia.android.autoupdate.ResponseParser;
import net.yoojia.android.autoupdate.Version;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;

public class VerifyTask extends AsyncTask<String, Integer, Version> {

	private ResponseParser parser;
	private ResponseCallback callback;
	private Context context;
	
	public VerifyTask(Context context,ResponseParser parser, ResponseCallback callback){
		this.parser = parser;
		this.context = context;
		this.callback = callback;
	}
	
	@Override
	protected Version doInBackground(String... args) {
		String url = args[0];
        String response = null;
		try {
			URL targetUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) targetUrl.openConnection();
			InputStream is = connection.getInputStream();
            response = toStringBuffer(is).toString();
			is.close();
			connection.disconnect();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return response == null ? null : parser.parser(response);
	}

    @Override
    protected void onPostExecute(Version latestVersion) {
        if(latestVersion == null) return; // 为null,网络异常，不做处理。
        if(comparedWithCurrentPackage(latestVersion)){
			callback.onFoundLatestVersion(latestVersion);
		}else{
			callback.onCurrentIsLatest();
		}
    } 
	
	boolean comparedWithCurrentPackage(Version version){
		if(version == null) return false;
		int currentVersionCode = 0;
		try {
			PackageInfo pkg = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			currentVersionCode = pkg.versionCode;
		} catch (NameNotFoundException exp) {
			exp.printStackTrace();
		}
		return version.code > currentVersionCode;
	}
	
	StringBuffer toStringBuffer(InputStream is) throws IOException{
	    if( null == is) return null;
	    BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuffer buffer = new StringBuffer();
		String line = null;
		while ((line = in.readLine()) != null){
		      buffer.append(line).append("\n");
		}
		is.close();
		return buffer;
	}

}
