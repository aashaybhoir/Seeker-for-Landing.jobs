package com.blacklimon.landing_seeker.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.blacklimon.landing_seeker.R

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.menuProfile -> {
                Toast.makeText(applicationContext,"Clicked ", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menuSaved -> {

                true
            }
            R.id.menuSettings -> {

                true
            }
            R.id.menu_about -> {

                true
            }
            R.id.menuExit -> {
                finishAndRemoveTask()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}