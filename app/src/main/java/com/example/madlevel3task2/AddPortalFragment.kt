package com.example.madlevel3task2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.madlevel3task2.MainActivity.Companion.PORTAL
import kotlinx.android.synthetic.main.fragment_add_portal.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddPortalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddportal.setOnClickListener {
            onAddPortal()
        }

    }

    // created an onAddPortal function to import the incoming strings into a variable
    // Added a null check
    // Strings a imported into a bundle and added into setFragmentResult which will be called on later
    private fun onAddPortal() {
        val portalVak = etPortalVak.text.toString()
        val portalUrl = etPortalUrl.text.toString()

        if (portalVak.isNotBlank() and portalUrl.isNotBlank()) {
            //set the data as fragmentResult, we are listening for REQ_REMINDER_KEY in RemindersFragment!
            setFragmentResult(PORTAL, bundleOf(PORTAL to Portal(portalVak, portalUrl)))

            //"pop" the backstack, this means we destroy
            //this fragment and go back to the RemindersFragment
            findNavController().popBackStack()

        } else {
            Toast.makeText(
                activity,
                R.string.portal_not_valid, Toast.LENGTH_SHORT
            ).show()
        }
    }
}