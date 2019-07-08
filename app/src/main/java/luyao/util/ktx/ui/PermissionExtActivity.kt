package luyao.util.ktx.ui

import android.Manifest
import com.afollestad.materialdialogs.MaterialDialog
import kotlinx.android.synthetic.main.activity_permission_ext.*
import kotlinx.android.synthetic.main.title_layout.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.goToAppInfoPage
import luyao.util.ktx.ext.permission.PermissionRequest
import luyao.util.ktx.ext.permission.request
import luyao.util.ktx.ext.toast

/**
 * Created by luyao
 * on 2019/6/21 14:28
 */
class PermissionExtActivity : BaseActivity() {

    override fun getLayoutResId() = R.layout.activity_permission_ext

    override fun initView() {
        mToolbar.title = "PermissionExt"
        requestCamera.setOnClickListener { requestCameraPermission() }
        requestCalendarAndAudio.setOnClickListener { requestCalendarAndAudioPermission() }
    }

    override fun initData() {
    }

    private fun requestCameraPermission() {
        request(Manifest.permission.CAMERA) {
            onGranted { toast("onGranted") }
            onDenied { toast("onDenied") }
            onShowRationale { showRationale(it) }
            onNeverAskAgain { goToAppInfoPage() }
        }
    }

    private fun showRationale(request: PermissionRequest) {
        MaterialDialog(this).show {
            title = "Request Permission"
            message(text = "We need permission to provide normal service. Do you agree ?")
            positiveButton(R.string.agree) { request.retry() }
            negativeButton(R.string.disagree)
        }
    }

    private fun requestCalendarAndAudioPermission() {
        request(Manifest.permission.READ_CALENDAR, Manifest.permission.RECORD_AUDIO) {
            onGranted { toast("onGranted") }
            onDenied { toast("onDenied") }
            onShowRationale { showRationale(it) }
            onNeverAskAgain { goToAppInfoPage() }
        }
    }

}