package br.com.rotacilio.worktimetracker.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import br.com.rotacilio.worktimetracker.R
import br.com.rotacilio.worktimetracker.databinding.FragmentSigninBinding

class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate<FragmentSigninBinding>(
                inflater, R.layout.fragment_signin, container, false)

        binding.btnSignUp.setOnClickListener {
            it.findNavController()
                .navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        }

        return binding.root
    }
}