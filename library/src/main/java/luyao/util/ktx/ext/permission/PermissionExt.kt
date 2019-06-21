package luyao.util.ktx.ext.permission

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.jeremyliao.liveeventbus.LiveEventBus

/**
 * Created by luyao
 * on 2019/6/18 15:47
 */

fun FragmentActivity.request(vararg permissions: String, callbacks: PermissionsCallbackDSL.() -> Unit) {

    val permissionsCallback = PermissionsCallbackDSL().apply { callbacks() }

    val needRequestPermissions = permissions.filter { !isGranted(it) }

    if (needRequestPermissions.isEmpty()) {
        // onGranted
        permissionsCallback.onGranted()
    } else {
        val shouldShowRationalePermissions = mutableListOf<String>()
        val shouldNotShowRationalePermissions = mutableListOf<String>()
        for (permission in needRequestPermissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission))
                shouldShowRationalePermissions.add(permission)
            else
                shouldNotShowRationalePermissions.add(permission)
        }

        if (shouldShowRationalePermissions.isNotEmpty()) {
            // shouldShowRequestPermissionRationale
            permissionsCallback.onShowRationale(shouldShowRationalePermissions)
        }
        val requestCode = PermissionsMap.put(permissionsCallback)

        if (shouldNotShowRationalePermissions.isNotEmpty()) {
            val ktxPermissionFragment = KtxPermissionFragment()
            supportFragmentManager.beginTransaction().add(ktxPermissionFragment,"ktx").commitNow()
            ktxPermissionFragment.requestPermissionsByFragment(shouldNotShowRationalePermissions.toTypedArray(),requestCode)
        }
    }
}

private fun startObserve(permissionsCallback: PermissionsCallbackDSL){

}


fun Activity.isGranted(permission: String): Boolean {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
            ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}

fun Activity.isRevoked(permission: String): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
            packageManager.isPermissionRevokedByPolicy(permission, packageName) // 设备规范禁止该权限,比如 dpm

}