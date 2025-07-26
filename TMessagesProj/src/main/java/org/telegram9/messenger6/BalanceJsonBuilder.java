package org.telegram9.messenger6;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class BalanceJsonBuilder {
    public static void main(String[] args) {
        // 1. 创建 Gson 实例（可以配置格式化输出）
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // 2. 构建 DecData 对象
        Balance.DecData decData = new Balance.DecData();
//        decData.setAgentKey("85AE9BA1E01BBD082735DE62F99C15F4");
//        decData.setCurrency("THB");
//        decData.setExtName("winto_winto_slot_1010_Hal_and_the_Wings_of_Dawn");
//        decData.setGameId("1010");
//        decData.setGameName("Hal and the Wings of Dawn");
//        decData.setLang("en");
//        decData.setNickname("q6t");
//        decData.setOperatorCode("YVYPXP");
//        decData.setUserId(902815);
//
//        // 3. 构建 BalanceInfo 对象
//        Balance.BalanceInfo balanceInfo = new Balance.BalanceInfo();
//        balanceInfo.setResult(1);
//        balanceInfo.setBalance("48161.484");
//        balanceInfo.setCurrency("THB");
//        balanceInfo.setExchangeRate("35");

        // 4. 构建 Metadata 对象
//        Balance.Metadata metadata = new Balance.Metadata();
//        metadata.setUserId(902815);

        // 5. 构建主对象
        Balance response = new Balance();
//        response.setLevel("info");
//        response.setTs("2025-07-26T00:11:25.993+0800");
//        response.setCaller("game/winto_callback.go:62");
//        response.setMsg("winToGetBalance");
//        response.setDecData(decData);
//        response.setBalanceInfo(balanceInfo);
//        response.setMetadata(metadata);

        // 6. 转换为 JSON 字符串
        String json = gson.toJson(response);
        System.out.println(json);
    }

    public static void main2(String[] args) {
        // 1. 创建 Gson 实例（可以配置格式化输出）
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // 2. 构建 DecData 对象
        Balance.DecData decData = new Balance.DecData();
//        decData.setAgentKey("85AE9BA1E01BBD082735DE62F99C15F4");
//        decData.setCurrency("THB");
//        decData.setExtName("winto_winto_slot_1010_Hal_and_the_Wings_of_Dawn");
//        decData.setGameId("1010");
//        decData.setGameName("Hal and the Wings of Dawn");
//        decData.setLang("en");
//        decData.setNickname("q6t");
//        decData.setOperatorCode("YVYPXP");
//        decData.setUserId(902);
//
//        // 3. 构建 BalanceInfo 对象
//        Balance.BalanceInfo balanceInfo = new Balance.BalanceInfo();
//        balanceInfo.setResult(1);
//        balanceInfo.setBalance("48161.484");
//        balanceInfo.setCurrency("THB");
//        balanceInfo.setExchangeRate("35");
//
//        // 4. 构建 Metadata 对象
//        Balance.Metadata metadata = new Balance.Metadata();
//        metadata.setUserId(9028);
//
//        // 5. 构建主对象
        Balance response = new Balance();
//        response.setLevel("info");
//        response.setTs("2025-07-26T00:11:25.993+0800");
//        response.setCaller("game/winto_callback.go:62");
//        response.setMsg("winToGetBalance");
//        response.setDecData(decData);
//        response.setBalanceInfo(balanceInfo);
//        response.setMetadata(metadata);

        // 6. 转换为 JSON 字符串
        String json = gson.toJson(response);
        System.out.println(json);


        Map<String, Object> params = new HashMap<>();
        params.put("operatorId", "agent123");
        params.put("sign", 12345);
        params.put("size", 100);
        params.put("lang", "en");
        params.put("startTime", String.valueOf(System.currentTimeMillis()));
        params.put("endTime", String.valueOf(System.currentTimeMillis()));

        Gson gson2 = new Gson();
        gson2.toJson(params);
    }
//
//4. 简化版（如果不需要所有字段）
//    使用 GsonBuilder().setPrettyPrinting() 可以让输出的 JSON 格式化更美观
//
//    @SerializedName 注解可以处理字段名不一致的情况
//
//            嵌套对象需要逐层构建
//
//    对于简单场景，可以直接用 Map 组装，但结构化类更易于维护
//
//    // 快速构建示例
//    Map<String, Object> response = new HashMap<>();
//    Map<String, Object> decData = new HashMap<>();
//decData.put("agentKey", "85AE9BA1E01BBD082735DE62F99C15F4");
//// ...添加其他decData字段
//
//    Map<String, Object> balanceInfo = new HashMap<>();
//balanceInfo.put("balance", "48161.484");
//// ...添加其他balanceInfo字段
//
//response.put("decData", decData);
//response.put("balanceInfo", balanceInfo);
//
//    String json = new Gson().toJson(response);
}
//
//
//
//2025-07-26 13:35:19.713 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:16766] coder2025收到普通消息channel_id: 今晚 消息 | 来自ID: 8079455068 | 群组ID: 2775669177
//        2025-07-26 13:35:19.718 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:22249] coder2025收到消息: Coder_511 | 来自ID: 8079455068
//        2025-07-26 13:35:19.729 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:22260] coder2025收到消息 packageName: Aoj73TEJayfLqlRP5YK+zchQgzgA6LCSTmsSzSXYbSiaIWxr7AIBP8+4fwntISK1
//        2025-07-26 13:35:19.739 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:22274] coder2025收到消息 apkJsons: {"fromUserName":"Coder_511","fromChannelId":2775669177,"fromUserId":8079455068,"targetUserId":7738584148,"message":"今晚","operatorId":"Aoj73TEJayfLqlRP5YK+zchQgzgA6LCSTmsSzSXYbSiaIWxr7AIBP8+4fwntISK1"}
//        2025-07-26 13:35:19.742 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:16810] coder2025群组名称: 功能测试 chat.username = null
//        2025-07-26 13:35:20.852 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:22285] coder2025用户消息: 已转发至用户: 7738584148
//        2025-07-26 13:35:23.059 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:16766] coder2025收到普通消息channel_id: 今晚 En
//        tonight
//
//        Cambodian:
//        យប់នេហ 消息 | 来自ID: 7652002179 | 群组ID: 2775669177
//        2025-07-26 13:35:23.062 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:22249] coder2025收到消息: tran_kh_cn_bot | 来自ID: 7652002179
//        2025-07-26 13:35:23.069 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:22260] coder2025收到消息 packageName: Aoj73TEJayfLqlRP5YK+zchQgzgA6LCSTmsSzSXYbSiaIWxr7AIBP8+4fwntISK1
//        2025-07-26 13:35:23.072 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:22274] coder2025收到消息 apkJsons: {"fromUserName":"tran_kh_cn_bot","fromChannelTitle":"功能测试","fromChannelId":2775669177,"fromUserId":7652002179,"targetUserId":7738584148,"message":"今晚 En \ntonight\n\n Cambodian:\nយប់នេហ","operatorId":"Aoj73TEJayfLqlRP5YK+zchQgzgA6LCSTmsSzSXYbSiaIWxr7AIBP8+4fwntISK1"}
//        2025-07-26 13:35:23.073 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:16810] coder2025群组名称: 功能测试 chat.username = null
//        2025-07-26 13:35:24.329 19303-19355 tmessages               org...essenger6.cd6.at20230704.beta  D  [MessagesController.java:22285] coder2025用户消息: 已转发至用户: 7738584148

