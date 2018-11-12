package com.jirawatpoo.oxforddictpicture.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity:AppCompatActivity(),ViewContent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(contentView)
        viewAlreadyPresent()
    }

    abstract fun viewAlreadyPresent()
}