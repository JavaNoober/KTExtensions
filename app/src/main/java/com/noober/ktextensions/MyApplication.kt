package com.noober.ktextensions

import android.app.Application
import android.content.Context

class MyApplication : Application(){

    companion object{
        lateinit var context: Context
    }



    override fun onCreate() {
        super.onCreate()
        context = this
    }
}