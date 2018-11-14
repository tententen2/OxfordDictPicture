package com.jirawatpoo.oxforddictpicture.ui

import android.view.Menu
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.base.BaseActivity
import com.jirawatpoo.oxforddictpicture.util.show
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity(override val contentView: Int = R.layout.activity_main) : BaseActivity() {

    override fun viewAlreadyPresent() {
        supportFragmentManager.show {
            replace(R.id.main_container,MainFragment.newInstance())
        }
    }
}
