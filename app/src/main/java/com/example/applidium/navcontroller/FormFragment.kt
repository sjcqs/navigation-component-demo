package com.example.applidium.navcontroller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.fragment_form.*

class FormFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        okButton.setOnClickListener {
            navigateToWelcome()
        }
        surnameInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                navigateToWelcome()
                true
            } else {
            false
            }
        }
        toolbar.setNavigationOnClickListener {
            // Up navigation
            view.findNavController().navigateUp()
        }
    }

    private fun navigateToWelcome() {
        if (nameInput.text.isNullOrEmpty() || surnameInput.text.isNullOrEmpty()) {
            return
        }
        val name = nameInput.text.toString()
        val surname = surnameInput.text.toString()

        val navController = NavHostFragment.findNavController(this)
        /*
        // Passing args using bundle
        val bundle = Bundle().apply {
            putString("name", name)
            putString("surname", surname)
        }
        navController.navigate(R.id.showWelcomeScreenAction, bundle
        */

        // Passing args using class generated by safe-args
        val action =
            FormFragmentDirections.showWelcomeScreenAction(name, surname)
        navController.navigate(action)
    }

}
