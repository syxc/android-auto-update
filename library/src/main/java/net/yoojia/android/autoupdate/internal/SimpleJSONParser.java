package net.yoojia.android.autoupdate.internal;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.yoojia.android.autoupdate.ResponseParser;
import net.yoojia.android.autoupdate.Version;

public class SimpleJsonParser implements ResponseParser {

    @Override
    public Version parser(String response) {
        Version version = null;
        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(response);
        if (jsonElement.isJsonObject()) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            int code = jsonObject.get("code").getAsInt();
            if (code == 0) {
                version = new Gson().fromJson(jsonObject.get("msg"), Version.class);
                Log.i("SimpleJsonParser", version.toString());
            }
        }
        return version;
    }

}
