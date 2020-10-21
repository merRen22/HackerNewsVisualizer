package com.hacker.hackernewsvisualizer.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.hacker.hackernewsvisualizer.R
import com.hacker.hackernewsvisualizer.extension.viewModelProvider
import com.hacker.hackernewsvisualizer.viewmodel.PublicationsViewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = host_fragment.findNavController()
    }
}