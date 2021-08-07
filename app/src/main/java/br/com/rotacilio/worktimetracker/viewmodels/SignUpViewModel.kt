package br.com.rotacilio.worktimetracker.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val confirmPassword = MutableLiveData<String>()

    private val _cancel = MutableLiveData<Boolean>()
    val cancel: LiveData<Boolean> get() = _cancel

    init {
        firstName.value = ""
        lastName.value = ""
        email.value = ""
        password.value = ""
        confirmPassword.value = ""
        _cancel.value = false
    }

    fun onRegister() {
        Log.i("SignUpViewModel", "firstName: ${firstName.value}")
    }

    fun onCancel() {
        _cancel.value = true
    }

    fun doneCancel() {
        _cancel.value = false
    }
}