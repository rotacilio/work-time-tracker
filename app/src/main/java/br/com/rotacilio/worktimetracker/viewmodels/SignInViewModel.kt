package br.com.rotacilio.worktimetracker.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {

    private val _goToRegister = MutableLiveData<Boolean>()
    val goToRegister: LiveData<Boolean> get() = _goToRegister

    init {
        _goToRegister.value = false
    }

    fun onRegister() {
        _goToRegister.value = true
    }

    fun doneRegister() {
        _goToRegister.value = false
    }
}