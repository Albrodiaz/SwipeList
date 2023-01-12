package com.example.swipelists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.swipelists.repository.CarProvider
import com.example.swipelists.ui.theme.SwipeListsTheme
import com.example.swipelists.view.carsscreen.CarViewModelFactory
import com.example.swipelists.view.carsscreen.VehicleViewModel
import com.example.swipelists.view.mainscreen.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vehicleViewModel: VehicleViewModel by viewModels { CarViewModelFactory(CarProvider()) }

        setContent {
            SwipeListsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(vehicleViewModel = vehicleViewModel)
                }
            }
        }
    }
}