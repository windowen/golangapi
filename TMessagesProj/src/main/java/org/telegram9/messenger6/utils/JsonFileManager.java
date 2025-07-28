package org.telegram9.messenger6.utils;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonFileManager {
    private static final String FILE_NAME = "chats_info.json";

//    文件存储位置说明
//    文件将保存在应用的内部存储目录中：
//
//    text
///data/data/<your.package.name>/files/chats_info.json

    // 写入 JSON 数据到文件
    public static void saveData(Context context, JSONArray jsonArray) {
        File file = new File(context.getFilesDir(), FILE_NAME);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 从文件读取 JSON 数据
    public static JSONArray loadData(Context context) {
        File file = new File(context.getFilesDir(), FILE_NAME);
        if (!file.exists()) {
            return new JSONArray(); // 文件不存在时返回空数组
        }

        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            return new JSONArray(content.toString());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }
}