package com.view.commitgood.controller.Services

import com.view.commitgood.controller.Utils.Constants
import com.view.commitgood.model.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface APIInterface{

    //login
    @POST(Constants.API_LOGIN)
    fun login(
        @Body requestBody: RequestBody
    ): Call<LoginResponse>

    //checkIn
    @POST(Constants.API_CHECKIN)
    fun checkIn(
        @Body requestBody: RequestBody
    ): Call<CheckInResponse>

    //checkIn
    @POST(Constants.API_CHECKOUT)
    fun checkOut(
        @Body requestBody: RequestBody
    ): Call<CheckInResponse>

    //home
    @Headers("Content-Type: application/json")
    @POST(Constants.API_HOME)
    fun getHomeapi(
        @Query("user_id") userid: Int,

        ): Call<HomeResponse>?

            //Completed
    @Headers("Content-Type: application/json")
    @POST(Constants.API_COMPLETED)
    fun getCompletedapi(
        @Query("user_id") userid: Int,

        ): Call<CompletedResponse>?

    //getescrow
    @Headers("Content-Type: application/json")
    @GET(Constants.API_ESCROW)
    fun getEscrowapi(
        @Query("user_id") userid: Int,

        ): Call<EscrowResponse>?

    //getDetail
    @Headers("Content-Type: application/json")
    @GET(Constants.API_DETAIL)
    fun getDetailapi(
        @Path("id") id:Int?,
        @Query("user_id") userid: Int,): Call<DetailResponse>?

}