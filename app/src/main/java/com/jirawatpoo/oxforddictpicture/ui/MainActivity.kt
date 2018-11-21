package com.jirawatpoo.oxforddictpicture.ui

import android.os.Bundle
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.base.BaseActivity
import com.jirawatpoo.oxforddictpicture.util.show

class MainActivity(override val contentView: Int = R.layout.activity_main) : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState == null){
            supportFragmentManager.show {
                replace(R.id.main_container,MainFragment.newInstance())
            }
        }
    }

    override fun viewAlreadyPresent() {
    }
}
