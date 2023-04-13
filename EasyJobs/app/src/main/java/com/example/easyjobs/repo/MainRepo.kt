package com.example.easyjobs.repo

import com.example.easyjobs.db.ChatItemEntity
import com.example.easyjobs.db.MainDb
import com.example.easyjobs.network.ApiService
import com.example.easyjobs.network.model.modeluser.Content
import javax.inject.Inject


class MainRepo @Inject constructor(private val apiService: ApiService,private  val mainDb: MainDb) {
     val dao = mainDb.getDao()

    suspend fun getAllAds() = apiService.getAds()
     //fun getAllChatItem() =dao.getAllChatItems()
    suspend fun insertChatItem(chatItem: ChatItemEntity) =dao.insertChatItem(chatItem)

 suspend fun  getUser(id:String?) = apiService.getUser(id)

    suspend fun signIn(token: String, name: String, age: Int, town: String): Boolean {
        val user = Content(
            token = token,
            name,
            age,
            town
        )
        return apiService.signInUser(user).status
    }
}