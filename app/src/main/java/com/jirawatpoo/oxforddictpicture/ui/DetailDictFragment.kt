package com.jirawatpoo.oxforddictpicture.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.base.BaseFragment
import com.jirawatpoo.oxforddictpicture.main.ViewModelFactory
import com.jirawatpoo.oxforddictpicture.main.viewmodel.DetailDictViewModel
import com.jirawatpoo.oxforddictpicture.router.Router
import com.jirawatpoo.oxforddictpicture.util.observe
import com.jirawatpoo.oxforddictpicture.util.setSupportActionbar
import kotlinx.android.synthetic.main.fragment_detail_dict.*
import javax.inject.Inject

class DetailDictFragment : BaseFragment(), View.OnClickListener {


    @Inject lateinit var viewmodelFactory:ViewModelFactory
    lateinit var detailViewModel:DetailDictViewModel

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
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewmodel()
        setUpListner()
    }

    private fun setUpListner() {
        toolbar.setNavigationOnClickListener(this)
        observe(detailViewModel.detailData){
            Log.d("dkoakodksao",it.toString())
        }

    }

    private fun setUpViewmodel() {
        detailViewModel = ViewModelProviders.of(this,viewmodelFactory)
                .get(DetailDictViewModel::class.java)
        detailViewModel.executeData(arguments?.getString(Router.DETAIL_ACTIVITY_QUERY) ?: "")
    }


    override fun onClick(p0: View?) {
        activity?.onBackPressed()
    }

}
