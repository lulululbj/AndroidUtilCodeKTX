package luyao.util.ktx.ext

import android.content.Context
import android.content.pm.PackageManager
import luyao.util.ktx.bean.AppInfo
import java.io.File

/**
 * Created by luyao
 * on 2019/6/12 10:53
 */

fun Context.getVersionName(): String = packageManager.getPackageInfo(packageName, 0).versionName

fun Context.getAppInfo(apkPath: String): AppInfo {
    val packageInfo = packageManager.getPackageInfo(apkPath,PackageManager.GET_META_DATA)
    packageInfo.applicationInfo.sourceDir=apkPath
    packageInfo.applicationInfo.publicSourceDir=apkPath

    val packageName = packageInfo.packageName
    val appName =packageManager.getApplicationLabel(packageInfo.applicationInfo).toString()
    val versionName = packageInfo.versionName
    val versionCode = packageInfo.longVersionCode
    val icon = packageManager.getApplicationIcon(packageInfo.applicationInfo)
    return AppInfo(apkPath,packageName,versionName,versionCode,appName,icon)
}

fun Context.getAppInfos(apkFolderPath:String):List<AppInfo>{
    val appInfoList = ArrayList<AppInfo>()
    for (file in File(apkFolderPath).listFiles())
        appInfoList.add(getAppInfo(file.path))
    return appInfoList
}

