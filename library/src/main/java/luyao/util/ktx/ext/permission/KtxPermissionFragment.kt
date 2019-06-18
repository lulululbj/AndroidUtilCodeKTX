package luyao.util.ktx.ext.permission

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Created by luyao
 * on 2019/6/18 16:27
 */
class KtxPermissionFragment : Fragment() {

    private val PERMISSION_REQUEST_CODE = 0XFF

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    fun requestPermissions(permissions: Array<String>) {
        requestPermissions(permissions, PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {

        }
    }
}