package com.jirawatpoo.oxforddictpicture.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.base.BaseFragment
import java.lang.Exception
import java.lang.UnsupportedOperationException

class MainFragment :BaseFragment() {

    companion object {
        fun newInstance(): MainFragment = MainFragment()

    }

    override val contentView: Int = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}