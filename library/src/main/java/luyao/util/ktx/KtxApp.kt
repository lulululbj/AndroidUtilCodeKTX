package luyao.util.ktx

import android.app.Application
import com.jeremyliao.liveeventbus.LiveEventBus

/**
 * Created by luyao
 * on 2019/6/19 10:53
 */
class KtxApp : Application() {

    override fun onCreate() {
        super.onCreate()

        LiveEventBus.get()
            .config()
            .supportBroadcast(this)
            .lifecycleObserverAlwaysActive(true)
            .autoClear(false)
    }
}