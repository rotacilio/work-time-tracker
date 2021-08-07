package br.com.rotacilio.worktimetracker.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import br.com.rotacilio.worktimetracker.R
import br.com.rotacilio.worktimetracker.databinding.FragmentSigninBinding
import br.com.rotacilio.worktimetracker.viewmodels.SignInViewModel

class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        val binding =
            DataBindingUtil.inflate<FragmentSigninBinding>(
                inflater, R.layout.fragment_signin, container, false)
        binding.signInViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.goToRegister.observe(viewLifecycleOwner, Observer { goToRegister ->
            if (goToRegister) {
                this.findNavController()
                    .navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
                viewModel.doneRegister()
            }
        })

        return binding.root
    }
}