package com.diligentia;

import com.google.common.io.BaseEncoding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;


public class TestMobileCryptoHeaders {
    private static final Gson GSON = new GsonBuilder().create();

    public static String getCurrentMobileDevice(String deviceUid) {
        JsonObject jsonElement = new JsonObject();
        jsonElement.addProperty("app_id", deviceUid);
        return BaseEncoding.base64().encode(GSON.toJson(jsonElement).getBytes());
    }

    public static void main(String[] args) {
        System.out.println(getCurrentMobileDevice("LG_G6"));
    }
}
