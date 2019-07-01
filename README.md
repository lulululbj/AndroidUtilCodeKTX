# AndroidUtilCodeKTX

一直有关注 [Blankj](https://github.com/Blankj) 的开源项目 [AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode), 到目前为止将近有 `24k` star。在以往的开发过程中，我也经常参考其中的工具类实现。但是自从切换到 `Kotlin` 作为主力开发语言以来，仍然生搬硬套其中的工具类显得并不是那么优雅，没有很好的利用 Kotlin 的语言特性，遂决定整理 `AndroidUtilCodeKTX` 这个库，完全基于 Kotlin 实现，收集 Android 开发中常用的工具类。

该库不会是 [AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode) 的 Kotlin 翻译版本，更多的还是基于我在开发过程中的需求进行完善，由于个人精力有限，可能并不是那么完善，欢迎大家通过 [issue](https://github.com/lulululbj/AndroidUtilCodeKTX/issues) 提出自己的意见 ！

## APIS (keep updating...)

***

### [权限相关](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/permission/PermissionExt.kt)

```kotlin
fun FragmentActivity.request()
```

### [AppExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/AppExt.kt)

```kotlin
fun Context.getAppInfo(apkPath: String): AppInfo ：根据安装包获取应用信息
fun Context.getAppInfos(apkFolderPath:String):List<AppInfo>
```

### [CommonExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/CommonExt.kt)

```kotlin
fun Context.dp2px() : dp 转 px
fun Context.px2dp() ：px 转 dp
fun View.dp2px()    ：dp 转 px
fun View.px2dp()    ：px 转 dp
```

### [HashExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/HashExt.kt)

```kotlin
fun ByteArray.hash()
fun String.hash()
fun File.hash()
fun ByteArray.md5Bytes()
fun ByteArray.md5()
fun String.md5()
fun ByteArray.sha1Bytes()
fun ByteArray.sha1()
fun String.sha1()
fun ByteArray.sha224Bytes()
fun ByteArray.sha224()
fun String.sha224()
fun ByteArray.sha256Bytes()
fun ByteArray.sha256()
fun String.sha256()
fun ByteArray.sha384Bytes()
fun ByteArray.sha384()
fun String.sha384()
fun ByteArray.sha512Bytes()
fun ByteArray.sha512()
fun String.sha512()
```

### [AesExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/AesExt.kt)

```kotlin
fun ByteArray.aesEncrypt()
fun ByteArray.aesDecrypt()
fun File.aesEncrypt()
fun File.aesDecrypt()
```

### [IntentExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/IntentExt.kt)

```kotlin
fun Context.goToAppInfoPage()      : 跳转到应用信息页面
fun Context.goToDateAndTimePage()  : 跳转到日期和时间设置页面
fun Context.goToLanguagePage()     : 跳转到语言设置页面   
fun Context.installApk()           : 安装 apk
fun Context.openBrowser(url:String)：打开浏览器跳转到指定网页
```

### [ToastExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/ToastExt.kt)

```kotlin
fun Context.toast()
fun Context.longToast()
fun Any.toast()
fun Any.longToast()
```

### [TransformExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/TransformExt.kt)

```kotlin
fun ByteArray.toHexString() : 字节数组转十六进制字符串
```
