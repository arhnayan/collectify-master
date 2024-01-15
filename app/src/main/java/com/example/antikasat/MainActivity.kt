package com.example.antikasat

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var bottomNavigationView: BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.Antiques -> Toast.makeText(
                    applicationContext,
                    "Clicked Antiques",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.Art -> Toast.makeText(applicationContext, "Clicked Art", Toast.LENGTH_SHORT)
                    .show()

                R.id.Books -> Toast.makeText(
                    applicationContext,
                    "Clicked Books",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.Coins -> Toast.makeText(
                    applicationContext,
                    "Clicked Coins",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.Comics -> Toast.makeText(
                    applicationContext,
                    "Clicked Comics",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.Figures -> Toast.makeText(
                    applicationContext,
                    "Clicked Figures",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.Jewellery -> Toast.makeText(
                    applicationContext,
                    "Clicked Jewellery",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.PostCards -> Toast.makeText(
                    applicationContext,
                    "Clicked PostCards",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.Sports_Memorabillia -> Toast.makeText(
                    applicationContext,
                    "Clicked Sports Memorabillia",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.Stamps -> Toast.makeText(
                    applicationContext,
                    "Clicked Stamps",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.Toys -> Toast.makeText(applicationContext, "Clicked Toys", Toast.LENGTH_SHORT)
                    .show()

                R.id.Video_games -> Toast.makeText(
                    applicationContext,
                    "Clicked Videogames",
                    Toast.LENGTH_SHORT
                ).show()


            }
            true
        }


        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Profile1 -> {
                    replaceFragment(Profile())
                    true
                }

                R.id.Home1 -> {
                    replaceFragment(Home())
                    true
                }

                R.id.Message1 -> {
                    replaceFragment(Messages())
                    true
                }

                else -> false
            }
        }

        replaceFragment(Home())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_posts, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        when (item.itemId) {
            R.id.menu_profile -> {
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(this, Login::class.java))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
    }

}
