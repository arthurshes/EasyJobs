package com.example.easyjobs.utils

import android.content.Context
import android.widget.Toast

object ToastHelper {
    fun showToast(text: String,context: Context) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
}