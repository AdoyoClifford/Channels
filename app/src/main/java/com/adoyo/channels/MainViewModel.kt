package com.adoyo.channels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModel : ViewModel() {

    // private val channel = Channel<Language>()
    private var channel: ReceiveChannel<Language> = Channel()

    init {
        viewModelScope.launch {
//            Log.d("MainViewModel","Kotlin sent")
//            channel.send(Language.Kotlin)
//            Log.d("MainViewModel","Java sent")
//            channel.send(Language.Java)
//            channel.close()
            channel = produce {
                send(Language.Kotlin)
                send(Language.Java)
            }
        }

        viewModelScope.launch {
//            Log.d("MainViewModel","${channel1.isClosedForReceive}")
//            Log.d("MainViewModel","${channel1.receive()}")
//            Log.d("MainViewModel","${channel1.receive()}")
//            Log.d("MainViewModel","${channel1.isClosedForReceive}")
            Log.d("MainViewModel", "${channel.isClosedForReceive}")

            channel.consumeEach {
                Log.d("MainViewModel", it.name)
            }
            Log.d("MainViewModel", "${channel.isClosedForReceive}")


        }
    }

    enum class Language {
        Java,
        Kotlin,
        Python,
        Javascript,
        Go
    }
}