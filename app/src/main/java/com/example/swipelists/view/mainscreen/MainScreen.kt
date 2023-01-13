package com.example.swipelists.view.mainscreen

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import com.example.swipelists.view.carsscreen.CarScreen
import com.example.swipelists.view.carsscreen.VehicleViewModel

@Composable
fun MainScreen(vehicleViewModel: VehicleViewModel) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { MainTopAppBar(vehicleViewModel = vehicleViewModel) },
        content = { CarScreen(vehicleViewModel = vehicleViewModel) }
    )
}