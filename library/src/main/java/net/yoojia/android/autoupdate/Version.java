package net.yoojia.android.autoupdate;

public class Version {

	/**
	 * 版本号 e.g: 13
	 */
	public final int code;
	
	/**
	 * 版本名 e.g: 1.0.9
	 */
	public final String name;

    /**
     * 应用名 e.g: Facebook - Android
     */
    public final String app;
	
	/**
	 * 此版本特性 e.g: Fixed bugs
	 */
	public final String feature;
	
	/**
	 * 此版本APK下载地址
	 */
	public final String targetUrl;

    /**
     * 发布时间
     */
	public final String releaseTime;

	public Version(int code, String name, String feature, String targetUrl){
		this(code, name, null, feature, targetUrl,null);
    }

    public Version(int code, String name, String app, String feature, String targetUrl, String releaseTime){
        this.code = code;
        this.name = name;
        this.app = app;
        this.feature = feature;
        this.targetUrl = targetUrl;
        this.releaseTime = releaseTime;
    }
	
	@Override
	public String toString(){
		StringBuilder buffer = new StringBuilder(":: VERSION -> ");
		buffer.append("Code:").append(code).append(", ");
		buffer.append("Name:").append(name).append(", ");
		buffer.append("AppName:").append(app).append(", ");
		buffer.append("Time:").append(releaseTime).append(", ");
		buffer.append("Feature:").append(feature).append(", ");
		buffer.append("TargetUrl:").append(targetUrl);
		return buffer.toString();
	}
	
}
