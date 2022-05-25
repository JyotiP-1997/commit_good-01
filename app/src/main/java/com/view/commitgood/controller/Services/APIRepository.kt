package com.view.commitgood.controller.Services

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gender.gendercomfortable.controller.repository.APIClient
import com.view.commitgood.controller.Utils.App
import com.view.commitgood.controller.Utils.AppPreferences
import com.view.commitgood.controller.Utils.Constants
import com.view.commitgood.model.*

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object APIRepository{

    private var apiInterface: APIInterface = APIClient.retrofit(Constants.BASE_URL_API)

    private var homeList: ArrayList<DataItems> = ArrayList()
    private var compl_List: ArrayList<DataItemCom> = ArrayList()



    fun login(requestObject: JSONObject): LiveData<LoginResponse>
    {
        val mutableLiveData: MutableLiveData<LoginResponse> = MutableLiveData()
        val requestBody: RequestBody =
            requestObject.toString().toRequestBody("application/json".toMediaType())
        val call = apiInterface.login(requestBody)
        call.enqueue(object : Callback<LoginResponse>
        {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val login: LoginResponse? = response.body()
                Log.e("message", login?.accessToken+"")
                if (response.isSuccessful) {
                    try {
                        val login: LoginResponse? = response.body()
                         Log.e("message", login?.loggedIn.toString()+"")
                        if (response.body()?.loggedIn == true) {



                            AppPreferences.init(App.getAppContext())
                                .putString(Constants.EMAIL, login?.user?.email)
                            AppPreferences.init(App.getAppContext())
                                .putString(Constants.USER_ID, login?.user?.id.toString())
                            AppPreferences.init(App.getAppContext())
                                .putString(Constants.TOKEN, login?.accessToken)
                            mutableLiveData.value = login

                        }


                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else
            {
            }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return mutableLiveData
    }


//.................................checkin.......................................


    fun checkin(requestObject: JSONObject): LiveData<CheckInResponse>
    {
        val mutableLiveData: MutableLiveData<CheckInResponse> = MutableLiveData()
        val requestBody: RequestBody =
            requestObject.toString().toRequestBody("application/json".toMediaType())
        val call = apiInterface.checkIn(requestBody)
        call.enqueue(object : Callback<CheckInResponse>
        {
            override fun onResponse(call: Call<CheckInResponse>, response: Response<CheckInResponse>) {
                if (response.isSuccessful) {
                    try {
                        val checkin: CheckInResponse? = response.body()
                        mutableLiveData.value = checkin

                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else
                {
                }
            }

            override fun onFailure(call: Call<CheckInResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return mutableLiveData
    }



    //.................................checkout.......................................


    fun checkOut(requestObject: JSONObject): LiveData<CheckInResponse>
    {
        val mutableLiveData: MutableLiveData<CheckInResponse> = MutableLiveData()
        val requestBody: RequestBody =
            requestObject.toString().toRequestBody("application/json".toMediaType())
        val call = apiInterface.checkOut(requestBody)
        call.enqueue(object : Callback<CheckInResponse>
        {
            override fun onResponse(call: Call<CheckInResponse>, response: Response<CheckInResponse>) {
                val checkInResponse: CheckInResponse? = response.body()
                if (response.isSuccessful) {
                    try {
                        val checkout: CheckInResponse? = response.body()
                        mutableLiveData.value = checkout



                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else
                {
                }
            }

            override fun onFailure(call: Call<CheckInResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return mutableLiveData
    }


//>.............................home.........................................

    fun getHome(userid: String): LiveData<List<DataItems>>
    {
        val mutableLiveData: MutableLiveData<List<DataItems>> = MutableLiveData()
        val call = apiInterface.getHomeapi(userid.toInt())
        call?.enqueue(object : Callback<HomeResponse> {
            override fun onResponse(
                call: Call<HomeResponse>,
                response: Response<HomeResponse>
            ) {
                if (response.isSuccessful) {
                    try {
                        val homeResponse: HomeResponse? = response.body()
                        Log.e("msg", homeResponse?.data?.get(0)?.addressCity.toString())

                        homeList = homeResponse?.data as ArrayList<DataItems>
                        mutableLiveData.value = homeList
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else {
                }
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return mutableLiveData
    }


    //>.............................esrow.........................................

    fun getEscrow(userid: String): LiveData<EscrowResponse>
    {
        val mutableLiveData: MutableLiveData<EscrowResponse> = MutableLiveData()
        val call = apiInterface.getEscrowapi(userid.toInt())
        call?.enqueue(object : Callback<EscrowResponse> {
            override fun onResponse(
                call: Call<EscrowResponse>,
                response: Response<EscrowResponse>
            ) {
                if (response.isSuccessful) {
                    try {
                        val escrowResponse: EscrowResponse? = response.body()
                        Log.e("msg", escrowResponse?.walletBalance?.tokens.toString()+"")

                        mutableLiveData.value = escrowResponse
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else {
                }
            }

            override fun onFailure(call: Call<EscrowResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return mutableLiveData
    }


    //////////////////////****************detail API *********************/////////////////

    fun getDetails(userid: String, mCompaing_id: String?): LiveData<DetailResponse>
    {
        val mutableLiveData: MutableLiveData<DetailResponse> = MutableLiveData()
        val call = apiInterface.getDetailapi(mCompaing_id?.toInt(),userid.toInt())
        call?.enqueue(object : Callback<DetailResponse> {
            override fun onResponse(call: Call<DetailResponse>, response: Response<DetailResponse>) {
                if (response.isSuccessful) {
                    try {
                        val checkout: DetailResponse? = response.body()
                        mutableLiveData.value = checkout



                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else
                {
                }
            }

            override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return mutableLiveData
    }

                ////************** Completed API ***************\\

    fun getCompleted(userid: String): LiveData<List<DataItemCom>>
    {
        val mutableLiveData: MutableLiveData<List<DataItemCom>> = MutableLiveData()
        val call = apiInterface.getCompletedapi(userid.toInt())
        call?.enqueue(object : Callback<CompletedResponse> {
            override fun onResponse(
                call: Call<CompletedResponse>,
                response: Response<CompletedResponse>
            ) {
                if (response.isSuccessful) {
                    try {
                        val completedResponse: CompletedResponse? = response.body()
                        Log.e("msg", completedResponse?.data?.get(0)?.addressCity.toString())

                        compl_List = completedResponse?.data as ArrayList<DataItemCom>
                        mutableLiveData.value = compl_List
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else {
                }
            }

            override fun onFailure(call: Call<CompletedResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return mutableLiveData
    }
}

