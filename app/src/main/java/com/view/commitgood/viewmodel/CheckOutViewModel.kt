package com.view.commitgood.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.view.commitgood.controller.Services.APIRepository
import com.view.commitgood.model.CheckInResponse
import com.view.commitgood.model.LoginResponse
import org.json.JSONObject

class CheckOutViewModel :AndroidViewModel {
    private lateinit var context: Context

    constructor(application: Application) : super(application) {
        this.context = application
    }
    fun getCheckout(
        mUser_id: String?,
        mCompaing_id: String?,
        lat: String?,
        long: String?,
        time: String?
    ): LiveData<CheckInResponse> {
        var mutableLiveData: MutableLiveData<CheckInResponse> = MutableLiveData()
        when {

            else -> {
                val requestObject = JSONObject()
                requestObject.put("campaign_id", mCompaing_id)
                requestObject.put("user_id", mUser_id)
                requestObject.put("lat", 23.0216238)
                requestObject.put("lng", 72.5797068)
                requestObject.put("time", time)
                return APIRepository.checkOut(requestObject)
            }
        }
        return mutableLiveData
    }
}