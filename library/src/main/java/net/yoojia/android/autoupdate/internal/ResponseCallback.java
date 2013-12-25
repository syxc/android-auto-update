package net.yoojia.android.autoupdate.internal;

import net.yoojia.android.autoupdate.Version;


public interface ResponseCallback {

    /**
     * 发现最新版本数据时被回调
     * @param version 最新新版本APK
     */
	void onFoundLatestVersion(Version version);

    /**
     * 当前版本已是最新版本
     */
	void onCurrentIsLatest();
}
