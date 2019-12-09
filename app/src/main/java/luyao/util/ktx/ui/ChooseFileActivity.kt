package luyao.util.ktx.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_choose_file.*
import luyao.ktx.R
import luyao.util.ktx.base.BaseActivity
import luyao.util.ktx.ext.startFileChooser
import luyao.util.ktx.ext.toRealFile

/**
 * Created by luyao
 * on 2019/12/9 15:00
 */
class ChooseFileActivity : BaseActivity() {

    private var allowMultiple = false
    override fun getLayoutResId() = R.layout.activity_choose_file

    override fun initView() {
        singleChoose.setOnClickListener { chooseFile(1001, false) }
        multipleChoose.setOnClickListener { chooseFile(1001, true) }
    }

    private fun chooseFile(requestCode: Int, multiple: Boolean) {
        allowMultiple = multiple
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED
        ) {
            startFileChooser(requestCode, allowMultiple)
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                1002
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startFileChooser(1001, allowMultiple)
        }
    }

    override fun initData() {
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ((requestCode == 1001) && (resultCode == Activity.RESULT_OK)) {

            data?.data?.let { // single
                uriResult.text = it.toRealFile()?.path ?: ""
            }

            data?.clipData?.let {
                // multiple
                val builder = StringBuilder()
                for (i in 0 until it.itemCount) {
                    it.getItemAt(i).uri.let { uri ->
                        builder.append("${uri.toRealFile()?.path}\n\n")
                    }
                }
                uriResult.text = builder.toString()
            }
        }
    }
}