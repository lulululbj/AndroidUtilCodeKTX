package luyao.util.ktx.ext.permission

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/**
 * Created by luyao
 * on 2019/6/18 15:47
 */

fun Activity.request(vararg permissions: String) {

    val needRequestPermissions = permissions.filter { !isGranted(it) && !isRevoked(it) }

    if (needRequestPermissions.isEmpty()) {
        // onGranted
    } else {
        val shouldShowRationalePermissions = mutableListOf<String>()
        val shouldNotShowRationalePermissions = mutableListOf<String>()
        for (permission in needRequestPermissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission))
                shouldShowRationalePermissions.add(permission)
            else
                shouldNotShowRationalePermissions.add(permission)
        }

        if (shouldShowRationalePermissions.isNotEmpty()){
            // shouldShowRequestPermissionRationale
        }

        if (shouldNotShowRationalePermissions.isNotEmpty()){
            // request permission
        }
    }
}


fun Activity.isGranted(permission: String): Boolean {
    return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
            ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}

fun Activity.isRevoked(permission: String): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
            packageManager.isPermissionRevokedByPolicy(permission, packageName)

}