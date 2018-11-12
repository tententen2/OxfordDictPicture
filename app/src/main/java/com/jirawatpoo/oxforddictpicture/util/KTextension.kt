package com.jirawatpoo.oxforddictpicture.util

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import java.lang.Exception
import java.lang.UnsupportedOperationException

fun FragmentManager.show(fragmentTransaction: FragmentTransaction.() -> FragmentTransaction){
    this.beginTransaction().fragmentTransaction().commit()
}