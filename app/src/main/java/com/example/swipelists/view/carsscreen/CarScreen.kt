package com.example.swipelists.view.carsscreen

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.swipelists.domain.Car
import com.example.swipelists.view.adddialog.AddDialog
import com.example.swipelists.view.adddialog.AddViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarScreen(
    navigationController: NavHostController,
    carsViewModel: CarsViewModel,
    addViewModel: AddViewModel
) {
    val cars: List<Car> = carsViewModel.carList
    val isLoading: Boolean by carsViewModel.isLoading.observeAsState(initial = true)
    val showDialog: Boolean by carsViewModel.showDialog.observeAsState(initial = false)

    LazyColumn(Modifier.fillMaxSize()) {
        if (!isLoading) {
            items(
                items = cars,
                key = { carKey -> carKey.id }) { car ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .padding(6.dp)
                        .animateItemPlacement(
                            animationSpec = tween(600),
                        )
                ) {
                    ItemCar(
                        car = car,
                        deleteCar = { carsViewModel.deleteCar(it) },
                        showCar = {
                            carsViewModel.setCurrentCar(it)
                            navigationController.navigate("detailScreen")
                        }
                    )
                }
            }
        }
    }

    if (showDialog) {
        AddDialog(carsViewModel = carsViewModel, addViewModel = addViewModel)
    }
}