package br.com.rotacilio.worktimetracker.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.rotacilio.worktimetracker.database.ObjectBox
import br.com.rotacilio.worktimetracker.models.User
import io.objectbox.android.AndroidScheduler
import io.objectbox.query.Query
import io.objectbox.reactive.DataSubscription

class SignUpViewModel : ViewModel() {

    val firstName = MutableLiveData<String>()
    val lastName = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val confirmPassword = MutableLiveData<String>()

    private val _cancel = MutableLiveData<Boolean>()
    val cancel: LiveData<Boolean> get() = _cancel

    private val _allUsers = MutableLiveData<List<User>>()
    val allUsers: LiveData<List<User>> get() = _allUsers

    private val userBox = ObjectBox.boxStore.boxFor(User::class.java)

    init {
        firstName.value = ""
        lastName.value = ""
        email.value = ""
        password.value = ""
        confirmPassword.value = ""
        _cancel.value = false

        _allUsers.value = userBox.all
    }

    fun onRegister() {
        val user = User(
            firstName = firstName.value!!,
            lastName = lastName.value!!,
            email = email.value!!,
            password = password.value!!
        )
        userBox.put(user)
        _allUsers.value = userBox.all
    }

    fun onCancel() {
        _cancel.value = true
    }

    fun doneCancel() {
        _cancel.value = false
    }
}