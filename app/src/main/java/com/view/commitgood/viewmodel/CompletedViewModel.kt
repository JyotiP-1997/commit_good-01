package com.view.commitgood.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.view.commitgood.controller.Services.APIRepository
import com.view.commitgood.model.DataItemCom
import com.view.commitgood.model.DataItems

class CompletedViewModel: AndroidViewModel{

    private lateinit var context: Context

    constructor(application: Application) : super(application) {
        this.context = application
    }
    fun getCompleted(userid: String): LiveData<List<DataItemCom>>
    {
        var mutableLiveData: MutableLiveData<List<DataItemCom>> = MutableLiveData()
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
                return APIRepository.getCompleted(userid)
            }
        }
        return mutableLiveData
    }
}
