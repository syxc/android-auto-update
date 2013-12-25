package net.yoojia.android.autoupdate.internal;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import net.yoojia.android.autoupdate.ResponseParser;
import net.yoojia.android.autoupdate.Version;

public class SimpleJSONParser implements ResponseParser{

    @Override
    public Version parser(String response) {
        Version version = null;
        try{
            JSONTokener jsonParser = new JSONTokener(response);
            JSONObject versionObject = (JSONObject) jsonParser.nextValue();
            int versionCode = versionObject.getInt("versionCode");
            String versionName = versionObject.getString("versionName");
            String releaseNote = versionObject.getString("releaseNote");
            String releaseUrl = versionObject.getString("releaseUrl");
            String releaseTime = versionObject.getString("releaseTime");
            String releaseApp = versionObject.getString("releaseApp");
            version = new Version(versionCode,versionName, releaseApp, releaseNote,releaseUrl, releaseTime);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return version;
    }

}
