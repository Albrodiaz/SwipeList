package com.example.swipelists.view.mainscreen

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import com.example.swipelists.view.adddialog.AddViewModel
import com.example.swipelists.view.carsscreen.CarScreen
import com.example.swipelists.view.carsscreen.CarsViewModel

@Composable
fun MainScreen(carsViewModel: CarsViewModel, addViewModel: AddViewModel) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { MainTopAppBar(carsViewModel = carsViewModel) },
        content = { CarScreen(carsViewModel = carsViewModel, addViewModel = addViewModel) }
    )
}