package com.rickyandrean.remoney

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.rickyandrean.remoney.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Hide support action bar
        supportActionBar?.hide()

        // Connect fragment for each page to navigation controller
        val navController = findNavController(R.id.navigationHost)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_expenses,
                R.id.navigation_loans,
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigation.setupWithNavController(navController)

        // Event listener
        binding.cvNotification.setOnClickListener(this)
        binding.cvSetting.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cvNotification -> Toast.makeText(this, "Ini Notification", Toast.LENGTH_SHORT).show()
            R.id.cvSetting -> Toast.makeText(this, "Ini Setting", Toast.LENGTH_SHORT).show()
            R.id.cvFriend -> Toast.makeText(this, "Ini Friend", Toast.LENGTH_SHORT).show()
        }
    }
}