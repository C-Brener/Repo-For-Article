package com.caiquebrener.artigodenavegao

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.caiquebrener.artigodenavegao.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        setupNavigation()
        setupClickListener()
    }

    private fun setupClickListener() {
        binding.navigateForDetails.setOnClickListener {
            navController.navigate(ListFragmentDirections.actionListFragmentToDetailsFragment())
        }
        binding.backForListFragment.setOnClickListener {
            navController.navigate(DetailsFragmentDirections.actionDetailsFragmentToListFragment())
        }
    }

    private fun setupNavigation() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
    }
}
