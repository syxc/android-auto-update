Android Auto-Update Framework
============

An Android Library, provide a easy way to update app automatically.

Android App自动更新（非Service）。

## 简单的使用例子

``` java

public class MainActivity extends Activity {

	AppUpdate appUpdate;
	
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
				appUpdate.checkLatestVersion("http://api.ilovedeals.sg/app_release/latest?app_type=android-mobile", 
						new SimpleJSONParser());
			}
		});
		
		View download = findViewById(R.id.download);
		download.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// 在执行检查操作后，用户取消下载，可以通过此方法，下载最新版本。
				appUpdate.downloadAndInstall();
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

```

## 捐助

	开源是一种态度，不是义务。
	
	如果您觉得本开源项目对你有帮助，您可以对作者捐助 1 元以示支持。
	
支付宝捐助地址： [桥下一粒砂](https://me.alipay.com/yoojiachen)

----

## Copyright and License

```
Copyright 2013 chenyoca@gmail.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
````
