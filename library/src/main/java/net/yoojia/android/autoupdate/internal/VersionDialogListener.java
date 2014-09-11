package net.yoojia.android.autoupdate.internal;

public interface VersionDialogListener {
    void doUpdate(boolean laterOnWifi);

    void doIgnore();
}
