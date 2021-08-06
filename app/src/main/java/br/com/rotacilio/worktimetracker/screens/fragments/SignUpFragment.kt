package br.com.rotacilio.worktimetracker.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import br.com.rotacilio.worktimetracker.R
import br.com.rotacilio.worktimetracker.databinding.FragmentSignupBinding

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate<FragmentSignupBinding>(
                inflater, R.layout.fragment_signup, container, false)

        binding.btnCancel.setOnClickListener {
            it.findNavController().popBackStack()
        }

        return binding.root
    }
}