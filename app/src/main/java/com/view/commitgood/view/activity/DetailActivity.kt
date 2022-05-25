package com.view.commitgood.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.view.commitgood.R
import com.view.commitgood.controller.Utils.*
import com.view.commitgood.model.CheckInResponse
import com.view.commitgood.model.DetailResponse
import com.view.commitgood.viewmodel.CheckInViewModel
import com.view.commitgood.viewmodel.CheckOutViewModel
import com.view.commitgood.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity(), View.OnClickListener{
    private  var viewModel: DetailViewModel?=null
    private  var viewModelCheckIn: CheckInViewModel?=null
    private  var viewModelCheckOut: CheckOutViewModel?=null
    var mUser_id:String?=null
    var mCompaing_id:String?=null
    var mName:String?=null
    var mDescription:String?=null
    var mWorkflow:String?=null
    var mExpDate:String?=null
    var mTimeLength:String?=null
    var mGoal_amount:String?=null
    var mGood_amount:Double?=null
    var mImage:String?=null
    var mCheckIn:String?=null
    var time :String?=null
    var gps: Gps? = null
    var current_lat:Double?=null
    var current_long:Double?=null
    var data :String?=null
    var reason :String?=null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
    }

    private fun initView()    {

        ll_back3.setOnClickListener(this)
        tv_check_in.setOnClickListener(this)
        mUser_id = AppPreferences.init(App.getAppContext()).getString(Constants.USER_ID)
        mCompaing_id=intent.getStringExtra("compaingid")

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModelCheckIn = ViewModelProviders.of(this).get(CheckInViewModel::class.java)
        viewModelCheckOut = ViewModelProviders.of(this).get(CheckOutViewModel::class.java)

        getDetails()


    }

    //.................................get details of providers..........................

    private fun getDetails()
    {
        clLoader_details.visibility = View.VISIBLE
        viewModel?.getDetails(mUser_id.toString(),mCompaing_id)?.observe(
            this,
            object : Observer<DetailResponse>
            {
                override fun onChanged(@Nullable detailResponse: DetailResponse?)
                {
                    clLoader_details.visibility = View.GONE
                    try
                    {
                        mCompaing_id=detailResponse?.data?.id.toString()
                        if(mCompaing_id.isNullOrEmpty())
                        {

                        }
                        else
                        {
                            mName=detailResponse?.data?.name.toString()
                            mDescription=detailResponse?.data?.description.toString()
                            mExpDate=detailResponse?.data?.expirationDate
                            Log.e("date",mExpDate+"")
                            mWorkflow=detailResponse?.data?.workflowState.toString()
                            mTimeLength=detailResponse?.data?.timeLength.toString()
                            mGoal_amount=detailResponse?.data?.goodGoalAmount.toString()
                            mGood_amount=detailResponse?.data?.totalGoodAmount
                            mImage=detailResponse?.data?.image
                            mCheckIn= detailResponse?.data?.checkIn.toString()

                            setData()

                        }
                    }
                    catch (e: Exception) {
                        Log.e("exception",e.message+"")
                        e.printStackTrace()
                    }




                }
            })

    }

    //.......................get current locations.......................................

    private fun getLocations() {
        gps = Gps(this)

        if (gps!!.canGetLocation()) {
            current_lat = gps!!.getLatitude()
            current_long = gps!!.getLongitude()
            Log.e("current_lat", current_lat.toString() + "")
            Log.e("current_long", current_long.toString() + "")
        } else {
            gps!!.showSettingsAlert()
        }

    }
//..................................data set in views......................................

    private fun setData()
    {
        tv_name.text=mName
        tv_description.text=mDescription
        tv_exp_date.text=mExpDate
        tv_work_flow.text=mWorkflow
        tv_time_length.text=mTimeLength
        tv_goal_amount.text=mGoal_amount
        tv_good_amount.text=mGood_amount.toString()
        if(mImage !==null)
        {
            this?.let {
                Glide.with(it)
                    .load(mImage)
                    .into(img)
            }
        }
        if(mCheckIn.equals("false"))
        {
            tv_check_in.text="CHECK IN"
        }
        else
        {
            tv_check_in.text="CHECK OUT"
        }
    }

    //.....................................clicks..................................

    override fun onClick(v: View?)
    {
        when(v?.id){

            R.id.ll_back3 -> {

               onBackPressed()
            }

            R.id.tv_check_in ->
            {
                getLocations()
                val date = getCurrentDateTime()
                time = date.toString("yyyy-MM-dd HH:mm:ss")
                Log.e("time", time + "")
                if (mCheckIn.equals("false"))
                {
                    checkInRequest()
                } else
                {
                    checkoutRequest()
                }

            }

        }
    }


    fun getCurrentDateTime(): Date
    {
        return Calendar.getInstance().time
    }

    fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

//..........................................check in....................................
    private fun checkInRequest()
    {
        clLoader_details.visibility = View.VISIBLE
        viewModelCheckIn?.getCheckIn(mUser_id,mCompaing_id,current_lat.toString(),current_long.toString(),time)?.observe(
            this,
            object : Observer<CheckInResponse>
            {

                override fun onChanged(@Nullable checkInResponse: CheckInResponse?) {
                    clLoader_details.visibility = View.GONE
                    Log.e("mes",checkInResponse?.data+"")
                    data=checkInResponse?.data
                    if(data.equals("valid"))
                    {
                        showSnackBar(checkInResponse?.reason)
                        initView()
                    }
                    else
                    {
                        showSnackBar(checkInResponse?.reason)
                    }

                }
            })

    }

    //.....................................check out...............................

    private fun checkoutRequest()
    {
        viewModelCheckOut?.getCheckout(mUser_id,mCompaing_id,current_lat.toString(),current_long.toString(),time)?.observe(
            this,
            object : Observer<CheckInResponse>
            {
                override fun onChanged(@Nullable checkInResponse: CheckInResponse?) {
                    Log.e("mes",checkInResponse?.data+"")
                    data=checkInResponse?.data
                    if(data.equals("valid"))
                    {
                        showSnackBar(checkInResponse?.reason)
                        initView()
                    }
                    else
                    {
                        showSnackBar(checkInResponse?.reason)
                    }

                }
            })
    }

    private fun showSnackBar(message: String?) {
        SnackbarUtil.showWarningShortSnackbar(this,message)
    }

    override fun onBackPressed()
    {
        super.onBackPressed()
        finish()
    }
}