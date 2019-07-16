# AndroidUtilCodeKTX

一直有关注 [Blankj](https://github.com/Blankj) 的开源项目 [AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode), 到目前为止将近有 `24k` star。在以往的开发过程中，我也经常参考其中的工具类实现。但是自从切换到 `Kotlin` 作为主力开发语言以来，仍然生搬硬套其中的工具类显得并不是那么优雅，没有很好的利用 Kotlin 的语言特性，遂决定整理 `AndroidUtilCodeKTX` 这个库，完全基于 Kotlin 实现，收集 Android 开发中常用的工具类。

该库不会是 [AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode) 的 Kotlin 翻译版本，更多的还是基于我在开发过程中的需求进行完善，由于个人精力有限，可能并不是那么完善，欢迎大家通过 [issue](https://github.com/lulululbj/AndroidUtilCodeKTX/issues) 提出自己的意见 ！

## APIS (keep updating...)

***

### [权限相关](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/permission/PermissionExt.kt)  [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/app/src/main/java/luyao/util/ktx/ui/PermissionExtActivity.kt)

```kotlin
FragmentActivity.request(vararg permissions: String, callbacks: PermissionsCallbackDSL.() -> Unit)
```

### [AppExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/AppExt.kt)

```kotlin
Context.versionName: String
Context.versionCode: Long
Context.getAppInfo(apkPath: String): AppInfo
Context.getAppInfos(apkFolderPath: String): List<AppInfo>
Context.getAppSignature(packageName: String = this.packageName): ByteArray?
```

### [CommonExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/CommonExt.kt)

```kotlin
Context.dp2px(dp: Float): Int
Context.px2dp(px: Float): Int
View.dp2px(dp: Float): Int
View.px2dp(px: Float): Int
Context.screenWidth
Context.screenHeight
Context.copyToClipboard(label: String, text: String)
```

### [HashExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/HashExt.kt) [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/test/java/luyao/util/ktx/ext/HashExtKtTest.kt)

```kotlin
ByteArray.hash(algorithm: Hash): String
String.hash(algorithm: Hash, charset: Charset = Charset.forName("utf-8")): String
ByteArray.md5Bytes(): ByteArray
ByteArray.md5(): String
String.md5(charset: Charset = Charset.forName("utf-8")): String
ByteArray.sha1Bytes(): ByteArray
ByteArray.sha1(): String
String.sha1(charset: Charset = Charset.forName("utf-8")): String
ByteArray.sha224Bytes(): ByteArray
ByteArray.sha224(): String
String.sha224(charset: Charset = Charset.forName("utf-8")): String
ByteArray.sha256Bytes(): ByteArray
ByteArray.sha256(): String
String.sha256(charset: Charset = Charset.forName("utf-8")): String
ByteArray.sha384Bytes(): ByteArray
ByteArray.sha384(): String
String.sha384(charset: Charset = Charset.forName("utf-8")): String
ByteArray.sha512Bytes(): ByteArray
ByteArray.sha512(): String
String.sha512(charset: Charset = Charset.forName("utf-8")): String
File.hash(algorithm: Hash = Hash.SHA1): String
```

### [AesExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/AesExt.kt)  [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/test/java/luyao/util/ktx/ext/AesExtKtTest.kt)

```kotlin
ByteArray.aesEncrypt(key: ByteArray, iv: ByteArray, cipherAlgotirhm: String = AES_CFB_NOPADDING): ByteArray
ByteArray.aesDecrypt(key: ByteArray, iv: ByteArray, cipherAlgotirhm: String = AES_CFB_NOPADDING): ByteArray 
File.aesEncrypt(key: ByteArray, iv: ByteArray, destFilePath: String): File?
File.aesDecrypt(key: ByteArray, iv: ByteArray, destFilePath: String): File?
```

### [IntentExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/IntentExt.kt)  [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/app/src/main/java/luyao/util/ktx/ui/IntentExtActivity.kt)

```kotlin
Context.getAppInfoIntent(packageName: String = this.packageName): Intent
Context.goToAppInfoPage(packageName: String = this.packageName)
Context.getDateAndTimeIntent(): Intent
Context.goToDateAndTimePage()
Context.getLanguageIntent()
Context.goToLanguagePage() 
Context.getInstallIntent(apkFile: File): Intent?
Context.goToAccessibilitySetting()
Context.installApk(apkFile: File)
Context.openBrowser(url: String)
Context.openInAppStore(packageName: String = this.packageName)
Context.openApp(packageName: String)
Context.uninstallApp(packageName: String) 
```

### [LogExt]()

```kotlin
String.logv(tag: String = TAG)
String.logd(tag: String = TAG)
String.logi(tag: String = TAG)
String.logw(tag: String = TAG)
String.loge(tag: String = TAG)
```

### [ToastExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/ToastExt.kt) [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/app/src/main/java/luyao/util/ktx/ui/ToastExtActivity.kt)

```kotlin
Context.toast(content: String, duration: Int = Toast.LENGTH_SHORT)
Context.toast(@StringRes id: Int, duration: Int = Toast.LENGTH_SHORT)
Context.longToast(content: String)
Context.longToast(@StringRes id: Int)
Any.toast(context: Context, content: String, duration: Int = Toast.LENGTH_SHORT)
Any.toast(context: Context, @StringRes id: Int, duration: Int=Toast.LENGTH_SHORT) 
Any.longToast(context: Context, content: String)
Any.longToast(context: Context, @StringRes id: Int)
```

### [SharedPreferencesExt]()

```kotlin
fun <T> Context.putSpValue(key: String, value: T, name: String = packageName)
fun <T> Activity.putSpValue(key: String, value: T, name: String = packageName)
fun <T> Context.getSpValue(key: String, default: T, name: String = packageName ): T
fun <T> Activity.getSpValue(key: String, default: T, name: String = packageName): T
```

### [SystemServiceExt]()

```kotlin
val Context.windowManager
val Context.clipboardManager
val Context.layoutInflater
val Context.activityManager
val Context.powerManager
val Context.alarmManager
val Context.notificationManager
val Context.keyguardManager
val Context.locationManager
val Context.searchManager
val Context.storageManager
val Context.vibrator
val Context.connectivityManager
val Context.wifiManager
val Context.audioManager
val Context.mediaRouter
val Context.telephonyManager
val Context.sensorManager
val Context.subscriptionManager
val Context.carrierConfigManager
val Context.inputMethodManager
val Context.uiModeManager
val Context.downloadManager
val Context.batteryManager
val Context.jobScheduler
```

### [TransformExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/TransformExt.kt)

```kotlin
ByteArray.toHexString() : 字节数组转十六进制字符串
```

### [ViewExt]()

```kotlin
View.visible()
View.invisible()
View.gone()
var View.isVisible: Boolean
var View.isInvisible: Boolean
var View.isGone: Boolean
View.setPadding(@Px size: Int)
View.postDelayed(delayInMillis: Long, crossinline action: () -> Unit): Runnable
View.toBitmap(config: Bitmap.Config = Bitmap.Config.ARGB_8888): Bitmap
```