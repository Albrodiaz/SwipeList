package com.example.swipelists.view.carsscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.swipelists.R
import com.example.swipelists.domain.Car

@Composable
fun ActionsColumn(car: Car, showCar: (Car) -> Unit, deleteCar: (Car) -> Unit) {
    Column(
        Modifier
            .height(140.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.End
    ) {
        IconButton(
            modifier = Modifier.size(75.dp),
            onClick = { deleteCar(car) },
            content = {
                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.ic_delete),
                    tint = Color.Red,
                    contentDescription = "delete action",
                )
            }
        )
        IconButton(
            modifier = Modifier.size(75.dp),
            onClick = { showCar(car) },
            content = {
                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = R.drawable.ic_show),
                    tint = Color.Gray,
                    contentDescription = "show action",
                )
            }
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun ActionPreview() {
    ActionsColumn()
}*/
