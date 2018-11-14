package com.jirawatpoo.oxforddictpicture.util

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