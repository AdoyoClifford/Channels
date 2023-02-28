package com.adoyo.channels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

   // private val channel1 = Channel<Language>()

    init {
        viewModelScope.launch { 
//            Log.d("MainViewModel","Kotlin sent")
//            channel1.send(Language.Kotlin)
//            Log.d("MainViewModel","Java sent")
//            channel1.send(Language.Java)
        }

        viewModelScope.launch {  }
    }

    enum class Language {
        Java,
        Kotlin,
        Python,
        Javascript,
        Go
    }
}