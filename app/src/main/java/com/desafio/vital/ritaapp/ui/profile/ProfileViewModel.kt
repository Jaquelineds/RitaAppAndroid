package com.desafio.vital.ritaapp.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val _textName = MutableLiveData<String>().apply {
        value = "Joice Cazanoski Gomes"
    }
    val textName: LiveData<String> = _textName

    private val _textAccount = MutableLiveData<String>().apply {
        value = "Conta beneficiária do Plano Unimed"
    }
    val textAccount: LiveData<String> = _textAccount


}