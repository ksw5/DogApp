package com.example.dogapp.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.dogapp.DogApplication
import com.example.dogapp.R
import com.example.dogapp.model.data.DogDao
import com.example.dogapp.model.data.DogDatabase
import com.example.dogapp.model.repository.DogRepository
import com.example.dogapp.viewmodel.DogViewModel
import com.example.dogapp.viewmodel.DogViewModelFactory

class MainActivity : AppCompatActivity() {
    //lateinit var viewModel: DogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //val dogDao() = DogDao
        //val dogRepository = DogRepository(DogDatabase.getInstance(this))
        //val viewModelProviderFactory = DogViewModelFactory(dogDao)
        //viewModel = ViewModelProvider(this, viewModelProviderFactory).get(DogViewModel::class.java)

        setSupportActionBar(findViewById(R.id.toolBar))
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        val config = AppBarConfiguration(navController.graph)
        findViewById<Toolbar>(R.id.toolBar).setupWithNavController(navController, config)

        supportActionBar?.setTitle("Home")
    }
}