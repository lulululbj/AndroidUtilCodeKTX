package luyao.util.ktx.ui

import android.Manifest
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.files.FileFilter
import com.afollestad.materialdialogs.files.fileChooser
import luyao.util.ktx.bean.ItemBean
import luyao.util.ktx.ext.*
import luyao.util.ktx.ext.permission.request

/**
 * Created by luyao
 * on 2019/6/18 10:48
 */
class IntentExtActivity : CommonListActivity() {

    override fun getToolbarTitle() = "IntentExt"

    override fun initList() {
        dataList.run {
            add(ItemBean("App Info", null))
            add(ItemBean("Date And Timezone", null))
            add(ItemBean("Language And Input", null))
            add(ItemBean("Install Apk", null))
            add(ItemBean("Open Browser", null))
        }
    }

    override fun handleClick(position: Int) {
        when (position) {
            0 -> goToAppInfoPage()
            1 -> goToDateAndTimePage()
            2 -> goToLanguagePage()
            3 -> installApk()
            4 -> openBrowser("https://www.baidu.com")
        }
    }


    private fun installApk() {

        request(Manifest.permission.READ_EXTERNAL_STORAGE) {
            onGranted {
                chooseFile()
            }

            onDenied {
                toast("onDenied")
            }

            onShowRationale {
                toast("onShowRationale")
            }

            onNeverAskAgain {
                toast("onNeverAskAgain")
            }
        }
    }

    private fun chooseFile() {
        val apkFilter: FileFilter = { it.name.endsWith(".apk") }
        MaterialDialog(this).show {
            fileChooser(filter = apkFilter) { _, file ->
                installApk(file)
            }
        }
    }
}
