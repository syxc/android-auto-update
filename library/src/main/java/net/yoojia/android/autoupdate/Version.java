package net.yoojia.android.autoupdate;

import com.google.gson.annotations.SerializedName;

public class Version {

    public long id;
    /**
     * 版本号 e.g: 13
     */
    @SerializedName("vercode")
    public int code;

    /**
     * 版本名 e.g: 1.0.9
     */
    @SerializedName("vername")
    public String name;

    /**
     * 应用名 e.g: Facebook - Android
     */
    public String app;

    /**
     * 此版本特性 e.g: Fixed bugs
     */
    @SerializedName("note")
    public String feature;

    /**
     * 此版本APK下载地址
     */
    @SerializedName("url")
    public String targetUrl;

    /**
     * 发布时间
     */
    @SerializedName("time")
    public String releaseTime;

    /**
     * 更新级别
     */
    public int level;

    public Version(long id, int code, String name, String feature, String targetUrl, int level) {
        this(id, code, name, null, feature, targetUrl, null, level);
    }

    public Version(long id, int code, String name, String app, String feature,
                   String targetUrl, String releaseTime, int level) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.app = app;
        this.feature = feature;
        this.targetUrl = targetUrl;
        this.releaseTime = releaseTime;
        this.level = level;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(":: VERSION -> \n")
                .append("Id: ").append(id).append("\n")
                .append("Code: ").append(code).append("\n")
                .append("Name: ").append(name).append("\n")
                .append("AppName: ").append(app).append("\n")
                .append("Time: ").append(releaseTime).append("\n")
                .append("Feature: ").append(feature).append("\n")
                .append("TargetUrl: ").append(targetUrl).append("\n")
                .append("Level: ").append(level);
        return builder.toString();
    }

}
