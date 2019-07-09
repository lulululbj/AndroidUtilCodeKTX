package luyao.util.ktx.ext

import android.app.*
import android.app.job.JobScheduler
import android.content.ClipboardManager
import android.content.Context
import android.hardware.SensorManager
import android.location.LocationManager
import android.media.AudioManager
import android.media.MediaRouter
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.BatteryManager
import android.os.PowerManager
import android.os.Vibrator
import android.os.storage.StorageManager
import android.telephony.CarrierConfigManager
import android.telephony.SubscriptionManager
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat

/**
 * Created by luyao
 * on 2019/7/9 9:17
 */
inline fun <reified T : Any> Context.getSystemService(): T? =
    ContextCompat.getSystemService(this, T::class.java)

fun Context.windowManager() = getSystemService<WindowManager>()
fun Context.clipboardManager()=getSystemService<ClipboardManager>()
fun Context.layoutInflater() = getSystemService<LayoutInflater>()
fun Context.activityManager() = getSystemService<ActivityManager>()
fun Context.powerManager() = getSystemService<PowerManager>()
fun Context.alarmManager() = getSystemService<AlarmManager>()
fun Context.notificationManager() = getSystemService<NotificationManager>()
fun Context.keyguardManager() = getSystemService<KeyguardManager>()
fun Context.locationManager() = getSystemService<LocationManager>()
fun Context.searchManager() = getSystemService<SearchManager>()
fun Context.storageManager() = getSystemService<StorageManager>()
fun Context.vibrator() = getSystemService<Vibrator>()
fun Context.connectivityManager() = getSystemService<ConnectivityManager>()
fun Context.wifiManager() = getSystemService<WifiManager>()
fun Context.audioManager() = getSystemService<AudioManager>()
fun Context.mediaRouter() = getSystemService<MediaRouter>()
fun Context.telephonyManager() = getSystemService<TelephonyManager>()
fun Context.sensorManager() = getSystemService<SensorManager>()
fun Context.subscriptionManager() = getSystemService<SubscriptionManager>()
fun Context.carrierConfigManager() = getSystemService<CarrierConfigManager>()
fun Context.inputMethodManager() = getSystemService<InputMethodManager>()
fun Context.uiModeManager() = getSystemService<UiModeManager>()
fun Context.downloadManager() = getSystemService<DownloadManager>()
fun Context.batteryManager() = getSystemService<BatteryManager>()
fun Context.jobScheduler() = getSystemService<JobScheduler>()

