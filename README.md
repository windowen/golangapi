## Telegram messenger for Android

[Telegram](https://telegram.org) is a messaging app with a focus on speed and security. It’s superfast, simple and free.
This repo contains the official source code for [Telegram App for Android](https://play.google.com/store/apps/details?id=org.telegram.messenger).

## Creating your Telegram Application

We welcome all developers to use our API and source code to create applications on our platform.
There are several things we require from **all developers** for the moment.

1. [**Obtain your own api_id**](https://core.telegram.org/api/obtaining_api_id) for your application.
2. Please **do not** use the name Telegram for your app — or make sure your users understand that it is unofficial.
3. Kindly **do not** use our standard logo (white paper plane in a blue circle) as your app's logo.
3. Please study our [**security guidelines**](https://core.telegram.org/mtproto/security_guidelines) and take good care of your users' data and privacy.
4. Please remember to publish **your** code too in order to comply with the licences.

### API, Protocol documentation

Telegram API manuals: https://core.telegram.org/api

MTproto protocol manuals: https://core.telegram.org/mtproto

### Compilation Guide

**Note**: In order to support [reproducible builds](https://core.telegram.org/reproducible-builds), this repo contains dummy release.keystore,  google-services.json and filled variables inside BuildVars.java. Before publishing your own APKs please make sure to replace all these files with your own.

You will require Android Studio 3.4, Android NDK rev. 20 and Android SDK 8.1

1. Download the Telegram source code from https://github.com/DrKLO/Telegram ( git clone https://github.com/DrKLO/Telegram.git )
2. Copy your release.keystore into TMessagesProj/config
3. Fill out RELEASE_KEY_PASSWORD, RELEASE_KEY_ALIAS, RELEASE_STORE_PASSWORD in gradle.properties to access your  release.keystore
4.  Go to https://console.firebase.google.com/, create two android apps with application IDs org.telegram.messenger and org.telegram.messenger.beta, turn on firebase messaging and download google-services.json, which should be copied to the same folder as TMessagesProj.
5. Open the project in the Studio (note that it should be opened, NOT imported).
6. Fill out values in TMessagesProj/src/main/java/org/telegram/messenger/BuildVars.java – there’s a link for each of the variables showing where and which data to obtain.
7. You are ready to compile Telegram.

### Localization

We moved all translations to https://translations.telegram.org/en/android/. Please use it.



正确解决方案
⚠️ 你 不能 把 google-services.json 和 com.google.gms.google-services 插件放在 TMessagesProj（Library）模块里。

你应该：

✅ 步骤一：删除或注释掉 TMessagesProj/build.gradle 中的以下内容
❌ 删掉：
groovy
复制
编辑
apply plugin: 'com.google.gms.google-services'
✅ 步骤二：把 Firebase 配置放到 主运行模块（通常是 TMessagesProj_App）
比如你的目录：

Telegram-release-11.4.2-5469/
├── TMessagesProj/              ← 是 Library
├── TMessagesProj_App/          ← 是 Application ✅ 应放 google-services.json
确保：
TMessagesProj_App/build.gradle 里写的是：

groovy
复制
编辑
apply plugin: 'com.android.application'
apply plugin: 'com.google.gms.google-services'
有这个：

groovy
复制
编辑
android {
...
defaultConfig {
applicationId "org.telegram9.messenger6.cd6.at20230704"  // ← ✅ 必须匹配 json
...
}
}
然后放 google-services.json 到：

pgsql
复制
编辑
Telegram-release-11.4.2-5469/TMessagesProj_App/google-services.json
✅ 步骤三：运行正确的构建模块
构建时请执行：

bash
复制
编辑
./gradlew :TMessagesProj_App:assembleDebug
❗ 不要再构建 :TMessagesProj，那是库模块，它不能用 google-services.json

🔧 如果你非要在 Library 模块中使用 Firebase（不推荐）
需要额外做法，不使用 google-services.json 插件，手动初始化 Firebase SDK。但对你现在的情况 没必要，主模块支持即可。

✅ 总结
模块	类型	是否应该用 google-services.json
TMessagesProj	library	❌ 不应该
TMessagesProj_App	application	✅ 应该放 google-services.json

如果你想，我可以为你修改 TMessagesProj_App/build.gradle 的模板并提供最小可运行配置。只需告诉我是否使用了 Kotlin 或 Java 即可。


34.0.0
21.4.7075529
jdk17

34
19