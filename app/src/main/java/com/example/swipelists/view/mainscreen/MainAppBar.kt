package com.example.swipelists.view.mainscreen

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.swipelists.R
import com.example.swipelists.view.carsscreen.CarsViewModel

@Composable
fun MainTopAppBar(carsViewModel: CarsViewModel) {
    TopAppBar(
        title = { Text(text = "Garaje") },
        actions = {
            IconButton(onClick = { carsViewModel.showDialog() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = "Add car"
                )
            }
        }
    )
}