package com.example.madlevel3task2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madlevel3task2.MainActivity.Companion.PORTAL
import kotlinx.android.synthetic.main.fragment_portal.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PortalFragment : Fragment() {
    // extend the adapter to the clicklistener using a lambda
    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals) {
        // registred the clicklistener function to the adapter
            portal : Portal -> portalClicked(portal) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()

    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvPortal.layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        rvPortal.adapter = portalAdapter
        rvPortal.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        observeAddPortalResult()
    }

    // added result 'pull' logic from addportalfragment
    // used parcelable functions a strings from the model class are made parcelable
    private fun observeAddPortalResult() {
        setFragmentResultListener(PORTAL) { _, bundle ->
            bundle.getParcelable<Portal>(PORTAL)?.let {
                portals.add(it)
            }?: Log.e("Portal!", "Request triggered, but empty reminder text!")
        }

    }

    // created a method that handles the clicklistener.
    // also added url browser logic to the function
    private fun portalClicked(portal: Portal) {

        val url = portal.portalUrl
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

        startActivity(intent)
    }


}