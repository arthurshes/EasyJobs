package com.example.easyjobs.network

import com.example.easyjobs.network.model.Content
import com.example.easyjobs.network.model.GetUser
import com.example.easyjobs.network.model.SignInStatus
import com.example.easyjobs.network.model.UserModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("appkey: 1234")
    @POST("superjob/api/worker/")
    suspend fun signInUser(@Body userModel: UserModel):SignInStatus

    @Headers("appkey: 1234")
    @GET("superjob/api/worker/marvel2/")
    suspend fun getUser():GetUser
}
