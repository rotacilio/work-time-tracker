package br.com.rotacilio.worktimetracker.screens.fragments

import android.os.Bundle
import android.util.Log
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
import br.com.rotacilio.worktimetracker.databinding.FragmentSignupBinding
import br.com.rotacilio.worktimetracker.viewmodels.SignUpViewModel

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        val binding =
            DataBindingUtil.inflate<FragmentSignupBinding>(
                inflater, R.layout.fragment_signup, container, false)
        binding.signUpViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.cancel.observe(viewLifecycleOwner, Observer { doCancel ->
            if (doCancel) {
                this.findNavController().popBackStack()
                viewModel.doneCancel()
            }
        })

        viewModel.allUsers.observe(viewLifecycleOwner, Observer { users ->
            Log.i("SignUpFragment", "onCreateView: users: ${users.size}")
        })

        return binding.root
    }
}