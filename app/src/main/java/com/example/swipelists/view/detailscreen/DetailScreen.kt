package com.example.swipelists.view.detailscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.swipelists.R
import com.example.swipelists.domain.Car

@Composable
fun DetailScreen(car: Car) {
    Column(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.fillMaxSize().padding(horizontal = 12.dp)) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = car.brand.toString(), style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = car.model.toString(), style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(12.dp))
            Row(Modifier.fillMaxWidth()) {
                Text(text = car.hp.toString(), style = TextStyle(fontSize = 18.sp))
                Spacer(modifier = Modifier.width(12.dp))
                Text(text = car.motor.toString(), style = TextStyle(fontSize = 18.sp))
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = car.description ?: "Sin Descripción", style = TextStyle(fontSize = 18.sp, fontStyle = FontStyle.Italic))
        }
    }
}