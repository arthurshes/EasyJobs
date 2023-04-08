package com.example.easyjobs.viewModels

import androidx.lifecycle.*
import androidx.room.Query
import com.example.easyjobs.network.ApiService
import com.example.easyjobs.network.model.admodel.AdWorkerModel
import com.example.easyjobs.network.model.modeluser.Content
import com.example.easyjobs.network.model.modeluser.GetUser
import com.example.easyjobs.repo.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val repo: MainRepo) : ViewModel() {
//    val allNotes: LiveData<List<AdWorkerModel>> = apiService.getAds().asLiveData()
 var allNotes:MutableLiveData<List<AdWorkerModel>> = MutableLiveData()


    suspend fun getNotesApi(){
        viewModelScope.launch (Dispatchers.IO){
            val response = repo.getAllNotes()
            allNotes.postValue(response)
        }
    }
    suspend fun signInRepo(token: String, name: String, age: Int, town: String): Boolean{
        return repo.signIn(token, name, age, town)
    }

//    suspend fun getUser(id:String?): GetUser {
//        return apiService.getUser(id!!)
//    }

    suspend fun getUser(id:String?):GetUser = repo.getUser(id)
}