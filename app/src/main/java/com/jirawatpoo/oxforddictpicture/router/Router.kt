package com.jirawatpoo.oxforddictpicture.router

import android.content.Context
import android.content.Intent
import com.jirawatpoo.oxforddictpicture.ui.DetailDictActivity

object Router {
    const val DETAIL_ACTIVITY_QUERY = "DETAIL_ACTIVITY_QUERY"

    fun detailActivity(context: Context,param:(Intent.() -> Unit)? = null):Intent {
        val intent = Intent(context, DetailDictActivity::class.java)
        param?.let {
            intent.it()
        }
        return intent
    }
}