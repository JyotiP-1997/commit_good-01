package com.view.commitgood.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.view.commitgood.R
import com.view.commitgood.controller.Utils.App
import com.view.commitgood.controller.Utils.AppPreferences
import com.view.commitgood.controller.Utils.Constants
import com.view.commitgood.model.EscrowResponse
import com.view.commitgood.viewmodel.EscrowViewModel
import com.view.commitgood.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_good_esc.*

class Good_Esc_Activity : AppCompatActivity(), View.OnClickListener{
    private  var viewModel: EscrowViewModel?=null
    var mUser_id:String?=null
    var mToken:String?=null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_good_esc)
        initView()

    }

    private fun initView()
    {
        mUser_id = AppPreferences.init(App.getAppContext()).getString(Constants.USER_ID)
        viewModel = ViewModelProviders.of(this).get(EscrowViewModel::class.java)
        ll_back.setOnClickListener(this)
        getEscrow()
    }

    private fun getEscrow()   {

        viewModel?.getEscrow(mUser_id.toString())?.observe(
            this,
            object : Observer<EscrowResponse>
            {
                override fun onChanged(@Nullable escrowResponse: EscrowResponse?)
                {
                    mToken=escrowResponse?.walletBalance?.tokens.toString()
                    tv_token.text=mToken+" TOKEN"
                }
            })
    }

    override fun onClick(v: View?)
    {
        when(v?.id){

            R.id.ll_back -> {

                onBackPressed()
            }
        }

    }

    override fun onBackPressed()
    {
        super.onBackPressed()
        this.finish()
    }
}