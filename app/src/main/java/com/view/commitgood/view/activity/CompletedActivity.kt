package com.view.commitgood.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.view.commitgood.R
import com.view.commitgood.controller.Utils.App
import com.view.commitgood.controller.Utils.AppPreferences
import com.view.commitgood.controller.Utils.Constants
import com.view.commitgood.model.CompletedResponse
import com.view.commitgood.model.DataItemCom
import com.view.commitgood.model.DataItems
import com.view.commitgood.view.adapter.Completed_Adapter
import com.view.commitgood.view.adapter.Cureent_Adapter
import com.view.commitgood.viewmodel.CompletedViewModel
import com.view.commitgood.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_completed.*
import kotlinx.android.synthetic.main.activity_main.*

class CompletedActivity : AppCompatActivity(), View.OnClickListener{

    private var completed_List: ArrayList<DataItemCom> = ArrayList()
    var mUser_id: String? = null
    private var viewModel: CompletedViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?)    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completed)
        initView()
    }

    private fun initView()   {

        mUser_id = AppPreferences.init(App.getAppContext()).getString(Constants.USER_ID)
        Log.d("userid", mUser_id + "")

        viewModel = ViewModelProviders.of(this).get(CompletedViewModel::class.java)
        tv_back.setOnClickListener(this)
        getCompletedApi()
    }

    private fun getCompletedApi()
    {
        //  clLoader_main.visibility = View.VISIBLE
        viewModel?.getCompleted(mUser_id.toString())?.observe(
            this,
            object : Observer<List<DataItemCom>>
            {
                override fun onChanged(@Nullable completedResponse: List<DataItemCom>?)
                {
                    //     clLoader_main.visibility = View.GONE
                    completed_List = completedResponse as ArrayList<DataItemCom>
                    rv_Complete?.layoutManager = LinearLayoutManager(this@CompletedActivity,
                        LinearLayoutManager.VERTICAL, false)
                    rv_Complete?.adapter = Completed_Adapter(this@CompletedActivity, completed_List)
                    (rv_Complete?.adapter as Completed_Adapter).onItemClick = { pos, view ->

                        var mCompaingId = completed_List?.get(pos).id
                        Log.d("userid", mCompaingId.toString() + "")
//                        val intent = Intent(this@CompletedActivity, DetailActivity::class.java)
//                        intent.putExtra("compaingid", mCompaingId.toString())
//                        startActivity(intent)


                    }
                    rv_Complete?.setNestedScrollingEnabled(false)

                }
            })
    }


    override fun onClick(v: View?)    {

        when(v?.id){

            R.id.tv_back ->{
               onBackPressed()
            }
        }
        }

    override fun onBackPressed()
    {
        super.onBackPressed()
         finish()
    }

    }
