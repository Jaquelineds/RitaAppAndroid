package com.desafio.vital.ritaapp.ui.bot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BotViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is bot Fragment"
    }
    val text: LiveData<String> = _text
}