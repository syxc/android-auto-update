package net.yoojia.android.autoupdate;


/**
 * 自动更新服务的操作接口
 *
 * @author ilovedeals
 */
public interface AppUpdate {

    /**
     * 取得checkLatestVersion调用后创建的Version信息
     *
     * @return 版本对象
     */
    Version getLatestVersion();

    /**
     * 设置自定义显示新版本信息接口
     *
     * @param displayDelegate 显示接口
     */
    void setDisplayDelegate(DisplayDelegate displayDelegate);

    /**
     * 从指定URL检查新版本，并指定响应数据解析器。
     * 如果URL返回的版本码大于当前App的版本码，若没有通过setCustomVersionShowing指定版本提示的
     * 显示方式，默认弹出一个系统级窗口（需要指定 <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" /> 权限）。
     *
     * @param url    检测URL
     * @param parser 解析接口
     */
    void checkLatestVersion(String url, ResponseParser parser);

    /**
     * 如果发现新版本，无须弹出提示，直接下载并安装。
     */
    void checkAndUpdateDirectly(String url, ResponseParser parser);

    /**
     * 设置检测URL
     *
     * @param url 检测新版本的URL
     */
    void setCheckUrl(String url);

    /**
     * 设置响应解析接口
     *
     * @param parser 解析接口
     */
    void setResponseParser(ResponseParser parser);

    /**
     * 检测并弹出提示框
     */
    void checkAndShow();

    /**
     * 下载当前已经取得的版本
     */
    void downloadAndInstallCurrent();

    /**
     * 启用第三方下载器
     *
     * @param enable 是否启用
     */
    void enable3thPartyDownloader(boolean enable);

    /**
     * 从指定版本中下载并安装APK文件
     *
     * @param targetVersion 版本对象
     */
    void downloadAndInstall(Version targetVersion);


    /**
     * 在Activity中调用此方法，用以注册Receiver
     */
    void callOnResume();

    /**
     * 在Activity中调用此方法，用以反注册Receiver
     */
    void callOnPause();

    /**
     * 显示指定，是否需要提示已是最新版本
     *
     * @param flag (true：显示 false：不显示)
     */
    void showLatestVersionTip(boolean flag);
}
