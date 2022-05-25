package com.view.commitgood.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.view.commitgood.controller.Services.APIRepository
import com.view.commitgood.model.CheckInResponse
import org.json.JSONObject

class CheckInViewModel :AndroidViewModel {
    private lateinit var context: Context

    constructor(application: Application) : super(application) {
        this.context = application
    }
    fun  getCheckIn(
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
                requestObject.put("lat", lat)
                requestObject.put("lng", long)
                requestObject.put("time", time)
                return APIRepository.checkin(requestObject)
            }
        }
        return mutableLiveData
    }
}