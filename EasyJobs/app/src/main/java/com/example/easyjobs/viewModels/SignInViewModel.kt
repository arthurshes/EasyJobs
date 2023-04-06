package com.example.easyjobs.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.room.Query
import com.example.easyjobs.network.ApiService
import com.example.easyjobs.network.model.admodel.AdWorkerModel
import com.example.easyjobs.network.model.modeluser.Content
import com.example.easyjobs.network.model.modeluser.GetUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val apiService: ApiService) : ViewModel() {
    val allNotes: LiveData<List<AdWorkerModel>> = apiService.getAds().asLiveData()

    suspend fun signIn(token: String, name: String, age: Int, town: String): Boolean {
        val user = Content(
            token = token,
            name,
            age,
            town
        )
        return apiService.signInUser(user).status
    }
    suspend fun getUser(id:String?): GetUser {
        return apiService.getUser(id!!)
    }

}