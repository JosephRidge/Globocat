package com.jayr.globalchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        get Navhost and Navcontroller
        val navHostFrag = supportFragmentManager.findFragmentById(R.id.nav_host_frag) as NavHostFragment
        navController = navHostFrag.navController

//        get AppBar COonfiguration
        appBarConfiguration = AppBarConfiguration(navController.graph)

//        Link Action Bar with NavController - here
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

//    / responsible for up navigation of up bar
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)  || super.onSupportNavigateUp()
    }
}