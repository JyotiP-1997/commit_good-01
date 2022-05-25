package com.view.commitgood.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.view.commitgood.controller.Services.APIRepository

import com.view.commitgood.model.DataItems
import com.view.commitgood.model.HomeResponse

class HomeViewModel :AndroidViewModel {
    private lateinit var context: Context

    constructor(application: Application) : super(application) {
        this.context = application
    }
    fun getHome(userid: String): LiveData<List<DataItems>> {
            var mutableLiveData: MutableLiveData<List<DataItems>> = MutableLiveData()
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
                    return APIRepository.getHome(userid)
                }
            }
            return mutableLiveData
        }
    }