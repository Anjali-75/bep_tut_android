package com.example.tut_bep_android.api

import com.example.tut_bep_android.models.AllUsersInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/users")
    fun getAllUsers(@Query("page") page:String): Call<AllUsersInfo>

}

