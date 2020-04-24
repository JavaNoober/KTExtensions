package com.noober.ktextensions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.noober.ktextensions.extensions.*


data class SimpleModel(var int: Int)

data class SimpleModel2(var int: Int)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //int to dp
        val dp1 = 100.toDp()

        //float to dp
        val dp2 = 99.99f.toDp()

        //forEachItemOperate
        val test1List = arrayListOf(SimpleModel(1),
            SimpleModel(2), SimpleModel(3))
        test1List.forEach {
            Log.i("MainActivity", "test1List before${it.int}")
        }

        val test1AfterList = test1List.forEachItemOperate {
            it.int ++
        }

        test1AfterList.forEach {
            Log.i("MainActivity", "test1List after${it.int}")
        }

        //doIf
        (SimpleModel(1).int > 0).doIf {
            // 如果满足表达式，就进行下面操作，否则不执行
        }

        //doNotIf
        (SimpleModel(1).int > 0).doNotIf {
            // 如果不满足表达式，就进行下面操作，否则不执行
        }

        //toMap
        val test2List = arrayListOf(SimpleModel(1),
            SimpleModel(2), SimpleModel(3))
        // 转换之后的值为[1, SimpleModel(1)],[2, SimpleModel(2)],[3, SimpleModel(3)]
        val map = test2List.toMap { it.int }

        //convert 一个类型的对象集合变成另一个对象集合
        val test3List = arrayListOf(SimpleModel(1),
            SimpleModel(2), SimpleModel(3))

        val after3List = test3List.convert { SimpleModel2(it.int) }
    }
}
