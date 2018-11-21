package com.jirawatpoo.oxforddictpicture.ui

import android.os.Bundle
import android.util.Log
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.base.BaseActivity
import com.jirawatpoo.oxforddictpicture.router.Router
import com.jirawatpoo.oxforddictpicture.util.show

class DetailDictActivity(override val contentView: Int = R.layout.activity_detail_dict) : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data = intent?.extras?.getString(Router.DETAIL_ACTIVITY_QUERY) ?: ""
        savedInstanceState ?: run {
            supportFragmentManager.show {
                replace(R.id.detail_container,DetailDictFragment.newTnstance(data))
            }
        }
    }

    override fun viewAlreadyPresent() {

    }
}
