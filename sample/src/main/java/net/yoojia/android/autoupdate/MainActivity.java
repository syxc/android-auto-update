package net.yoojia.android.autoupdate;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import net.yoojia.android.autoupdate.internal.SimpleJSONParser;

public class MainActivity extends Activity {

	AppUpdate appUpdate;
	
	final static String UPDATE_URL = "http://api.ilovedeals.sg/app_release/latest?app_type=android-mobile";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		appUpdate = AppUpdateService.getAppUpdate(this);
		
		View check = findViewById(R.id.check);
		check.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 检查最新版本，并弹出窗口
				appUpdate.checkLatestVersion(UPDATE_URL, 
						new SimpleJSONParser());
			}
		});
		
		View download = findViewById(R.id.download);
		download.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 无须提示，直接升级
				appUpdate.checkAndUpdateDirectly(UPDATE_URL, 
						new SimpleJSONParser());
			}
		});
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		
		// ******** 
		appUpdate.callOnResume();
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		
		// ******** 
		appUpdate.callOnPause();
	}

}
