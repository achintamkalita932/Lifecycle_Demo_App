package com.example.android.lifecycledemo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.android.lifecycledemo.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        Toast.makeText(this, "In onCreate" , Toast.LENGTH_SHORT).show()

        Log.i("info", "In onCreate")
    }

    override fun onStart() {
        //First call the "official" version of this function
        super.onStart()

        Toast.makeText(this, "In onStart",
            Toast.LENGTH_SHORT).show()

        Log.i("info", "In onStart")
    }

    override fun onResume() {
        // First call the "official" version of this function
        super.onResume()

        Toast.makeText(this, "In onResume", Toast.LENGTH_SHORT).show()

        Log.i("info", "In onResume")
    }

    override fun onPause() {
        // First call the "official" version of this function
        super.onPause()

        Toast.makeText(this, "In onPause",
            Toast.LENGTH_SHORT).show()

        Log.i("info", "In onPause")
    }

    override fun onStop() {
        // First call the "official" version of the function
        super.onStop()

        Toast.makeText(this, "In onStop",
            Toast.LENGTH_SHORT).show()

        Log.i("info", "In onStop")
    }

    override fun onDestroy() {
        // First call the "official" version of the function
        super.onDestroy()

        Toast.makeText(this, "In onDestroy",
            Toast.LENGTH_SHORT).show()

        Log.i("info", "In onDestroy")
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

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}