package com.jirawatpoo.oxforddictpicture.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.jirawatpoo.oxforddictpicture.R
import com.jirawatpoo.oxforddictpicture.adapter.DetailDataAdapter
import com.jirawatpoo.oxforddictpicture.adapter.DetailImageAdapter
import com.jirawatpoo.oxforddictpicture.base.BaseFragment
import com.jirawatpoo.oxforddictpicture.main.ViewModelFactory
import com.jirawatpoo.oxforddictpicture.main.state.NetworkState
import com.jirawatpoo.oxforddictpicture.main.viewmodel.DetailDictViewModel
import com.jirawatpoo.oxforddictpicture.router.Router
import com.jirawatpoo.oxforddictpicture.util.observe
import com.jirawatpoo.oxforddictpicture.util.setSupportActionbar
import com.tmall.ultraviewpager.UltraViewPager
import com.tmall.ultraviewpager.transformer.UltraDepthScaleTransformer
import com.tmall.ultraviewpager.transformer.UltraScaleTransformer
import kotlinx.android.synthetic.main.fragment_detail_dict.*
import javax.inject.Inject

class DetailDictFragment : BaseFragment() {


    @Inject lateinit var viewmodelFactory:ViewModelFactory
    @Inject lateinit var detailDataAdapter:DetailDataAdapter
    lateinit var detailViewModel:DetailDictViewModel
    lateinit var detailImageAdapter:DetailImageAdapter

    override val contentView: Int = R.layout.fragment_detail_dict


    companion object {
        fun newInstance(query:String):DetailDictFragment {
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
        setUpView()
    }

    private fun setUpView() {
        textDisplayloading.text = arguments?.getString(Router.DETAIL_ACTIVITY_QUERY) ?: ""
        rc_photo.apply {
            setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL)
            setPageTransformer(false, UltraScaleTransformer())
            setMultiScreen(0.8f)
            setInfiniteLoop(true)
        }
        rc_detail.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = detailDataAdapter
        }
    }

    private fun setUpListner() {
        observe(detailViewModel.detailData){
            title_detail.title = arguments?.getString(Router.DETAIL_ACTIVITY_QUERY) ?: ""
            detailDataAdapter.updateList(it.listDetailData)
        }
        observe(detailViewModel.imageData){
            detailImageAdapter = DetailImageAdapter(it.media)
            rc_photo.adapter = detailImageAdapter
        }
        observe(detailViewModel.stateLoad){
            list_state_detail.displayedChild = it.value
            tv_detail_error.text = it.error
        }

    }

    private fun setUpViewmodel() {
        detailViewModel = ViewModelProviders.of(this,viewmodelFactory)
                .get(DetailDictViewModel::class.java)
        detailViewModel.executeData(arguments?.getString(Router.DETAIL_ACTIVITY_QUERY) ?: "")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == android.R.id.home){
            activity?.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}
