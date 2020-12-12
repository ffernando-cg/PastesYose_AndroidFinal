package com.example.appfinalexamen.Controlador

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.appfinalexamen.R
import me.ibrahimsn.lib.SmoothBottomBar


class BottomBarFragmentController : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_bar_fragment_controller)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var navController: NavController = findNavController(R.id.nav_host_fragment)
        val bottomBar: SmoothBottomBar = findViewById(R.id.bottomBar);
        menuInflater.inflate(R.menu.menu_nav,menu)
        bottomBar.setupWithNavController(menu!!,navController)
        return true
    }
}