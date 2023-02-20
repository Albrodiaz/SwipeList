package com.example.swipelists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.swipelists.ui.theme.SwipeListsTheme
import com.example.swipelists.view.adddialog.AddViewModel
import com.example.swipelists.view.carsscreen.CarsViewModel
import com.example.swipelists.view.detailscreen.DetailScreen
import com.example.swipelists.view.mainscreen.MainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val carsViewModel: CarsViewModel by viewModels()
        val addViewModel: AddViewModel by viewModels()

        setContent {
            SwipeListsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()
                    NavHost(navController = navigationController, startDestination = "mainScreen") {
                        composable("mainScreen") {
                            MainScreen(
                                navigationController = navigationController,
                                carsViewModel = carsViewModel,
                                addViewModel = addViewModel
                            )
                        }
                        composable("detailScreen") { DetailScreen(carsViewModel = carsViewModel, navigationController = navigationController) }
                    }
                }
            }
        }
    }
}