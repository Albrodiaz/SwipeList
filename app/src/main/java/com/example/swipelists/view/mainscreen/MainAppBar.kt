package com.example.swipelists.view.mainscreen

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.swipelists.R
import com.example.swipelists.domain.Car
import com.example.swipelists.view.carsscreen.VehicleViewModel

@Composable
fun MainTopAppBar(vehicleViewModel: VehicleViewModel) {
    TopAppBar(
        title = { Text(text = "Garaje") },
        actions = {
            IconButton(onClick = {
                vehicleViewModel.addCar(
                    Car(
                        System.currentTimeMillis(),
                        "Tesla",
                        "Model 3",
                        500,
                        2000,
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/2019_Tesla_Model_3_Performance_AWD_Front.jpg/1280px-2019_Tesla_Model_3_Performance_AWD_Front.jpg"
                    )
                )
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Add car"
                )
            }
        }
    )
}