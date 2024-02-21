package com.example.poc

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.poc.fragment.ComposeFragment
import com.example.poc.fragment.XMLFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(R.layout.main_activity) {
    private lateinit var composeFragment: ComposeFragment
    private lateinit var xmlFragment: XMLFragment
    private var currentFragment="Compose"
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Lazy Column"
        super.onCreate(savedInstanceState)
        composeFragment = supportFragmentManager.findFragmentByTag("ComposeFragment") as? ComposeFragment
            ?: ComposeFragment()
        xmlFragment = supportFragmentManager.findFragmentByTag("XMLFragment") as? XMLFragment
            ?: XMLFragment()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, composeFragment, "ComposeFragment")
                .add(R.id.fragment_container_view, xmlFragment, "XMLFragment")
                .hide(xmlFragment)
                .commit()
        }
        showFragment(composeFragment)
       val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.home -> {
                    if(currentFragment=="XML")
                    showFragment(composeFragment)
                    currentFragment="Compose"
                    supportActionBar?.title = "Lazy Column"
                    true
                }

                else -> {
                    if(currentFragment=="Compose")
                    showFragment(xmlFragment)
                    currentFragment="XML"
                    supportActionBar?.title = "Recycler View"
                    true
                }
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                if (fragment == composeFragment) {
                    show(composeFragment)
                    hide(xmlFragment)
                } else {
                    show(xmlFragment)
                    hide(composeFragment)
                }
            }
            .commit()
    }
}
