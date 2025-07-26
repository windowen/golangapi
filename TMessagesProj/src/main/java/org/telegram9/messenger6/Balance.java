package org.telegram9.messenger6;

public class Balance {
    private String level;
    private String ts;
    private String caller;
    private String msg;
    private DecData decData;
    private BalanceInfo balanceInfo;
    private Metadata metadata;

    // Getters & Setters...

    public static class DecData {
        private String agentKey;
        private String currency;
        private String extName;
        private String gameId;
        private String gameName;
        private String lang;
        private String nickname;
        private String operatorCode;
        private int userId;
        // Getters & Setters...
    }

    public static class BalanceInfo {
        private int result;
        private String balance;
        private String currency;
        private String exchangeRate;
        // Getters & Setters...
    }

    public static class Metadata {
        private int userId;
        // Getters & Setters...
    }
}

//    // 解析示例
//    Gson gson = new Gson();
//    Balance log = gson.fromJson(jsonString, Balance.class);
//System.out.println("用户余额: " + log.getBalanceInfo().getBalance());
//
//{
//        "level": "info",
//        "ts": "2025-07-26T00:11:25.993+0800",
//        "caller": "game/winto_callback.go:62",
//        "msg": "winGetBalance",
//        "decData": {
//        "agentKey": "85AE9BA1E01BBD082735DE62F99C15F4",
//        "currency": "THB",
//        "extName": "win_win_slot_1010_Hal_of_Dawn",
//        "gameId": "1010",
//        "gameName": "Hal  of Dawn",
//        "lang": "en",
//        "nickname": "q6t",
//        "operatorCode": "YV1012P",
//        "userId": 902815
//        },
//        "balanceInfo": {
//        "result": 1,
//        "balance": "48161.484",
//        "currency": "THB",
//        "exchangeRate": "35"
//        },
//        "metadata": {
//        "userId": 902815
//        }
//        }