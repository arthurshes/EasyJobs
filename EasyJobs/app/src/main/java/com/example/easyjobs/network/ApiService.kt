package com.example.easyjobs.network

import com.example.easyjobs.network.model.SignInStatus
import com.example.easyjobs.network.model.UserSignInModel
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("superjob/api/worker/")
    suspend fun signInUser(@Body userSignInModel: UserSignInModel):SignInStatus
}
