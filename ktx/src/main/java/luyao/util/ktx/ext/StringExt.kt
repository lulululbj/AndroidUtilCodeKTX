package luyao.util.ktx.ext

/**
 * Created by luyao
 * on 2019/7/23 9:25
 */

fun <T> String?.notNull(f: () -> T, t: () -> T): T {
    return if (this != null) f() else t()
}