package com.example.swipelists.view.detailscreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.swipelists.view.carsscreen.CarsViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(carsViewModel: CarsViewModel) {
    val car = carsViewModel.currentCar.value!!

    Column(Modifier.fillMaxSize()) {
        GlideImage(
            model = car.photo,
            contentDescription = "Imagen de ${car.brand} ${car.model}",
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = car.brand.toString(),
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = car.model.toString(),
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(Modifier.fillMaxWidth()) {
                Text(text = car.hp.toString(), style = TextStyle(fontSize = 18.sp))
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = car.motor.toString(), style = TextStyle(fontSize = 18.sp))
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = car.description ?: "Sin descripción",
                style = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Italic)
            )
        }
    }
}