package com.noober.ktextensions.extensions

import com.noober.ktextensions.MyApplication

/**
 * int px转dp
 */
fun Int.toDp(): Int{
    val scale = MyApplication.context.resources.displayMetrics.density
    return (this * scale + 0.5f).toInt()
}

/**
 * float px转dp
 */
fun Float.toDp(): Float{
    val scale = MyApplication.context.resources.displayMetrics.density
    return this * scale + 0.5f
}


/**
 * builder模式，便于动态使用一些属性
 */
inline fun <T> T.checkExpression(expression: Boolean, function: T.() -> T): T {
    if (expression) {
        function.invoke(this)
    }
    return this
}

/**
 * 对iterable每一个item进行操作
 */
inline fun <T> Iterable<T>.forEachItemOperate(transform: (T) -> Unit): List<T> {
    this.forEach {
        transform(it)
    }
    return this.toList()
}

/**
 * 相当于if（xxx）do
 */
inline fun Boolean.doIf(predicate: () -> Unit){
    if(this){
        predicate()
    }
}

/**
 * 相当于if（!xxx）do
 */
inline fun Boolean.doNotIf(predicate: () -> Unit){
    if(!this){
        predicate()
    }
}

/**
 * List<T>转Map<K,T>，获取对数据
 */
inline fun <K,T> Iterable<T>.toMap(transform: (T) -> K): MutableMap<K, T>{
    val map = mutableMapOf<K, T>()
    forEach {
        map[transform.invoke(it)] = it
    }
    return map
}


/**
 * List<T>转List<R>
 */
inline fun <T, R> Iterable<T>.convert(transform: (T) -> R): Iterable<R>{
    val list = mutableListOf<R>()
    forEach {
        list.add(transform.invoke(it))
    }
    return list
}