package org.telegram9.messenger6.utils;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

import org.json.JSONObject;

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

    public static JSONObject loadObjectData(Context context) {
        try {
            File file = new File(context.getFilesDir(), FILE_NAME);
            if (file.exists()) {
                String content = readFile(file);
                return new JSONObject(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String readFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        br.close();
        return sb.toString();
    }

    public static void saveJSONObjectData(Context context, JSONObject data) {
        try {
            FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(data.toString().getBytes("UTF-8"));
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 添加新的 chatid 到 JSON 数据 {"chat_id":[2775669177,2684291490]}
    public static void addNewChatId(Context context, long newChatId) {
        try {
            // 1. 读取现有数据
            JSONObject jsonData = loadObjectData(context);
            if (jsonData == null) {
                jsonData = new JSONObject();
                jsonData.put("chat_id", new JSONArray()); // 初始化空数组
            }

            // 2. 获取 chatids 数组
            JSONArray chatIds = jsonData.optJSONArray("chat_id");
            if (chatIds == null) {
                chatIds = new JSONArray();
                jsonData.put("chat_id", chatIds);
            }

            // 3. 检查是否已存在（避免重复）
            boolean exists = false;
            for (int i = 0; i < chatIds.length(); i++) {
                if (chatIds.getLong(i) == newChatId) {
                    exists = true;
                    break;
                }
            }

            // 4. 添加新 chatid（如果不存在）
            if (!exists) {
                chatIds.put(newChatId);
            }

            // 5. 保存更新后的数据
            saveJSONObjectData(context, jsonData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取存储的 chat_id 数组
     * @param context Android 上下文
     * @return 包含所有 chat_id 的 JSONArray，如果不存在则返回空数组
     */
    public static JSONArray getChatIdsArray(Context context) {
        try {
            JSONObject jsonData = loadObjectData(context);
            if (jsonData != null) {
                JSONArray chatIds = jsonData.optJSONArray("chat_id");
                return chatIds != null ? chatIds : new JSONArray();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new JSONArray(); // 默认返回空数组
    }

    /**
     * 检查指定群组ID是否在监控列表中（非线程安全）
     * @param context Android上下文
     * @param chatId 要检查的群组ID
     * @return 如果存在返回true，否则返回false
     */
    public static boolean isMonitoredGroup(Context context, long chatId) {
        JSONArray chatIds = getChatIdsArray(context);
        for (int i = 0; i < chatIds.length(); i++) {
            if (chatIds.optLong(i) == chatId) {
                return true;
            }
        }
        return false;
    }
}