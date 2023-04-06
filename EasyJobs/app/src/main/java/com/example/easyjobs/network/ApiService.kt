package com.example.easyjobs.network

import androidx.room.Query
import com.example.easyjobs.network.model.admodel.AdWorkerModel
import com.example.easyjobs.network.model.modeluser.Content
import com.example.easyjobs.network.model.modeluser.GetUser
import kotlinx.coroutines.flow.Flow
import retrofit2.http.*

interface ApiService {
    @Headers("appkey: 1234")
    @POST("superjob/api/worker/")
    suspend fun signInUser(@Body userModel: Content): GetUser

    @Headers("appkey: 1234")
    @GET("superjob/api/worker/{id}/")
    suspend fun getUser(@Path("id") id: String?): GetUser

    @Headers("appkey: 1234")
    @GET("superjob/api/vacancy")
     fun getAds(): Flow<List<AdWorkerModel>>
}
