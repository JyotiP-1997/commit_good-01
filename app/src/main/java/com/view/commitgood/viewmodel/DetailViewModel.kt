package com.view.commitgood.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.view.commitgood.controller.Services.APIRepository
import com.view.commitgood.model.*

class DetailViewModel :AndroidViewModel {
    private lateinit var context: Context

    constructor(application: Application) : super(application) {
        this.context = application
    }
    fun getDetails(userid: String, mCompaing_id: String?): LiveData<DetailResponse> {
        var mutableLiveData: MutableLiveData<DetailResponse> = MutableLiveData()
        when {
//            username.isEmpty() -> {
//          //      mutableLiveData.value =
//                  //  APIResponse<String>().error(Exception(context.getString(R.string.error_empty_user_id)))
//            }
//            password.isEmpty() -> {
////                mutableLiveData.value =
////                    APIResponse<String>().error(Exception(context.getString(R.string.error_empty_password)))
//            }
            else -> {
                return APIRepository.getDetails(userid,mCompaing_id)
            }
        }
        return mutableLiveData
    }
}