package br.com.rotacilio.worktimetracker.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.rotacilio.worktimetracker.database.dao.UserDao
import br.com.rotacilio.worktimetracker.models.User

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

    private val userDao = UserDao()

    init {
        firstName.value = ""
        lastName.value = ""
        email.value = ""
        password.value = ""
        confirmPassword.value = ""
        _cancel.value = false

        _allUsers.value = userDao.findAll()
    }

    fun onRegister() {
        val user = User(
            firstName = firstName.value!!,
            lastName = lastName.value!!,
            email = email.value!!,
            password = password.value!!
        )
        userDao.insert(user)
        _allUsers.value = userDao.findAll()
    }

    fun onCancel() {
        _cancel.value = true
    }

    fun doneCancel() {
        _cancel.value = false
    }
}