package com.jirawatpoo.oxforddictpicture.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.base.BaseFragment
import com.jirawatpoo.oxforddictpicture.router.Router
import com.jirawatpoo.oxforddictpicture.util.setSupportActionbar
import kotlinx.android.synthetic.main.fragment_detail_dict.*

class DetailDictFragment : BaseFragment() {

    override val contentView: Int = R.layout.fragment_detail_dict

    companion object {
        fun newTnstance(query:String):DetailDictFragment {
            val fragment = DetailDictFragment()
            val bundle = Bundle()
            bundle.putString(Router.DETAIL_ACTIVITY_QUERY,query)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setSupportActionbar(toolbar)
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as? AppCompatActivity)?.supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

}
