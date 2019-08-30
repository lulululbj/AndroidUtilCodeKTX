
**AndroidUtilCodeKTX ! 专注提升 Android 开发效率 ！**

该类库利用 Kotlin 语言特性合理封装了 Android 开发中的常用操作，同时也收集了开发过程中的常用工具类。
旨在做同样的事情，写最少的代码，提升开发效率。

[**Change log**](/CHANGELOG.md)

## Use

```
implementation 'luyao.util.ktx:AndroidUtilKTX:0.0.5'
```

> 最新版本将第一时间用在我的另外两个开源项目，[wanandroid](https://github.com/lulululbj/wanandroid) 和 [Box](https://github.com/lulululbj/Box)，欢迎关注 ！


## APIS (keep updating...)

***

### [权限相关](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/permission/PermissionExt.kt)  [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/app/src/main/java/luyao/util/ktx/ui/PermissionExtActivity.kt)

```kotlin
FragmentActivity.request(vararg permissions: String, callbacks: PermissionsCallbackDSL.() -> Unit)
```

### [ActivityExt](/ktx/src/main/java/luyao/util/ktx/ext/ActivityExt.kt) [[Demo]](/app/src/main/java/luyao/util/ktx/ui/ActivityExtActivity.kt)

```kotlin
Activity.startKtxActivity(
    flags: Int? = null,
    extra: Bundle? = null,
    value: Pair<String, Any>? = null,
    values: Collection<Pair<String, Any>?>? = null
) 

fun <reified T : Activity> Activity.startKtxActivityForResult(
    requestCode: Int,
    flags: Int? = null,
    extra: Bundle? = null,
    value: Pair<String, Any>? = null,
    values: Collection<Pair<String, Any>?>? = null
) 

Fragment.startKtxActivity()
Fragment.startKtxActivityForResult()
Context.startKtxActivity
Activity.hideKeyboard()
Activity.showKeyboard(et: EditText)
Activity.hideKeyboard(view: View)
```

### [AppExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/AppExt.kt)

```kotlin
Context.versionName: String
Context.versionCode: Long
Context.getAppInfo(apkPath: String): AppInfo
Context.getAppInfos(apkFolderPath: String): List<AppInfo>
Context.getAppSignature(packageName: String = this.packageName): ByteArray?
Context.isPackageInstalled(pkgName: String)
```

### [AesExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/AesExt.kt)  [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/test/java/luyao/util/ktx/ext/AesExtKtTest.kt)

```kotlin
ByteArray.aesEncrypt(key: ByteArray, iv: ByteArray, cipherAlgotirhm: String = AES_CFB_NOPADDING): ByteArray
ByteArray.aesDecrypt(key: ByteArray, iv: ByteArray, cipherAlgotirhm: String = AES_CFB_NOPADDING): ByteArray 
File.aesEncrypt(key: ByteArray, iv: ByteArray, destFilePath: String): File?, cipherAlgotirhm: String = AES_CFB_NOPADDING)
File.aesDecrypt(key: ByteArray, iv: ByteArray, destFilePath: String): File?, cipherAlgotirhm: String = AES_CFB_NOPADDING)
initAESKey(size: Int): ByteArray
initCipher(mode: Int, key: ByteArray, iv: ByteArray, cipherAlgotirhm: String): Cipher
```

### [CommonExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/CommonExt.kt)

```kotlin
fromM()
beforeM()
fromN()
beforeN()
fromO()
beforeO()
fromP()
beforeP()
fromSpecificVersion(version: Int)
beforeSpecificVersion(version: Int)
Context.dp2px(dp: Int)
Context.px2dp(px: Int)
View.dp2px(dp: Int)
View.px2dp(px: Int)
Context.screenWidth
Context.screenHeight
Context.copyToClipboard(label: String, text: String)
Context.checkAccessbilityServiceEnabled(serviceName: String)
Any?.notNull(f: () -> T, t: () -> T): T
Context.isRTLLayout
```

### [Constants](/ktx/src/main/java/luyao/util/ktx/core/Constants.kt)

```kotlin
fun isOnMainThread()
```

### [DrawableExt](/ktx/src/main/java/luyao/util/ktx/ext/DrawableExt.kt)

```kotlin
Drawable.convertToBitmap()
```

### [FileExt](/ktx/src/main/java/luyao/util/ktx/ext/FileExt.kt)

```kotlin
File.canListFiles
File.totalSize
File.formatSize
File.mimeType
File.listFiles(isRecursive: Boolean = false, filter: ((file: File) -> Boolean)? = null)
File.writeText(append: Boolean = false, text: String, charset: Charset = Charsets.UTF_8)
File.writeBytes(append: Boolean = false, bytes: ByteArray)
File.moveTo(destFile: File, overwrite: Boolean = true, reserve: Boolean = true)
File.moveToWithProgress(
    destFolder: File,
    overwrite: Boolean = true,
    reserve: Boolean = true,
    func: ((file: File, i: Int) -> Unit)? = null)
File.rename(newName: String)
File.rename(newFile: File)
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
Context.sendEmail(email: String, subject: String?, text: String?) 
```

### [KtxManager](/ktx/src/main/java/luyao/util/ktx/core/lifecycle/KtxHandler.kt) [[Demo]](/app/src/main/java/luyao/util/ktx/ui/LifeCycleActivity.kt)

```kotlin
pushActivity(activity: Activity)
popActivity(activity: Activity)
finishCurrentActivity()
finishActivity(activity: Activity)
 finishActivity(clazz: Class<*>)
finishAllActivity()
```

### [KtxSpan](/ktx/src/main/java/luyao/util/ktx/core/span/KtxSpan.kt) [[Demo]](/app/src/main/java/luyao/util/ktx/ui/KtxSpanActivity.kt)

```kotlin
text(
    text: CharSequence,
    isNewLine: Boolean = true,
    textSize: Int = -1,
    fontFamily: String = "",
    customTypeFace: Typeface? = null,
    isDp: Boolean = true,
    fontProportion: Float = -1f,
    xFontProportion: Float = -1f,
    lineHeight: Int = -1,
    foregroundColor: Int = -1,
    backgroundColor: Int = -1,
    alignment: Layout.Alignment? = null,
    isBold: Boolean = false,
    isStrikethrough: Boolean = false,
    isUnderline: Boolean = false,
    isItalic: Boolean = false,
    isBoldAndItalic: Boolean = false,
    isSuperscript: Boolean = false,
    isSubscript: Boolean = false,
    first: Int = 0,
    rest: Int = 0,
    quoteColor: Int = -1,
    quoteStripeWidth: Int = STANDARD_STRIPE_WIDTH_PX,
    quoteGapWidth: Int = STANDARD_GAP_WIDTH_PX,
    bulletColor: Int = -1,
    bulletRadius: Int = STANDARD_BULLET_RADIUS,
    bulletGapWidth: Int = STANDARD_GAP_WIDTH_PX,
    clickSpan: ClickableSpan? = null,
    url: String? = null,
    blurRadius: Float = -1f,
    blurStyle: BlurMaskFilter.Blur = BlurMaskFilter.Blur.NORMAL
): KtxSpan 
    
image(
    resId: Int,
    verticalAlignment: Int = KtxImageSpan.ALIGN_MIDDLE,
    marginLeft: Int = 0,
    marginRight: Int = 0,
    offsetY: Int = 0,
    fontWidthMultiple: Float = -1f
) 

blockLine(@Px height: Int, addBlockAlways: Boolean = false)
```

### [Listener](/ktx/src/main/java/luyao/util/ktx/ext/listener) [[Demo]](/app/src/main/java/luyao/util/ktx/ui/ListenerExtActivity.kt)

```kotlin
SearchView.queryTextListener(listener: KtxQueryTextLister.() -> Unit)
SeekBar.onProgressBarChanged(callback: (Int, Boolean) -> Unit)
TextView.textWatcher(watcher: KtxTextWatcher.() -> Unit)
ViewPager.onPageSelected(pageChangedAction: (newPosition: Int) -> Unit)
```

### [LogExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/LogExt.kt)

```kotlin
String.logv(tag: String = TAG)
String.logd(tag: String = TAG)
String.logi(tag: String = TAG)
String.logw(tag: String = TAG)
String.loge(tag: String = TAG)
```

### [SharedPreferencesExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/sharedpreferences/SharedPreferencesExt.kt) [[Demo]](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/app/src/main/java/luyao/util/ktx/ui/SharedPreferencesActivity.kt)

```kotlin
<T> Context.putSpValue(key: String, value: T, name: String = packageName)
<T> Activity.putSpValue(key: String, value: T, name: String = packageName)
<T> Context.getSpValue(key: String, default: T, name: String = packageName ): T
<T> Activity.getSpValue(key: String, default: T, name: String = packageName): T
```

### [StringExt](/ktx/src/main/java/luyao/util/ktx/ext/StringExt.kt)

```kotlin
String.areDigitsOnly()
```

### [SystemServiceExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/SystemServiceExt.kt)

```kotlin
Context.windowManager
Context.clipboardManager
Context.layoutInflater
Context.activityManager
Context.powerManager
Context.alarmManager
Context.notificationManager
Context.keyguardManager
Context.locationManager
Context.searchManager
Context.storageManager
Context.vibrator
Context.connectivityManager
Context.wifiManager
Context.audioManager
Context.mediaRouter
Context.telephonyManager
Context.sensorManager
Context.subscriptionManager
Context.carrierConfigManager
Context.inputMethodManager
Context.uiModeManager
Context.downloadManager
Context.batteryManager
Context.jobScheduler
Context.accessibilityManager
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

### [TransformExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/TransformExt.kt)

```kotlin
ByteArray.toHexString() : 字节数组转十六进制字符串
```

### [ViewExt](https://github.com/lulululbj/AndroidUtilCodeKTX/blob/master/ktx/src/main/java/luyao/util/ktx/ext/ViewExt.kt)

```kotlin
View.visible()
View.invisible()
View.gone()
View.reverseVisiblity(needGone: Boolean = true)
View.changeVisible(visible: Boolean, needGone: Boolean = true)
var View.isVisible: Boolean
var View.isInvisible: Boolean
var View.isGone: Boolean
View.setPadding(@Px size: Int)
View.postDelayed(delayInMillis: Long, crossinline action: () -> Unit): Runnable
View.toBitmap(config: Bitmap.Config = Bitmap.Config.ARGB_8888): Bitmap
RecyclerView.itemPadding(padding:Int)
RecyclerView.itemPadding(top: Int, bottom: Int, left: Int = 0, right: Int = 0)
TextView.notEmpty(f: TextView.() -> Unit, t: TextView.() -> Unit)
View.onGlobalLayout(crossinline callback: () -> Unit)
fun View.afterMeasured(crossinline callback: View.() -> Unit)
```

### Others

1. [KtxHandler](/ktx/src/main/java/luyao/util/ktx/core/lifecycle/KtxHandler.kt) : 跟随组件生命周期自动处理的 Handler
2. [KtxAppLifeObserver](/ktx/src/main/java/luyao/util/ktx/core/lifecycle/KtxAppLifeObserver.kt) : 应用前后台监听
