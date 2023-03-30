package com.example.easyjobs.viewModels

import androidx.lifecycle.ViewModel
import com.example.easyjobs.network.ApiService
import com.example.easyjobs.network.model.UserSignInModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class SignInViewModel @Inject constructor(private val apiService: ApiService):ViewModel() {

   suspend fun signIn(token:String,name:String,age:Int,town:String):Boolean{
       val user = UserSignInModel(
           token = token,
           name, age, town
       )
      return apiService.signInUser(user).status
    }
}