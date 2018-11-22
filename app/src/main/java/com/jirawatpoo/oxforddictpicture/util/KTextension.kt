package com.jirawatpoo.oxforddictpicture.util

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Context
import android.support.annotation.RawRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

fun FragmentManager.show(fragmentTransaction: FragmentTransaction.() -> FragmentTransaction){

    this.beginTransaction().fragmentTransaction().commit()
}

fun Fragment.setSupportActionbar(toolbar: Toolbar){
    (activity as? AppCompatActivity)?.setSupportActionBar(toolbar)
}



fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { action(it) } })
}
