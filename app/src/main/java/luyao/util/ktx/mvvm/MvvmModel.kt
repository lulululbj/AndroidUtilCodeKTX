package luyao.util.ktx.mvvm

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import luyao.util.ktx.base.BaseViewModel

/**
 * Created by luyao
 * on 2019/5/31 16:28
 */
class MvvmModel : BaseViewModel() {

    val mMessage: MutableLiveData<String> = MutableLiveData()

    fun getMessage() {

        launch {
            val deferred = async(Dispatchers.IO) {
                delay(2000) // network request
                "success"
            }
            mMessage.value = deferred.await()
        }
    }
}