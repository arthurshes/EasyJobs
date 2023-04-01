package com.example.easyjobs.network

import com.example.easyjobs.network.model.Content
import com.example.easyjobs.network.model.GetUser
import com.example.easyjobs.network.model.SignInStatus
import com.example.easyjobs.network.model.UserModel
import retrofit2.http.*

interface ApiService {
    @Headers("appkey: 1234")
    @POST("superjob/api/worker/")
    suspend fun signInUser(@Body userModel: UserModel):SignInStatus

    @Headers("appkey: 1234")
    @GET("superjob/api/worker/{id}/")
    suspend fun getUser(@Path("id") id: String?):GetUser
}
