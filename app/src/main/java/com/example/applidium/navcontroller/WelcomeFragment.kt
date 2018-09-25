package com.example.applidium.navcontroller


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_welcome.*


class WelcomeFragment : Fragment(), LifecycleObserver {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        lifecycle.addObserver(this)
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setNavigationOnClickListener { v ->
            v.findNavController().navigateUp()
        }
        button.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_randomFragment)
        )
    }

    override fun onDestroyView() {
        lifecycle.removeObserver(this)
        super.onDestroyView()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartEvent() {
        /*
        // parse args using bundle
        val arguments = arguments ?: return // no args error
        val name: String
        val surname: String
        name = arguments.getString("name")
        surname = arguments.getString("surname")*/

        // parse args using generated class
        val args = WelcomeFragmentArgs.fromBundle(arguments)
        val text = getString(R.string.welcome_text, args.name, args.surname)
        welcomeText.text = text
    }

}
