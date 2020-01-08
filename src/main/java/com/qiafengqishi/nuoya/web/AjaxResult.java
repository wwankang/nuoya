package com.qiafengqishi.nuoya.web;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class AjaxResult {

    public static String success() {
        return success(null);
    }
    public static String success(Object obj) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Map<String, String> map = new HashMap<String, String>();
        map.put("status", "success");
        if (obj instanceof String) {
            map.put("data", (String) obj);
        } else {
            map.put("data", gson.toJson(obj));
        }

        return gson.toJson(map);
    }

    public static String failAlert(Object obj) {
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
        Map<String, String> map = new HashMap<String, String>();
        map.put("status", "failed");
        map.put("data", gson.toJson(obj));

        return gson.toJson(map);
    }
}
