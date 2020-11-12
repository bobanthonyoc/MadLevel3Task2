package com.example.madlevel3task2

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_add_portal.*
import kotlinx.android.synthetic.main.item_portal.*
import java.util.stream.DoubleStream.builder

class MainActivity : AppCompatActivity() {

    companion object {
        const val PORTAL = "portal"
    }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        navController = findNavController(R.id.nav_host_fragment)

        fab.setOnClickListener {
            navController.navigate(R.id.action_portalFragment_to_addPortalFragment)
        }
        fabToggler()

        /* val urllaunch = findViewById<View>(R.id.rvPortal) as Button
        urllaunch.setOnClickListener(View.OnClickListener {
            var url = portalUrl
            val builder = CustomTabsIntent.Builder()

            val anotherCustom = CustomTabsIntent.Builder().build()
            val customTabsIntent = builder.build()
            customTabsIntent.launchUrl(this, Uri.parse(url.toString()) )

        }) */

    }

    private fun fabToggler() {
        navController.addOnDestinationChangedListener { _,       destination, _ ->
            if (destination.id in arrayOf(R.id.addPortalFragment)) {
                fab.hide()
            } else {
                fab.show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}