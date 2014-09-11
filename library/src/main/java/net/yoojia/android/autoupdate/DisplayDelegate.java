package net.yoojia.android.autoupdate;


/**
 * 自定义显示最新版本信息
 *
 * @author ilovedeals
 */
public interface DisplayDelegate {

    /**
     * 显示最新版本数据
     *
     * @param version 版本数据
     */
    void showFoundLatestVersion(Version version);

    /**
     * 当前版本已经是最新版本
     */
    void showIsLatestVersion();
}