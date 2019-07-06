# AndroidUtilCodeKTX

一直有关注 [Blankj](https://github.com/Blankj) 的开源项目 [AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode), 到目前为止将近有 `24k` star。在以往的开发过程中，我也经常参考其中的工具类实现。但是自从切换到 `Kotlin` 作为主力开发语言以来，仍然生搬硬套其中的工具类显得并不是那么优雅，没有很好的利用 Kotlin 的语言特性，遂决定整理 `AndroidUtilCodeKTX` 这个库，完全基于 Kotlin 实现，收集 Android 开发中常用的工具类。

该库不会是 [AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode) 的 Kotlin 翻译版本，更多的还是基于我在开发过程中的需求进行完善，由于个人精力有限，可能并不是那么完善，欢迎大家通过 [issue](https://github.com/lulululbj/AndroidUtilCodeKTX/issues) 提出自己的意见 ！

## APIS (keep updating...)

***

### [权限相关](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/permission/PermissionExt.kt)  [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/app/src/main/java/luyao/util/ktx/ui/PermissionExtActivity.kt)

```kotlin
fun FragmentActivity.request()  ：权限请求
```

### [AppExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/AppExt.kt)

```kotlin
fun Context.getVersionName()    : 获取应用版本名称
fun Context.getVersionCode()    ：获取应用版本号
fun Context.getAppSignature()   ：获取应用签名
fun Context.getAppInfo() ：根据安装包获取应用信息
fun Context.getAppInfos()
```

### [CommonExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/CommonExt.kt)

```kotlin
fun Context.dp2px()             : dp 转 px
fun Context.px2dp()             ：px 转 dp
fun View.dp2px()                ：dp 转 px
fun View.px2dp()                ：px 转 dp
fun Context.getWidth()          ：获取屏幕宽度
fun Context.getHeight()         ：获取屏幕高度
fun Context.copyToClipboard()   ：复制到粘贴板
```

### [HashExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/HashExt.kt) [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/test/java/luyao/util/ktx/ext/HashExtKtTest.kt)

```kotlin
fun ByteArray.hash()          ：获取字节数组哈希值
fun String.hash()             ：获取字符串哈希值
fun File.hash()               ：获取文件哈希值
fun ByteArray.md5Bytes()     
fun ByteArray.md5()           ：获取字节数组 md5 值
fun String.md5()              ：获取字符串 md5 值
fun ByteArray.sha1Bytes()     
fun ByteArray.sha1()          ：获取字节数组 sha1 值
fun String.sha1()             ：获取字符串 sha1 值
fun ByteArray.sha224Bytes()
fun ByteArray.sha224()        ：获取字节数组 sha224 值
fun String.sha224()           ：获取字符串 sha224 值
fun ByteArray.sha256Bytes()
fun ByteArray.sha256()        ：获取字节数组 sha256 值
fun String.sha256()           ：获取字符串 sha256 值
fun ByteArray.sha384Bytes()
fun ByteArray.sha384()        ：获取字节数组 sha384 值
fun String.sha384()           ：获取字符串 sha384 值
fun ByteArray.sha512Bytes()
fun ByteArray.sha512()        ：获取字节数组 sha512 值
fun String.sha512()           ：获取字符串 sha512 值
```

### [AesExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/AesExt.kt)  [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/test/java/luyao/util/ktx/ext/AesExtKtTest.kt)

```kotlin
fun ByteArray.aesEncrypt()  ：加密字节数组，默认 CFB
fun ByteArray.aesDecrypt()  ：解密字节数组，默认 CFB
fun File.aesEncrypt()       ：加密文件，CFB 流加密模式
fun File.aesDecrypt()       ：解密文件，CFB 流加密模式
```

### [IntentExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/IntentExt.kt)  [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/app/src/main/java/luyao/util/ktx/ui/IntentExtActivity.kt)

```kotlin
fun Context.goToAppInfoPage()           : 跳转到应用信息页面
fun Context.goToDateAndTimePage()       : 跳转到日期和时间设置页面
fun Context.goToLanguagePage()          : 跳转到语言设置页面   
fun Context.goToAccessibilitySetting()  : 跳转到无障碍服务设置页面
fun Context.openApp()                   : 打开 app
fun Context.openInAppStore()            : 在应用商店打开 app
fun Context.installApk()                : 安装 apk
fun Context.openBrowser(url:String)     ：打开浏览器跳转到指定网页
fun Context.uninstallApp()              : 卸载 app
```

### [ToastExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/ToastExt.kt) [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/app/src/main/java/luyao/util/ktx/ui/ToastExtActivity.kt)

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
