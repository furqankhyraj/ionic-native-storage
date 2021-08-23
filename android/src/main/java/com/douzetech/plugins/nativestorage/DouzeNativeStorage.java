package com.douzetech.plugins.nativestorage;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;


import android.Manifest;
import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@NativePlugin(
        requestCodes = {DouzeNativeStorage.REQUEST_CONTACTS}
)
public class DouzeNativeStorage extends Plugin {
    protected static final int REQUEST_CONTACTS = 12345;

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.success(ret);
    }

    @PluginMethod()
    public void getContacts(PluginCall call) {
        String value = call.getString("filter");
        loadContacts(call);
    }

    void loadContacts(PluginCall call) {
        ArrayList<Map> contactList = new ArrayList<>();
        Map<String, String> map = new HashMap<String, String>();
        SharedPreferences prefs = (SharedPreferences) getContext().getSharedPreferences("MyPrefsFile", android.content.Context.MODE_PRIVATE);
        String quote = prefs.getString("quote", "No name defined");//"No name defined" is the default value.
        String id = prefs.getString("id", "none"); //0 is the default value.
        String author = prefs.getString("author", "none"); //0 is the default value.
        String language = prefs.getString("language", "none"); //0 is the default value.
        String category_id = prefs.getString("category_id", "none"); //0 is the default value.

        map.put("quote", quote);
        map.put("author", author);
        map.put("widget", "");
        map.put("openWith", "");
        map.put("language", language);
        map.put("liked", null);
        map.put("category_id", category_id);
        map.put("id", id);
        contactList.add(map);
        JSONArray jsonArray = new JSONArray(contactList);
        JSObject ret = new JSObject();
        ret.put("results", jsonArray);
        call.success(ret);
    }
}
