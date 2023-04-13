package com.example.easyjobs.viewModels

import androidx.lifecycle.*
import com.example.easyjobs.db.ChatItemEntity
import com.example.easyjobs.network.model.admodel.AdWorkerModel
import com.example.easyjobs.network.model.modeluser.GetUser
import com.example.easyjobs.repo.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val repo: MainRepo) :
    ViewModel() {
//    val allNotes: LiveData<List<AdWorkerModel>> = apiService.getAds().asLiveData()

    // var allNotes: LiveData<List<AdWorkerModel>> =repo.getAllAds().asLiveData()
    var allAds: MutableLiveData<List<AdWorkerModel>> = MutableLiveData()          ///////КОМЕНТЫ НЕ УДАЛЯТЬ

    val allItemChat: LiveData<List<AdWorkerModel>> = repo.dao.getAllChatItems().asLiveData()

   // val allItemChat: MutableLiveData<List<AdWorkerModel>> =MutableLiveData()

    /*  suspend fun getAdsApi(adapter: AdsAdapter) =viewModelScope.launch{
          viewModelScope.launch (Dispatchers.IO){
              val response = repo.getAllAds()
              allNotes.postValue(response)
          }

              allNotes.observe()
        }*/
    suspend fun getAdsApi() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repo.getAllAds()
            allAds.postValue(response)
        }
    }

    suspend fun signInRepo(token: String, name: String, age: Int, town: String): Boolean {
        return repo.signIn(token, name, age, town)
    }

    suspend fun getUser(id: String?): GetUser = repo.getUser(id)

    /*CHATDB*/
    fun insertChatItem(chatItem: ChatItemEntity) = viewModelScope.launch {
        repo.insertChatItem(chatItem)
    }
}